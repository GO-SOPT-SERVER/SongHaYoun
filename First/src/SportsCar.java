public class SportsCar implements Car{
    @Override
    public void turnOn() {
        System.out.println("스포츠카 시동 부릉");
    }
    @Override
    public void turnOff() {
        System.out.println("스포츠카 시동 끄기");
    }
}
