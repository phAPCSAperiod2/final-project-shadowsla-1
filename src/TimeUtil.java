import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

    public static void showCurrentTime() {
        LocalTime now = LocalTime.now();
DateTimeFormatter format = DateTimeFormatter.ofPattern("h:mm a");

        System.out.println("\nCurrent Time: " + now.format(format));
    }
    
}
