public class Schedule {

    public static void showPassingPeriods(
            BellSchedule bell) {

        System.out.println(
                "\n=== PASSING PERIODS ===");

        for (int i = 0;
             i < bell.count - 1;
             i++) {

            int currentEnd =
                    TimeUtil.toMinutes(
                            bell.endTimes[i]);

            int nextStart =
                    TimeUtil.toMinutes(
                            bell.startTimes[i + 1]);

            int gap =
                    nextStart - currentEnd;

            System.out.println(
                    "Between Period "
                            + (i + 1)
                            + " and "
                            + (i + 2)
                            + ": "
                            + gap
                            + " min");

            if (gap <= 5) {

                System.out.println(
                        "⚠ Short passing period");
            }
        }
    }
}
