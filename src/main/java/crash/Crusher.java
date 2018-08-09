package crash;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Random;

public class Crusher {

    private static Unsafe unsafe;

    static {
        try {
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private Crusher() {
    }

    public static void crashVM() {
        Random r = new Random();
        unsafe.putAddress(r.nextLong(), r.nextLong());
    }
}
