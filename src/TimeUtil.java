/*
 * Shows current time in simple AM/PM format
 */

import java.time.LocalTime;

public class TimeUtil {

    public static void showTime() {

        LocalTime now = LocalTime.now();

        int hour = now.getHour();
        int minute = now.getMinute();

        String period = "AM";

        if (hour >= 12) {
            period = "PM";
            if (hour > 12) {
                hour = hour - 12;
            }
        }

        if (hour == 0) {
            hour = 12;
        }

        String minStr;

        if (minute < 10) {
            minStr = "0" + minute;
        } else {
            minStr = "" + minute;
        }

        System.out.println("\nCurrent Time: " + hour + ":" + minStr + " " + period);
    }
}
