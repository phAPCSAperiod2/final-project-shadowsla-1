import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Period period = new Period();
        Schedule helper = new Schedule();
        Reminder reminder = new Reminder();
        DateManager date = new DateManager();

        period.loadFromFile();

        boolean running = true;

        while (running) {

            System.out.println("\n=== SCHOOL SCHEDULE APP ===");
            System.out.println("1. Add Class");
            System.out.println("2. View Schedule");
            System.out.println("3. Edit Class");
            System.out.println("4. Delete Class");
            System.out.println("5. Show Gaps");
            System.out.println("6. Show Current Time");
            System.out.println("7. Start Live Tracker");
            System.out.println("8. Show Today");
            System.out.println("9. Exit");

            System.out.print("Choice: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                System.out.print("Class name: ");
                String name = input.nextLine();

                String start = getValidTime(input, "Start (8:00 AM): ");
                String end = getValidTime(input, "End (9:00 AM): ");

                period.addOrUpdatePeriod(name, start, end);
                period.saveToFile();
            }

            else if (choice == 2) {
                period.displayPeriods();
            }

            else if (choice == 3) {
                period.editClass(input);
                period.saveToFile();
            }

            else if (choice == 4) {
                period.deleteClass(input);
                period.saveToFile();
            }

            else if (choice == 5) {
                helper.showGaps(period);
            }

            else if (choice == 6) {
                System.out.println(TimeUtil.getTimeString());
            }

            else if (choice == 7) {
                reminder.startLiveTracker(period);
            }

            else if (choice == 8) {
                date.showToday(period);
            }

            else if (choice == 9) {
                running = false;
            }
        }

        input.close();
    }

    public static String getValidTime(Scanner input, String msg) {

        while (true) {

            System.out.print(msg);
            String t = input.nextLine().trim();

            // auto-fix lowercase + spacing
            t = t.replace("am", "AM").replace("pm", "PM");
            t = t.replaceAll("(AM|PM)", " $1").trim();

            if (t.matches("\\d{1,2}:\\d{2} (AM|PM)")) {
                return t;
            }

            System.out.println("Invalid format. Use like 8:00 AM");
        }
    }
}
