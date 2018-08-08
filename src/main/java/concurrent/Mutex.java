package concurrent;

import java.util.Optional;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

public class Mutex {

    private final static ConcurrentLinkedDeque<Thread> blocked = new ConcurrentLinkedDeque<>();

    private AtomicBoolean permit = new AtomicBoolean(true);

    public void lock() {
        // Spinlock
        for (int i = 0; i < 3; i++) {
            if (permit.compareAndSet(true, false)) {
                return;
            }
        }
        blocked.add(Thread.currentThread());
        while (true) {
            if (permit.compareAndSet(true, false)) {
                blocked.remove(Thread.currentThread());
                break;
            } else {
                LockSupport.park();
            }
        }
    }

    public void unlock() {
        permit.set(true);
        Optional.ofNullable(blocked.poll()).ifPresent(LockSupport::unpark);
    }
}
