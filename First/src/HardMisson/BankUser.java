package HardMisson;

public class BankUser {
    public static void main(String[] args) {
        WooriBank wooriBank=new WooriBank(0,"010-1234-5678","www.wooribank.com");
        //인스턴스 생성,힙에 할당되게 됩니당
        wooriBank.deposit(1000);
        wooriBank.checkMoney();
        wooriBank.withdraw(2000);// 에러 처리 발생~
    }



}
