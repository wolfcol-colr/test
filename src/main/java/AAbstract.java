public abstract class AAbstract implements A {

  public abstract void test();

  @Override
  public void hello() {
    System.out.println("A");
  }
}
