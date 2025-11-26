
//requires jdk 25+ for use of IO instead of System.out

import java.util.ArrayList;

public class Main {

    static ArrayList<Expense> Expenses = new ArrayList<>();
    static ArrayList<DiscountedExpense> DiscountedExpenses = new ArrayList<>();

    static void addExpense(){
        if(Expenses.isEmpty()){Expenses.add(new Expense(IO.readln("Enter the expense name: "),Float.parseFloat(IO.readln("Enter the price: "))));}
        else{
            float value=Float.parseFloat(IO.readln("Enter the price: "));
            for (int i = 0; i<Expenses.size();i++){
                if (value<=Expenses.get(i).getAmount()){Expenses.add(i,new Expense(IO.readln("Enter the expense name: "),value)); break;}
            }
        }
    }
    static void addDiscountedExpense(){
        DiscountedExpenses.add(new DiscountedExpense(IO.readln("Enter the expense name: "),Float.parseFloat(IO.readln("Enter the price: ")),Float.parseFloat(IO.readln("Enter the Discount: %"))));
    }

    static void viewAllExpenses(){
        IO.println("\n====Expenses====");

        if(Expenses.isEmpty()&& DiscountedExpenses.isEmpty()){IO.println("you have no expenses");return;}
        for(Expense e: Expenses){
            IO.println(e.Display());
        }
        IO.println("\n====Discounted Expenses====");
        for (DiscountedExpense d: DiscountedExpenses){
            IO.println(d.Display());
        }
        IO.println();
    }
    static String showTotalSpend(){
        if(Expenses.isEmpty() && DiscountedExpenses.isEmpty()){return "you have no expenses";}
        float totalSpend = 0;
        for(Expense e: Expenses){
            totalSpend+=e.getAmount();
        }
        for(DiscountedExpense d: DiscountedExpenses){
            totalSpend+=d.getFinalAmount();
        }
        return "total spend: £"+totalSpend;
    }

    static String showHighestExpense(){
        if(Expenses.isEmpty() && DiscountedExpenses.isEmpty()){return "you have no expenses";}
        return Expenses.getLast().Display();
    }

    public static void main(String[] args) {
        int userInput=0;
        while (userInput!=6){
            IO.print(
                    "====Student Expense Manager====\n" +
                    "1. Add Expense\n" +
                    "2. Add Discounted Expense\n" +
                    "3. View All Expenses\n" +
                    "4. Show Total Spending\n" +
                    "5. Show Highest Expense\n" +
                    "6. Exit\n"
            );
            userInput=Integer.parseInt(IO.readln("enter your choice:" ));
            switch (userInput){
                case 1:
                    addExpense();
                    break;
                case 2:
                    addDiscountedExpense();
                    break;
                case 3:
                    viewAllExpenses();
                    break;
                case 4:
                    IO.println("====Total Spending====");
                    IO.println(showTotalSpend());
                    break;
                case 5:
                    IO.println("====Highest Expense====");
                    showHighestExpense();
                    break;
                case 6:
                    IO.println("you have exited the spend manager goodbye");
                    break;
                default:
                    IO.println("Please enter a valid choice");
                    break;
            }

        }

    }
}
