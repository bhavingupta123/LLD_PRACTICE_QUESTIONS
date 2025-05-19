import controller.ExpenseController;
import model.Expense;
import model.Group;
import model.User;
import repository.ExpensesRepo;
import service.ExpenseService;
import service.split.strategy.EqualSplit;

public class Main {

    public static void main(String[] args) {
        System.out.println("Main");

        User u1 = new User("1", "Alice");
        User u2 = new User("2", "Bob");
        User u3 = new User("3", "Charlie");

        Group group = new Group("g1");
        group.addUser(u1);
        group.addUser(u2);
        group.addUser(u3);

        Expense e1 = new Expense("e1", "Lunch", 300, "1", new EqualSplit());
        Expense e2 = new Expense("e2", "Snacks", 150, "2", new EqualSplit());

        group.addExpense(e1);
        group.addExpense(e2);

        group.showBalances();



    }
}
