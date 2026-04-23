import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Period period = new Period();
        Schedule.main(args); // call Schedule program

        System.out.print("Enter class name: ");
        String name = input.nextLine();
        System.out.print("Enter start time (e.g. 08:00): ");
        String start = input.nextLine();
        System.out.print("Enter end time (e.g. 09:00): ");
        String end = input.nextLine();

        period.addOrUpdatePeriod(name, start, end);
        period.displayPeriods();

        // Save today's class into DateManager
        DateManager manager = new DateManager();
        manager.DateManager(name, start, end);

        // Show today's schedule
        manager.displayTodaySchedule();


        input.close();
    }
}
