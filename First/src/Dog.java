public class Dog extends Animal {
    private String gender;
    public void walk() {
        System.out.println("강아지가 산책을 합니다.");
    }
    //오버라이딩은 부모 클래스의 동작을 재정의!
    @Override
    public void speak() {
        System.out.println("월월");
    }
}