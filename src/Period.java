import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Period {

    String[] names = new String[10];
    String[] startTimes = new String[10];
    String[] endTimes = new String[10];
    int count = 0;

    public void addOrUpdatePeriod(String name, String start, String end) {

        if (!isStartBeforeEnd(start, end)) {
            System.out.println("Start must be before end.");
            return;
        }

        for (int i = 0; i < count; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                names[i] = name;
                startTimes[i] = start;
                endTimes[i] = end;
                sort();
                return;
            }
        }

        if (count < 10) {
            names[count] = name;
            startTimes[count] = start;
            endTimes[count] = end;
            count++;
        }

        sort();
    }

    public void displayPeriods() {

        System.out.println("\n--- Schedule ---");

        if (count == 0) {
            System.out.println("No classes.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + names[i] + " | " +
                    startTimes[i] + " - " + endTimes[i]);
        }
    }

    public void editClass(Scanner input) {

        displayPeriods();

        System.out.print("Edit number: ");
        int i = input.nextInt() - 1;
        input.nextLine();

        if (i < 0 || i >= count) return;

        System.out.print("New name: ");
        names[i] = input.nextLine();

        System.out.print("New start: ");
        startTimes[i] = input.nextLine();

        System.out.print("New end: ");
        endTimes[i] = input.nextLine();

        sort();
    }

    public void deleteClass(Scanner input) {

        displayPeriods();

        System.out.print("Delete number: ");
        int i = input.nextInt() - 1;
        input.nextLine();

        if (i < 0 || i >= count) return;

        for (int j = i; j < count - 1; j++) {
            names[j] = names[j + 1];
            startTimes[j] = startTimes[j + 1];
            endTimes[j] = endTimes[j + 1];
        }

        count--;
    }

    private void sort() {

        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {

                if (TimeUtil.toMinutes(startTimes[i]) >
                        TimeUtil.toMinutes(startTimes[j])) {

                    String t;

                    t = names[i]; names[i] = names[j]; names[j] = t;
                    t = startTimes[i]; startTimes[i] = startTimes[j]; startTimes[j] = t;
                    t = endTimes[i]; endTimes[i] = endTimes[j]; endTimes[j] = t;
                }
            }
        }
    }

    private boolean isStartBeforeEnd(String s, String e) {
        return TimeUtil.toMinutes(s) < TimeUtil.toMinutes(e);
    }

    public void saveToFile() {
        try {
            PrintWriter w = new PrintWriter("schedule.txt");
            for (int i = 0; i < count; i++) {
                w.println(names[i] + "," + startTimes[i] + "," + endTimes[i]);
            }
            w.close();
        } catch (Exception ex) {}
    }

    public void loadFromFile() {
        try {
            BufferedReader r = new BufferedReader(new FileReader("schedule.txt"));
            String line;
            while ((line = r.readLine()) != null) {
                String[] p = line.split(",");
                addOrUpdatePeriod(p[0], p[1], p[2]);
            }
            r.close();
        } catch (Exception ex) {}
    }
}
