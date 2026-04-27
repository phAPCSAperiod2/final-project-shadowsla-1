public class DateManager {

    String[] dates = new String[30];
    String[][] classNames = new String[30][10];
    String[][] startTimes = new String[30][10];
    String[][] endTimes = new String[30][10];

    int[] counts = new int[30];
    int totalDates = 0;

    public String getTodayDate() {
        long millis = System.currentTimeMillis();
        long days = millis / (1000 * 60 * 60 * 24);
        return "DAY_" + days;
    }

    // FIX: renamed method (was same as class name)
    public void addClassToday(String name, String start, String end) {

        String today = getTodayDate();
        int index = -1;

        for (int i = 0; i < totalDates; i++) {
            if (dates[i].equals(today)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            index = totalDates;
            dates[index] = today;
            counts[index] = 0;
            totalDates++;
        }

        for (int i = 0; i < counts[index]; i++) {
            if (classNames[index][i].equals(name)) {
                startTimes[index][i] = start;
                endTimes[index][i] = end;
                return;
            }
        }

        if (counts[index] < 10) {
            classNames[index][counts[index]] = name;
            startTimes[index][counts[index]] = start;
            endTimes[index][counts[index]] = end;
            counts[index]++;
        }
    }

    public void displayTodaySchedule() {
        String today = getTodayDate();

        for (int i = 0; i < totalDates; i++) {
            if (dates[i].equals(today)) {

                System.out.println("\n--- Today's Schedule ---");
                for (int j = 0; j < counts[i]; j++) {
                    System.out.println(
                        classNames[i][j] + ": " +
                        startTimes[i][j] + " - " +
                        endTimes[i][j]
                    );
                }
                return;
            }
        }

        System.out.println("No schedule for today.");
    }
}
