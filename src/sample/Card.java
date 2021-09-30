package sample;

public class Card {
    private double balance = 0;
    private int discount = 0;
    private CardType cardType = CardType.STANDARD;
    public enum CardType{
        STANDARD("Standard"),
        SILVER("Silver card"),
        GOLD("Gold card"),
        VIP("Vip card");

        private final String name;
        CardType(String name){
            this.name=name;
        }

        public String getName() {
            return name;
        }
    }

    public int sumBalance(double cost){ //Возвращает значение скидки
        this.balance+=cost;
        if (balance>=10000 && balance<=30000 && this.cardType==CardType.STANDARD) this.discount=5;
        if (balance>30000 && this.cardType==CardType.STANDARD) this.discount=10;
        if (balance>=50000 && this.cardType.ordinal()<CardType.SILVER.ordinal()) this.cardType=CardType.SILVER;
        if (balance>=50000 && balance<=80000 && this.cardType==CardType.SILVER) this.discount=10;
        if (balance>80000 && this.cardType==CardType.SILVER) this.discount=20;
        if (balance>=100000 && this.cardType.ordinal()<CardType.GOLD.ordinal()) this.cardType=CardType.GOLD;
        if (balance>=100000 && balance<=150000 && this.cardType==CardType.GOLD) this.discount=20;
        if (balance>150000 && this.cardType==CardType.GOLD) this.discount=30;
        if (balance>=200000 && this.cardType.ordinal()<CardType.VIP.ordinal()) this.cardType=CardType.VIP;
        if (balance>=200000 && balance<=300000 && this.cardType==CardType.VIP) this.discount=30;
        if (balance>300000 && this.cardType==CardType.VIP) this.discount=40;
        return this.discount;
    }

    public CardType getCardType() {
        return cardType;
    }

    public double getBalance() {
        return balance;
    }

    public int getDiscount() {
        return discount;
    }

    public void setBalance(double balance) {
        this.balance = balance;
        this.discount=0;
        if (balance>=10000 && balance<=30000 && this.cardType==CardType.STANDARD) this.discount=5;
        if (balance>30000 && this.cardType==CardType.STANDARD) this.discount=10;
        if (balance>=50000 && this.cardType.ordinal()<CardType.SILVER.ordinal()) this.cardType=CardType.SILVER;
        if (balance>=50000 && balance<=80000 && this.cardType==CardType.SILVER) this.discount=10;
        if (balance>80000 && this.cardType==CardType.SILVER) this.discount=20;
        if (balance>=100000 && this.cardType.ordinal()<CardType.GOLD.ordinal()) this.cardType=CardType.GOLD;
        if (balance>=100000 && balance<=150000 && this.cardType==CardType.GOLD) this.discount=20;
        if (balance>150000 && this.cardType==CardType.GOLD) this.discount=30;
        if (balance>=200000 && this.cardType.ordinal()<CardType.VIP.ordinal()) this.cardType=CardType.VIP;
        if (balance>=200000 && balance<=300000 && this.cardType==CardType.VIP) this.discount=30;
        if (balance>300000 && this.cardType==CardType.VIP) this.discount=40;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }
}
