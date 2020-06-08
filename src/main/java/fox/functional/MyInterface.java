package fox.functional;

@FunctionalInterface
public interface MyInterface {

    public void f();

    default public void f2(){}
}
