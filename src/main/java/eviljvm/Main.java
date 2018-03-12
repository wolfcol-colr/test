package eviljvm;

import java.lang.instrument.Instrumentation;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void premain(String preArgs, Instrumentation inst) {
        Thread t = new Thread(() -> {
            Map<Long, Long> blockBy = new HashMap<>();
            while (true) {
                try {
                    ThreadMXBean bean = ManagementFactory.getThreadMXBean();
                    long[] threadIds = bean.getAllThreadIds();
                    for (long id : threadIds) {
                        ThreadInfo info = bean.getThreadInfo(id);
                        if (info.getThreadState() == Thread.State.RUNNABLE || info.getLockOwnerId() == -1) {
                            continue;
                        }
                        if (info.getLockOwnerId() == id) {
                            System.err.println("Deadlock detected: ");
                            System.err.println(String.format("%s have aleady been held by the thread %s", info.getLockInfo(), id));
                            StackTraceElement[] trace = info.getStackTrace();
                            for (StackTraceElement traceElement : trace)
                                System.err.println("\t" + traceElement);
                            break;
                        }
                        if (blockBy.containsKey(info.getLockOwnerId())) {
                            ThreadInfo blk = info;
                            System.err.println("Deadlock detected: ");
                            do {
                                System.err.println(String.format("Thread-%s: (%s) blocked by object %s owned by Thread-%s: (%s) \n at:",
                                        blk.getThreadId(),
                                        blk.getThreadName(),
                                        blk.getLockInfo(),
                                        blk.getLockOwnerId(),
                                        blk.getLockOwnerName()));
                                StackTraceElement[] trace = blk.getStackTrace();
                                for (StackTraceElement traceElement : trace)
                                    System.err.println("\t" + traceElement);
                                blk = bean.getThreadInfo(blk.getLockOwnerId());
                            } while (blk.getThreadId() != id);
                            break;
                        } else {
                            blockBy.put(id, info.getLockOwnerId());
                        }
                    }
                    blockBy.clear();
                    Thread.sleep(10000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }
}
