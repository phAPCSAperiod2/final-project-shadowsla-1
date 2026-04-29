import java.time.Duration;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Reminder {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
    private ZoneId zone = ZoneId.of("America/Los_Angeles");

    public void checkSchedule(String[] names, String[] starts, String[] ends, int count) {

        LocalTime now = LocalTime.now(zone);
        System.out.println("\n[Time: " + now.format(formatter) + "]");

        for (int i = 0; i < count; i++) {

            LocalTime start = LocalTime.parse(starts[i], formatter);
            LocalTime end = LocalTime.parse(ends[i], formatter);

            if (!now.isBefore(start) && now.isBefore(end)) {
                long minutesLeft = Duration.between(now, end).toMinutes();
                System.out.println("Current: " + names[i] + " (" + minutesLeft + " min left)");
                return;
            }

            if (now.isBefore(start)) {
                long minutes = Duration.between(now, start).toMinutes();
                System.out.println("Next: " + names[i] + " (" + minutes + " min)");

                if (minutes <= 5) {
                    System.out.println("⚠ Passing period!");
                }
                return;
            }
        }

        System.out.println("Done for the day.");
    }
}
