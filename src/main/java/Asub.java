import org.openjdk.jol.info.ClassLayout;

public class Asub extends Amid implements B {

  private int hide = 11;

  private int a = 1;

  private boolean b = true;

//  protected int maybe = 22;

  private int override = 33;

  public static void test() {

  }

  private void privateMethod() {

  }

  public final void finalMethod() {

  }

  @Override
  public void hello() {
    super.hello();
    super.b = false;
    this.b = true;
    System.out.println(String.format("hide=%s, maybe=%s, override=%s", hide, maybe, override));
    System.out.println(String.format("hide=%s, maybe=%s, override=%s", hide, super.maybe, super.override));
    System.out.println("override from Asub");
  }

  public static void main(String[] args) {
    A a = new Asub();
    B bb = new Asub();
    Asub aa = new Asub();
    System.out.println(ClassLayout.parseInstance(aa).toPrintable());
    Amid aasuper = new Amid();
    System.out.println(ClassLayout.parseInstance(aasuper).toPrintable());
    aa.output();
    bb.hello();
    A b = new Aimplementation();
    Asub.test();
    Aimplementation.test();
    a.hello();
    b.hello();
    Aimplementation c = new Asub();
    c.hello();
    Asub d = new Asub();
    d.hello();
    d.privateMethod();
    d.finalMethod();
    d.mid();
    System.out.println(d.b);
  }
}
