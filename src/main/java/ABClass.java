public class ABClass extends AAbstract implements B{

  @Override
  public void test() {

  }

  @Override
  public void hello() {
    System.out.println("B");
  }

  public static void main(String[] args) {
    A a = new ABClass();
    a.hello();
    B b = new ABClass();
    b.hello();
  }
}
