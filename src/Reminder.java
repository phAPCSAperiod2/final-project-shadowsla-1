public class Reminder {

    public void startLiveTracker(Period p) {

        System.out.println("\n--- Live Tracker Started --- (Ctrl+C to stop)");

        while (true) {

            int now = TimeUtil.getCurrentMinutes();

            System.out.println("\n" + TimeUtil.getTimeString());

            boolean found = false;

            for (int i = 0; i < p.count; i++) {

                int start = TimeUtil.toMinutes(p.startTimes[i]);
                int end = TimeUtil.toMinutes(p.endTimes[i]);

                if (now >= start && now < end) {
                    System.out.println("Current Class: " + p.names[i]);
                    System.out.println("Ends in: " +
                            TimeUtil.minutesUntil(p.endTimes[i]) + " min");
                    found = true;
                    break;
                }

                if (now < start) {
                    System.out.println("Next Class: " + p.names[i]);
                    System.out.println("Starts in: " +
                            TimeUtil.minutesUntil(p.startTimes[i]) + " min");

                    if (TimeUtil.minutesUntil(p.startTimes[i]) <= 5) {
                        System.out.println("⚠ Passing period ending soon!");
                    }

                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No more classes today.");
            }

            try {
                Thread.sleep(30000); // updates every 30 sec
            } catch (Exception e) {}
        }
    }
}
