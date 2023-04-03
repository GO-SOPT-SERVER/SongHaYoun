public class Dog extends Animal {
    private String gender;
    public void walk() {
        System.out.println("강아지가 산책을 합니다.");
    }
    @Override
    public void speak() {
        System.out.println("월월");
    }
}