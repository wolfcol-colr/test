public class Aimplementation implements A {

  private int hide = 1;

  protected int maybe = 2;

  public final int override = 3;

  public static void test() {

  }

  @Override
  public void hello() {
    System.out.println(String.format("hide=%s, maybe=%s, override=%s", hide, maybe, override));
  }
}
