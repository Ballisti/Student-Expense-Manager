
/*
    Written by Calum Breen-Chapman
    requires jdk 25+ for use of IO instead of System.out
*/

import java.util.ArrayList;

public class Main {

    static ArrayList<Expense> Expenses = new ArrayList<Expense>();
    static ArrayList<DiscountedExpense> DiscountedExpenses = new ArrayList<DiscountedExpense>();

    // adds element into sorted arrayList
    static void addExpense(){

        String name=IO.readln("Enter the expense name: ");
        double value=Double.parseDouble(IO.readln("Enter the price: "));
        Expense TempObj=new Expense(name,value);

        if(!Expenses.isEmpty()){
            for (int i = 0; i<Expenses.size();i++){
                if (value<=Expenses.get(i).getAmount()){Expenses.add(i,TempObj); return;}
            }
        }
        Expenses.add(TempObj);
    }

    static void addDiscountedExpense(){

        String name=IO.readln("Enter the expense name: ");
        double value=Double.parseDouble(IO.readln("Enter the price: "));
        double discount=Double.parseDouble(IO.readln("Enter the discount: "));
        DiscountedExpense TempObj=new DiscountedExpense(name,value,discount);

        if(!DiscountedExpenses.isEmpty()){
            for (int i = 0; i<DiscountedExpenses.size();i++){
                if (TempObj.getAmount()<=DiscountedExpenses.get(i).getAmount()){DiscountedExpenses.add(i,TempObj); return;}
            }
        }
        DiscountedExpenses.add(TempObj);
    }

    // displays all arrays sorted by type and then price
    static void viewAllExpenses(){
        IO.println("====Expenses====");

        if(Expenses.isEmpty()&& DiscountedExpenses.isEmpty()){IO.println("you have no expenses");return;}
        for(Expense e: Expenses){
            IO.println(e.display());
        }
        IO.println("====Discounted Expenses====");
        for (DiscountedExpense d: DiscountedExpenses){
            IO.println(d.display());
        }
    }

    static String showTotalSpend(){
        if(Expenses.isEmpty() && DiscountedExpenses.isEmpty()){return "you have no expenses";}
        double totalSpend = 0;
        for(Expense e: Expenses){
            totalSpend+=e.getAmount();
        }
        for(DiscountedExpense d: DiscountedExpenses){
            totalSpend+=d.getAmount();
        }
        return "total spend: £"+totalSpend;
    }

    // drawback doesn't show ties within same category
    static String showHighestExpense(){
        if(Expenses.isEmpty() && DiscountedExpenses.isEmpty()){return "you have no expenses";}
        else if(DiscountedExpenses.isEmpty()||Expenses.getLast().getAmount()>DiscountedExpenses.getLast().getAmount()){
            return Expenses.getLast().display();
        }
        else if(Expenses.isEmpty()||Expenses.getLast().getAmount()<DiscountedExpenses.getLast().getAmount()){
            return DiscountedExpenses.getLast().display();
        }
        else{
            return Expenses.getLast().display()+"\n"+DiscountedExpenses.getLast().display();
        }
    }

    public static void main(String[] args) {
        int userInput=0;
        while(true){
            IO.print(
                    """
                    ====Student Expense Manager====
                    1. Add Expense
                    2. Add Discounted Expense
                    3. View All Expenses
                    4. Show Total Spending
                    5. Show Highest Expense
                    6. Exit
                    """
            );
            userInput=Integer.parseInt(IO.readln("enter your choice: "));
            IO.println();
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
                    IO.println(showHighestExpense());
                    break;
                case 6:
                    IO.println("you have exited the spend manager goodbye");
                    return;
                default:
                    IO.println("Please enter a valid choice");
                    break;
            }
            IO.readln("press enter to continue");
            IO.println();
        }
    }
}
