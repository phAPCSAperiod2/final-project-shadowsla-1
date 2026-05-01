public class Schedule {

    public void showGaps(Period p) {

        if (p.count < 2) {
            System.out.println("\nNot enough classes to show gaps.");
            return;
        }

        System.out.println("\n--- Time Between Classes ---");

        for (int i = 0; i < p.count - 1; i++) {

            int end = toMinutes(p.ends[i]);
            int next = toMinutes(p.starts[i + 1]);

            int gap = next - end;

            System.out.println(p.names[i] + " to " + p.names[i + 1] + ": " + gap + " minutes");

            if (gap < 5) {
                System.out.println("Short passing period!");
            }
        }
    }

    private int toMinutes(String time) {

        try {
            String[] parts = time.split(" ");
            String[] hm = parts[0].split(":");

            int hour = Integer.parseInt(hm[0]);
            int min = Integer.parseInt(hm[1]);

            if (parts[1].equals("PM") && hour != 12) hour += 12;
            if (parts[1].equals("AM") && hour == 12) hour = 0;

            return hour * 60 + min;

        } catch (Exception e) {
            return 0;
        }
    }
}
