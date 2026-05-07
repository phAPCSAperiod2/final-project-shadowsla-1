import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;

public class TimeUtil {

    // CURRENT TIME
    public static String getTimeString() {

        LocalTime now =
                LocalTime.now(
                        ZoneId.of(
                                "America/Los_Angeles"));

        int h = now.getHour();
        int m = now.getMinute();
        int s = now.getSecond();

        String ap = "AM";

        if (h >= 12) {

            ap = "PM";

            if (h > 12) {
                h -= 12;
            }
        }

        if (h == 0) {
            h = 12;
        }

        String min =
                (m < 10)
                        ? "0" + m
                        : "" + m;

        String sec =
                (s < 10)
                        ? "0" + s
                        : "" + s;

        return "Current Time (San Diego): "
                + h
                + ":"
                + min
                + ":"
                + sec
                + " "
                + ap;
    }

    // DAY
    public static String getCurrentDay() {

        return LocalDate.now(
                ZoneId.of(
                        "America/Los_Angeles"))
                .getDayOfWeek()
                .getDisplayName(
                        TextStyle.FULL,
                        Locale.ENGLISH);
    }

    // DATE
    public static String getCurrentDate() {

        LocalDate now =
                LocalDate.now(
                        ZoneId.of(
                                "America/Los_Angeles"));

        return now.getMonthValue()
                + "/"
                + now.getDayOfMonth();
    }

    // TO MINUTES
    public static int toMinutes(
            String t) {

        try {

            String[] parts =
                    t.split(" ");

            String[] hm =
                    parts[0].split(":");

            int h =
                    Integer.parseInt(
                            hm[0]);

            int m =
                    Integer.parseInt(
                            hm[1]);

            if (parts[1].equals("PM")
                    && h != 12) {

                h += 12;
            }

            if (parts[1].equals("AM")
                    && h == 12) {

                h = 0;
            }

            return h * 60 + m;

        } catch (Exception e) {

            return 0;
        }
    }

    // TO SECONDS
    public static int toSeconds(
            String t) {

        return toMinutes(t) * 60;
    }

    // CURRENT SECONDS
    public static int getCurrentSeconds() {

        LocalTime now =
                LocalTime.now(
                        ZoneId.of(
                                "America/Los_Angeles"));

        return now.getHour() * 3600
                + now.getMinute() * 60
                + now.getSecond();
    }
}
