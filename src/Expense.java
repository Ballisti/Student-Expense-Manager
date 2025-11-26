public class Expense {

    String title;
    double amount;

    Expense(String title, double amount) {
        this.title = title;
        this.amount = amount;
    }
    public String getTitle() {
        return title;
    }
    public double getAmount() {
        return amount;
    }
    public String display(){
        return getTitle() + " £" + getAmount();
    }
}
