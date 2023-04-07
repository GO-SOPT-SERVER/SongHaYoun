class GenericClass <T, E> {
    T type;
    E element;
}
class GenericMethod {
    public <T> T genericMethod(T type) {
        return type;
    }
}
public class GenericTest {
    public static void main(String[] args) {
        GenericClass<Integer, String> genericClass = new GenericClass<Integer, String>();
        GenericMethod genericMethod = new GenericMethod();

        String hello = genericMethod.genericMethod("Hello");
        System.out.println(hello);
    }

}