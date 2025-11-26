public class DiscountedExpense extends Expense {

    float finalAmount;
    float discount;

    public DiscountedExpense(String title,float amount,float discount) {
        super(title,amount);
        this.finalAmount = this.amount*(1-discount/100);
    }

    public float getFinalAmount() {
        return finalAmount;
    }
    public float getDiscount() {
        return discount;
    }

    public String Display(){
        return super.Display()+" with discount of "+getDiscount()+"% = £"+getFinalAmount();
    }
}
