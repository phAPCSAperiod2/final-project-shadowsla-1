public class Schedule {

    public void showGaps(Period p) {

        System.out.println("\n--- Gaps Between Classes ---");

        for (int i = 0; i < p.count - 1; i++) {

            int end = toMinutes(p.ends[i]);
            int next = toMinutes(p.starts[i + 1]);

            int gap = next - end;

            System.out.println(p.names[i] + " → " + p.names[i + 1] + ": " + gap + " min");

            if (gap < 5) {
                System.out.println("Short passing period!");
            }
        }
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
