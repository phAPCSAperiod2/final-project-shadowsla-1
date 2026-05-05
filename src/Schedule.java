public class Schedule {

    public void showGaps(Period p) {

        if (p.count < 2) {
            System.out.println("Not enough classes.");
            return;
        }

        System.out.println("\n--- Passing Periods ---");

        for (int i = 0; i < p.count - 1; i++) {

            int end = TimeUtil.toMinutes(p.endTimes[i]);
            int next = TimeUtil.toMinutes(p.startTimes[i + 1]);

            int gap = next - end;

            System.out.println(p.names[i] + " → " +
                    p.names[i + 1] + ": " + gap + " min");

            if (gap < 10) {
                System.out.println("⚠ Hurry!");
            }
        }
    }
}
