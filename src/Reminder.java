import java.time.LocalTime;
import java.time.ZoneId;

public class Reminder {

    public void check(Period p) {

        LocalTime now = LocalTime.now(ZoneId.of("America/Los_Angeles"));
        int current = now.getHour() * 60 + now.getMinute();

        for (int i = 0; i < p.count; i++) {

            int start = toMinutes(p.startTimes[i]);
            int end = toMinutes(p.endTimes[i]);

            if (current >= start && current < end) {
                System.out.println("Current: " + p.names[i]);
                return;
            }

            if (current < start) {
                System.out.println("Next: " + p.names[i]);
                return;
            }
        }

        System.out.println("No more classes.");
    }

    private int toMinutes(String t) {

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

    public void checkSchedule(Period period) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'checkSchedule'");
    }
}
