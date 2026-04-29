import java.time.LocalTime;

public class TimeUtil {

    public static void showTime() {

        LocalTime now = LocalTime.now();

        int hour = now.getHour();
        int minute = now.getMinute();

        String period = "AM";

        if (hour >= 12) {
            period = "PM";
            if (hour > 12) hour -= 12;
        }

        if (hour == 0) hour = 12;

        String minStr = minute < 10 ? "0" + minute : "" + minute;

        System.out.println("\nCurrent Time: " + hour + ":" + minStr + " " + period);
    }
}
