public class DateManager {

    private String[] dates = new String[30];
    private String[][] names = new String[30][10];
    private String[][] starts = new String[30][10];
    private String[][] ends = new String[30][10];

    private int[] counts = new int[30];
    private int totalDates = 0;

    public void addClassToday(String name, String start, String end) {

        String today = getToday();
        int index = findOrCreate(today);

        if (counts[index] < 10) {
            names[index][counts[index]] = name;
            starts[index][counts[index]] = start;
            ends[index][counts[index]] = end;
            counts[index]++;
        }
    }

    public void displayTodaySchedule() {

        String today = getToday();

        for (int i = 0; i < totalDates; i++) {
            if (dates[i].equals(today)) {

                System.out.println("\n--- Today's Schedule ---");
                for (int j = 0; j < counts[i]; j++) {
                    System.out.println(names[i][j] + ": " + starts[i][j] + " - " + ends[i][j]);
                }
                return;
            }
        }

        System.out.println("No schedule today.");
    }

    private String getToday() {
        long days = System.currentTimeMillis() / (1000 * 60 * 60 * 24);
        return "DAY_" + days;
    }

    private int findOrCreate(String date) {

        for (int i = 0; i < totalDates; i++) {
            if (dates[i].equals(date)) {
                return i;
            }
        }

        dates[totalDates] = date;
        counts[totalDates] = 0;
        totalDates++;
        return totalDates - 1;
    }
}
