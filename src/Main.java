import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Period schedule = new Period();
        DateManager manager = new DateManager();

        System.out.print("Enter number of classes: ");
        int numClasses = input.nextInt();
        input.nextLine();

        for (int i = 0; i < numClasses; i++) {

            System.out.println("\nClass " + (i + 1));

            System.out.print("Enter class name: ");
            String name = input.nextLine();

            String start = getValidTime(input, "Enter start time: ");
            String end = getValidTime(input, "Enter end time: ");

            schedule.addClass(name, start, end);
            manager.addClassToday(name, start, end);
        }

        // 📋 Show sorted schedule
        schedule.printSchedule();

        // 📅 Show today's schedule
        manager.displayTodaySchedule();

        // ⏰ Show current time
        TimeUtil.showCurrentTime();

        // 🟡 NEW: Time between classes
        Schedule scheduleHelper = new Schedule();
        scheduleHelper.showGaps(
            schedule.getNames(),
            schedule.getStartTimes(),
            schedule.getEndTimes(),
            schedule.getCount()
        );

        // 🔔 Reminder system
        Reminder reminder = new Reminder();

        while (true) {
            reminder.checkSchedule(
                schedule.getNames(),
                schedule.getStartTimes(),
                schedule.getEndTimes(),
                schedule.getCount()
            );

            try {
                Thread.sleep(60000); // update every minute
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 🔹 Handles time input + auto-fix
    private static String getValidTime(Scanner input, String prompt) {

        while (true) {
            System.out.print(prompt);
            String time = input.nextLine().trim();

            // fix spacing (8:00am → 8:00 am)
            time = time.replaceAll("(?i)(\\d)(am|pm)", "$1 $2");

            // fix case (am → AM)
            time = time.replaceAll("(?i)am", "AM")
                       .replaceAll("(?i)pm", "PM");

            // clean spaces
            time = time.replaceAll("\\s+", " ");

            if (time.matches("(1[0-2]|0?[1-9]):[0-5][0-9] (AM|PM)")) {
                return time;
            }

            System.out.println("Invalid format. Example: 8:00 AM");
        }
    }
}
