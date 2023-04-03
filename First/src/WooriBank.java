public class WooriBank implements Bank{

    int currentMoney;
    String telephone;
    String webUrl;

    public WooriBank(int currentMoney,String telephone,String webUrl){
        this.currentMoney=currentMoney;
        this.telephone=telephone;
        this.webUrl=webUrl;
        System.out.println("은행 생성완료!");
    }
    @Override
    public void deposit(int money) {
        this.currentMoney=this.currentMoney+money;
        System.out.println(money+"만큼 입금되었습니다!");
    }

    @Override
    public void withdraw(int money){
        if(this.currentMoney-money<0){
            System.out.println("잔고가 부족해 출금할 수 없습니다!");
        }
        else{
        this.currentMoney=this.currentMoney-money;
        System.out.println(money+"만큼 출금되었습니다!");}
    };
    @Override
    public void checkMoney(){
        System.out.println("현재 은행에 남은 잔고는 "+this.currentMoney+"입니다!");
    };

}
