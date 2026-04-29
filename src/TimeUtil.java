import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    public static void showCurrentTime() {
        LocalTime now = LocalTime.now(ZoneId.of("America/Los_Angeles"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

        System.out.println("\nCurrent Time: " + now.format(formatter));
    }
}
