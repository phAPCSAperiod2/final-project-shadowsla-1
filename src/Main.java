import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Period schedule = new Period();
        Schedule helper = new Schedule();
        Reminder reminder = new Reminder();
        DateManager date = new DateManager();

        boolean running = true;

        while (running) {

            System.out.println("\n=== Schedule Menu ===");
            System.out.println("1. Add Class");
            System.out.println("2. View Schedule");
            System.out.println("3. Edit Class");
            System.out.println("4. Delete Class");
            System.out.println("5. Show Gaps");
            System.out.println("6. Show Today's Schedule");
            System.out.println("7. Show Current Time");
            System.out.println("8. Start Live Tracker");
            System.out.println("9. Exit");

            System.out.print("Choose option: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                System.out.print("Class name: ");
                String name = input.nextLine();

                System.out.print("Start (ex: 8:00 AM): ");
                String start = input.nextLine();

                System.out.print("End (ex: 9:00 AM): ");
                String end = input.nextLine();

                schedule.addClass(name, start, end);
                date.addClass(name, start, end); // also store in today's schedule
            }

            else if (choice == 2) {
                schedule.printSchedule();
            }

            else if (choice == 3) {
                schedule.editClass(input);
            }

            else if (choice == 4) {
                schedule.deleteClass(input);
            }

            else if (choice == 5) {
                helper.showGaps(schedule);
            }

            else if (choice == 6) {
                date.printToday();
            }

            else if (choice == 7) {
                TimeUtil.showTime();
            }

            else if (choice == 8) {

                System.out.println("\n--- Live Tracker (CTRL+C to stop) ---");

                while (true) {

                    reminder.check(schedule);

                    try {
                        Thread.sleep(60000); // update every minute
                    } catch (Exception e) {
                        System.out.println("Timer error");
                    }
                }
            }

            else if (choice == 9) {
                running = false;
                System.out.println("Goodbye!");
            }

            else {
                System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}
