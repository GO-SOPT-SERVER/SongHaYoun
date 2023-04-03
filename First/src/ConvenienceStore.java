public class ConvenienceStore {

    String brand;
    String address;

    int staffCount;
    int visitorCount;

    public ConvenienceStore(String brand,String address,int staffCount,int visiotrCount){
        this.brand=brand;
        this.address=address;
        this.staffCount=staffCount;
        this.visitorCount=visiotrCount;
    }
    public void addStaffCount() {
        staffCount++;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public void addVisitorCount() {
        visitorCount++;
    }

    public void initVisitorCount() {
        visitorCount = 0;
    }

    public int getVisitorCount() {
        return visitorCount;
    }

    public void printConvenienceStoreInfo() {
        System.out.println("편의점 브랜드: " + brand);
        System.out.println("편의점 주소: " + address);
        System.out.println("편의점 직원 수: " + staffCount);
        System.out.println("편의점 방문자 수: " + visitorCount);
    }
}
