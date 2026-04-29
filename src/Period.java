import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Period {

    private String[] classNames = new String[10];
    private String[] startTimes = new String[10];
    private String[] endTimes = new String[10];
    private int count = 0;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");

    public void addClass(String name, String start, String end) {

        if (!isValidTime(start) || !isValidTime(end) || !isStartBeforeEnd(start, end)) {
            System.out.println("Invalid time.");
            return;
        }

        for (int i = 0; i < count; i++) {
            if (classNames[i].equals(name)) {
                startTimes[i] = start;
                endTimes[i] = end;
                sortClasses();
                return;
            }
        }

        if (count < classNames.length) {
            classNames[count] = name;
            startTimes[count] = start;
            endTimes[count] = end;
            count++;
            sortClasses();
        }
    }

    public void printSchedule() {
        System.out.println("\n--- Schedule ---");
        for (int i = 0; i < count; i++) {
            System.out.println(classNames[i] + ": " + startTimes[i] + " - " + endTimes[i]);
        }
    }

    private boolean isValidTime(String time) {
        return time.matches("(1[0-2]|0?[1-9]):[0-5][0-9] (AM|PM)");
    }

    private boolean isStartBeforeEnd(String start, String end) {
        LocalTime s = LocalTime.parse(start, formatter);
        LocalTime e = LocalTime.parse(end, formatter);
        return s.isBefore(e);
    }

    private void sortClasses() {
        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {

                LocalTime t1 = LocalTime.parse(startTimes[i], formatter);
                LocalTime t2 = LocalTime.parse(startTimes[j], formatter);

                if (t1.isAfter(t2)) {

                    String tempName = classNames[i];
                    classNames[i] = classNames[j];
                    classNames[j] = tempName;

                    String tempStart = startTimes[i];
                    startTimes[i] = startTimes[j];
                    startTimes[j] = tempStart;

                    String tempEnd = endTimes[i];
                    endTimes[i] = endTimes[j];
                    endTimes[j] = tempEnd;
                }
            }
        }
    }

    public String[] getNames() { return classNames; }
    public String[] getStartTimes() { return startTimes; }
    public String[] getEndTimes() { return endTimes; }
    public int getCount() { return count; }
}
