import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Schedule {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

    // Calculate time between classes
    public void showGaps(String[] names, String[] starts, String[] ends, int count) {

        System.out.println("\n--- Time Between Classes ---");

        for (int i = 0; i < count - 1; i++) {

            LocalTime endCurrent = LocalTime.parse(ends[i], formatter);
            LocalTime startNext = LocalTime.parse(starts[i + 1], formatter);

            long gap = java.time.Duration.between(endCurrent, startNext).toMinutes();

            System.out.println("Between " + names[i] + " and " + names[i + 1] + ": " + gap + " minutes");

            if (gap < 5) {
                System.out.println("⚠ VERY SHORT PASSING PERIOD!");
            } else if (gap < 10) {
                System.out.println("⚠ Might be tight.");
            }
        }
    }
}
