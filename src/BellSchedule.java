public class BellSchedule {

    String[] classNames =
            new String[10];

    String[] startTimes =
            new String[10];

    String[] endTimes =
            new String[10];

    int count = 0;

    // REGULAR
    public void loadRegularSchedule() {

        count = 6;

        startTimes[0] = "8:45 AM";
        endTimes[0] = "9:42 AM";

        startTimes[1] = "9:48 AM";
        endTimes[1] = "10:45 AM";

        startTimes[2] = "10:51 AM";
        endTimes[2] = "11:48 AM";

        startTimes[3] = "11:54 AM";
        endTimes[3] = "12:51 PM";

        startTimes[4] = "1:33 PM";
        endTimes[4] = "2:30 PM";

        startTimes[5] = "2:36 PM";
        endTimes[5] = "3:33 PM";
    }

    // MONDAY
    public void loadMondaySchedule() {

        count = 6;

        startTimes[0] = "9:20 AM";
        endTimes[0] = "10:10 AM";

        startTimes[1] = "10:16 AM";
        endTimes[1] = "11:06 AM";

        startTimes[2] = "11:12 AM";
        endTimes[2] = "12:02 PM";

        startTimes[3] = "12:08 PM";
        endTimes[3] = "12:58 PM";

        startTimes[4] = "1:40 PM";
        endTimes[4] = "2:39 PM";

        startTimes[5] = "2:45 PM";
        endTimes[5] = "3:35 PM";
    }

    // PEP RALLY
    public void loadPepRallySchedule() {

        count = 6;

        startTimes[0] = "8:45 AM";
        endTimes[0] = "9:32 AM";

        startTimes[1] = "9:38 AM";
        endTimes[1] = "10:25 AM";

        startTimes[2] = "10:31 AM";
        endTimes[2] = "11:18 AM";

        startTimes[3] = "12:24 PM";
        endTimes[3] = "1:11 PM";

        startTimes[4] = "1:53 PM";
        endTimes[4] = "2:40 PM";

        startTimes[5] = "2:46 PM";
        endTimes[5] = "3:33 PM";
    }

    // FINALS
    public void loadFinalsSchedule() {

        count = 2;

        startTimes[0] = "8:45 AM";
        endTimes[0] = "10:45 AM";

        startTimes[1] = "11:11 AM";
        endTimes[1] = "1:11 PM";
    }

    // SHOW
    public void showSchedule() {

        System.out.println(
                "\n======= SCHEDULE =======");

        for (int i = 0; i < count; i++) {

            System.out.println(
                    "Period "
                            + (i + 1)
                            + " | "
                            + classNames[i]
                            + " | "
                            + startTimes[i]
                            + " - "
                            + endTimes[i]);
        }
    }
}
