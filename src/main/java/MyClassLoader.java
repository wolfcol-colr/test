import java.nio.file.Files;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {

  protected Class<?> findClass(String name) throws ClassNotFoundException {
    try {
      byte[] bytecode = Files.readAllBytes(Paths.get("/tmp/java/lang/String.class"));
      return defineClass(name, bytecode, 0, bytecode.length);
    } catch (Exception e) {
      e.printStackTrace();
    }
    throw new ClassNotFoundException();
  }

  public static void main(String[] args) throws Exception {
    MyClassLoader classLoader = new MyClassLoader();
    classLoader.findClass("java.math.BigDecimal");
  }
}
