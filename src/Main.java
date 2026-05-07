import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        BellSchedule bell = new BellSchedule();
        SpecialDayManager special = new SpecialDayManager();
        Reminder reminder = new Reminder();

        String today = TimeUtil.getCurrentDay();
        String date = TimeUtil.getCurrentDate();

        String type =
                special.getScheduleType(date);

        System.out.println("\nToday: " + today);
        System.out.println("Date: " + date);

        // NO SCHOOL
        if (type.equals("NO SCHOOL")) {

            System.out.println(
                    "\nNo school today.");

            return;
        }

        // LOAD SCHEDULE TYPE
        if (type.equals("PEP")) {

            bell.loadPepRallySchedule();

            System.out.println(
                    "\nPep Rally Schedule Loaded");
        }

        else if (type.equals("FINALS")) {

            bell.loadFinalsSchedule();

            System.out.println(
                    "\nFinals Schedule Loaded");
        }

        else {

            if (today.equals("Monday")) {

                bell.loadMondaySchedule();

                System.out.println(
                        "\nMonday Late Start Loaded");
            }

            else {

                bell.loadRegularSchedule();

                System.out.println(
                        "\nRegular Schedule Loaded");
            }
        }

        // ENTER CLASSES
        System.out.println(
                "\nEnter your class names:");

        for (int i = 0; i < bell.count; i++) {

            System.out.print(
                    "Period "
                            + (i + 1)
                            + ": ");

            bell.classNames[i] =
                    input.nextLine();
        }

        boolean running = true;

        while (running) {

            System.out.println(
                    "\n====================");

            System.out.println(
                    "1. View Schedule");

            System.out.println(
                    "2. Current Time");

            System.out.println(
                    "3. Passing Periods");

            System.out.println(
                    "4. Live Tracker");

            System.out.println(
                    "5. Exit");

            System.out.print(
                    "\nChoice: ");

            int choice =
                    input.nextInt();

            input.nextLine();

            // VIEW
            if (choice == 1) {

                bell.showSchedule();
            }

            // TIME
            else if (choice == 2) {

                System.out.println(
                        "\n"
                                + TimeUtil.getTimeString());
            }

            // GAPS
            else if (choice == 3) {

                Schedule.showPassingPeriods(bell);
            }

            // LIVE
            else if (choice == 4) {

                reminder.startLiveTracker(bell);
            }

            // EXIT
            else if (choice == 5) {

                running = false;
            }

            else {

                System.out.println(
                        "Invalid choice.");
            }
        }

        input.close();
    }
}
