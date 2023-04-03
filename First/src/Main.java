public class Main {
    public static void main(String[] args) {

        Animal animal=new Animal();
        animal.speak();

        ConvenienceStore firstGS = new ConvenienceStore("GS 25", "지구 어딘가", 8, 0);

        firstGS.addStaffCount();
        firstGS.addVisitorCount();

        firstGS.printConvenienceStoreInfo();
    }
}

