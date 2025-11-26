public class Expense {
    String title;
    Float amount;
    Expense(String title, Float amount) {
        this.title = title;
        this.amount = amount;
    }
    public String getTitle() {
        return title;
    }
    public Float getAmount() {
        return amount;
    }
    public String Display(){
        return getTitle() + " £" + getAmount();
    }
}
