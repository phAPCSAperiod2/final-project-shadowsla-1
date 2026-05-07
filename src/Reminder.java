public class Reminder {

    public void startLiveTracker(
            BellSchedule bell) {

        System.out.println(
                "\n=== LIVE TRACKER ===");

        System.out.println(
                "Press Ctrl + C to stop.\n");

        while (true) {

            int now =
                    TimeUtil.getCurrentSeconds();

            System.out.println(
                    "\n"
                            + TimeUtil.getTimeString());

            boolean found = false;

            for (int i = 0;
                 i < bell.count;
                 i++) {

                int start =
                        TimeUtil.toSeconds(
                                bell.startTimes[i]);

                int end =
                        TimeUtil.toSeconds(
                                bell.endTimes[i]);

                // CURRENT CLASS
                if (now >= start
                        && now < end) {

                    int remain =
                            end - now;

                    int min =
                            remain / 60;

                    int sec =
                            remain % 60;

                    System.out.println(
                            "Current Period: "
                                    + (i + 1));

                    System.out.println(
                            "Class: "
                                    + bell.classNames[i]);

                    System.out.println(
                            "Ends In: "
                                    + min
                                    + "m "
                                    + sec
                                    + "s");

                    found = true;

                    break;
                }

                // NEXT CLASS
                if (now < start) {

                    int remain =
                            start - now;

                    int min =
                            remain / 60;

                    int sec =
                            remain % 60;

                    System.out.println(
                            "Next Period: "
                                    + (i + 1));

                    System.out.println(
                            "Class: "
                                    + bell.classNames[i]);

                    System.out.println(
                            "Starts In: "
                                    + min
                                    + "m "
                                    + sec
                                    + "s");

                    if (remain <= 300) {

                        System.out.println(
                                "⚠ Passing period almost over");
                    }

                    found = true;

                    break;
                }
            }

            if (!found) {

                System.out.println(
                        "School day finished.");
            }

            try {

                Thread.sleep(1000);

            } catch (Exception e) {

                System.out.println(
                        "Tracker stopped.");
            }
        }
    }
}
