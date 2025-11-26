public class DiscountedExpense extends Expense {

    double finalAmount;
    double discount;

    public DiscountedExpense(String title,double amount,double discount) {
        super(title,amount);
        this.discount=discount;
        this.finalAmount = this.amount*(1-discount/100);
    }

    public double getFinalAmount() {
        return finalAmount;
    }
    public double getDiscount() {
        return discount;
    }

    public String display(){
        return super.display()+" with discount of "+getDiscount()+"% = £"+getFinalAmount();
    }
}
