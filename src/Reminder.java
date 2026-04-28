import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Reminder {

    private DateTimeFormatter format = DateTimeFormatter.ofPattern("hh:mm a");

    public void checkSchedule(String[] names, String[] starts, String[] ends, int count) {

        LocalTime now = LocalTime.now();
        System.out.println("\n[Live Check @ " + now.format(format) + "]");

        for (int i = 0; i < count; i++) {

            LocalTime start = LocalTime.parse(starts[i], format);
            LocalTime end = LocalTime.parse(ends[i], format);

            // DURING CLASS
            if (!now.isBefore(start) && now.isBefore(end)) {
                long minutesLeft = java.time.Duration.between(now, end).toMinutes();

                System.out.println("You are in: " + names[i]);
                System.out.println("Time remaining: " + minutesLeft + " minutes");
                return;
            }

            // BEFORE NEXT CLASS (passing period)
            if (now.isBefore(start)) {
                long minutesUntil = java.time.Duration.between(now, start).toMinutes();

                System.out.println("Next class: " + names[i]);
                System.out.println("Starts in: " + minutesUntil + " minutes");

                if (minutesUntil <= 5) {
                    System.out.println("⚠ HURRY: Passing period!");
                }

                return;
            }
        }

        // AFTER ALL CLASSES
        System.out.println("No more classes today 🎉");
    }
}
