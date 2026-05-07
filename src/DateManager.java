public class DateManager {

    public void showToday(Period p) {

        System.out.println(
                "\n======= TODAY =======");

        if (p.count == 0) {

            System.out.println(
                    "No classes today.");

            return;
        }

        for (int i = 0; i < p.count; i++) {

            System.out.println(
                    p.names[i]
                            + " | "
                            + p.startTimes[i]
                            + " - "
                            + p.endTimes[i]);
        }
    }
}
