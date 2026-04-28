import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Period period = new Period();
        DateManager manager = new DateManager();

        System.out.print("Enter number of classes: ");
        int numClasses = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numClasses; i++) {

            System.out.println("\nClass " + (i + 1));

            System.out.print("Enter class name: ");
            String name = input.nextLine();

            System.out.print("Enter start time (e.g. 08:00 AM): ");
            String start = input.nextLine();

            System.out.print("Enter end time (e.g. 09:00 AM): ");
            String end = input.nextLine();

            period.addOrUpdatePeriod(name, start, end);
            manager.addClassToday(name, start, end);
        }

        System.out.println("\n--- All Periods ---");
        period.displayPeriods();

        manager.displayTodaySchedule();

        // Show real-world time
        TimeUtil.showCurrentTime();

    input.close();

    Reminder reminder = new Reminder();

while (true) {
    reminder.checkSchedule(
        period.names,
        period.startTimes,
        period.endTimes,
        period.count
    );

    try {
        Thread.sleep(60000); // wait 1 minute
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
}
}
