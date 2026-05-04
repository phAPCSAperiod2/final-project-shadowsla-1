public class TimeUtil {

    public void checkSchedule(Period p) {

        int now = TimeUtil.getCurrentMinutes();

        for (int i = 0; i < p.count; i++) {

            int start = TimeUtil.toMinutes(p.startTimes[i]);
            int end = TimeUtil.toMinutes(p.endTimes[i]);

            if (now >= start && now < end) {
                System.out.println("Current: " + p.names[i]);
                return;
            }

            if (now < start) {
                int diff = start - now;
                System.out.println("Next: " + p.names[i] + " in " + diff + " min");
                return;
            }
        }

        System.out.println("No more classes.");
    }

    static int toMinutes(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toMinutes'");
    }

    static int getCurrentMinutes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrentMinutes'");
    }

    public static String getTimeString() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTimeString'");
    }

    public static String minutesUntil(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'minutesUntil'");
    }
}
