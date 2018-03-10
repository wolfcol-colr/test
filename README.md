### Demo

```
public static void main(String[] args) throws Exception {
    Object res1 = new Object();
    Object res2 = new Object();
    Thread t1 = new Thread(()->{
        synchronized (res1) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (res2) {

            }
        }
    });
    t1.setName("t1");
    Thread t2 = new Thread(() -> {
        synchronized (res2) {
            synchronized (res1) {

            }
        }
    });
    t2.setName("t2");
    t1.start();
    t2.start();
    Thread.currentThread().join();
}
```

```
    java -javaagent:/path/to/deadlock-checker.jar nopackge.Main
    
    Deadlock detected: 
    Thread-11: (t1) blocked by object java.lang.Object@1f1b3da4 owned by Thread-12: (t2) 
     at:
    Thread-12: (t2) blocked by object java.lang.Object@5a19b883 owned by Thread-11: (t1) 
     at:
```
