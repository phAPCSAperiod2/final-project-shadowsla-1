import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Period schedule = new Period();
        Schedule helper = new Schedule();
        Reminder reminder = new Reminder();
        DateManager date = new DateManager();

        System.out.print("Enter number of classes: ");
        int num = input.nextInt();
        input.nextLine();

        for (int i = 0; i < num; i++) {

            System.out.println("\nClass " + (i + 1));

            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Start (ex: 8:00 AM): ");
            String start = input.nextLine();

            System.out.print("End (ex: 9:00 AM): ");
            String end = input.nextLine();

            schedule.addClass(name, start, end);
            date.addClass(name, start, end);
        }

        schedule.printSchedule();
        date.printToday();

        helper.showGaps(schedule);

        TimeUtil.showTime();

        // live loop
        while (true) {

            reminder.check(schedule);

            try {
                Thread.sleep(60000);
            } catch (Exception e) {}

        }
    }
}
