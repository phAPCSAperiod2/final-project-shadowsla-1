import java.time.LocalTime;

public class Reminder {

    public void check(Period p) {

        LocalTime now = LocalTime.now();
        int current = now.getHour() * 60 + now.getMinute();

        for (int i = 0; i < p.count; i++) {

            int start = toMinutes(p.starts[i]);
            int end = toMinutes(p.ends[i]);

            if (current >= start && current < end) {
                System.out.println("Current class: " + p.names[i]);
                return;
            }

            if (current < start) {
                int diff = start - current;

                System.out.println("Next class: " + p.names[i] + " in " + diff + " min");

                if (diff <= 5) {
                    System.out.println("Hurry! Passing period!");
                }

                return;
            }
        }

        System.out.println("No more classes today");
    }

    private int toMinutes(String time) {

        String[] parts = time.split(" ");
        String[] hm = parts[0].split(":");

        int hour = Integer.parseInt(hm[0]);
        int min = Integer.parseInt(hm[1]);

        if (parts[1].equals("PM") && hour != 12) hour += 12;
        if (parts[1].equals("AM") && hour == 12) hour = 0;

        return hour * 60 + min;
    }
}
