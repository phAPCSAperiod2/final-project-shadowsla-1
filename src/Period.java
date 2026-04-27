public class Period {

    String[] names = new String[10];
    String[] startTimes = new String[10];
    String[] endTimes = new String[10];
    int count = 0;

    public void addOrUpdatePeriod(String name, String start, String end) {

        if (!isValidTime(start) || !isValidTime(end)) {
            System.out.println("Invalid time format. Use HH:MM AM/PM");
            return;
        }

        for (int i = 0; i < count; i++) {
            if (names[i].equals(name)) {
                startTimes[i] = start;
                endTimes[i] = end;
                System.out.println("Updated: " + formatPeriod(name, start, end));
                return;
            }
        }

        if (count < names.length) {
            names[count] = name;
            startTimes[count] = start;
            endTimes[count] = end;
            System.out.println("Added: " + formatPeriod(name, start, end));
            count++;
        } else {
            System.out.println("Error: Storage full.");
        }
    }

    public void displayPeriods() {
        for (int i = 0; i < count; i++) {
            System.out.println(formatPeriod(names[i], startTimes[i], endTimes[i]));
        }
    }

    public String formatPeriod(String name, String start, String end) {
        return name + ": " + start + " - " + end;
    }

    // Simple AM/PM validation
    private boolean isValidTime(String time) {
        return time.matches("\\d{1,2}:\\d{2} (AM|PM)");
    }
}
