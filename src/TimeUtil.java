import java.time.LocalTime;
import java.time.ZoneId;

public class TimeUtil {

    public static int getCurrentMinutes() {
        LocalTime now = LocalTime.now(ZoneId.of("America/Los_Angeles"));
        return now.getHour() * 60 + now.getMinute();
    }

    public static String getTimeString() {

        LocalTime now = LocalTime.now(ZoneId.of("America/Los_Angeles"));

        int h = now.getHour();
        int m = now.getMinute();

        String ap = "AM";

        if (h >= 12) {
            ap = "PM";
            if (h > 12) h -= 12;
        }

        if (h == 0) h = 12;

        String min = (m < 10) ? "0" + m : "" + m;

        return "Current Time (San Diego): " + h + ":" + min + " " + ap;
    }

    public static int toMinutes(String t) {

        try {
            String[] p = t.split(" ");
            String[] hm = p[0].split(":");

            int h = Integer.parseInt(hm[0]);
            int m = Integer.parseInt(hm[1]);

            if (p[1].equals("PM") && h != 12) h += 12;
            if (p[1].equals("AM") && h == 12) h = 0;

            return h * 60 + m;

        } catch (Exception e) {
            return 0;
        }
    }

    public static int minutesUntil(String t) {
        return toMinutes(t) - getCurrentMinutes();
    }
}
