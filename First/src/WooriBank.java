public class WooriBank implements Bank{

    int currentMoney;
    int telephone;
    int webUrl;

    @Override
    public void deposit(int money) {
        this.currentMoney=this.currentMoney+money;
        System.out.println(money+"만큼 입금되었습니다!");
    }

    @Override
    public void withdraw(int money){
        this.currentMoney=this.currentMoney-money;
        System.out.println(money+"만큼 출금되었습니다!");
    };
    @Override
    public void checkMoney(){
        System.out.println("현재 은행에 남은 잔고는 "+this.currentMoney+"입니다!");
    };

}
