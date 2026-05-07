import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Period {

    String[] names = new String[20];
    String[] startTimes = new String[20];
    String[] endTimes = new String[20];

    int count = 0;

    // ADD / UPDATE
    public void addOrUpdatePeriod(
            String name,
            String start,
            String end) {

        if (TimeUtil.toMinutes(start)
                >= TimeUtil.toMinutes(end)) {

            System.out.println(
                    "Start time must be before end time.");
            return;
        }

        // update existing
        for (int i = 0; i < count; i++) {

            if (names[i].equalsIgnoreCase(name)) {

                startTimes[i] = start;
                endTimes[i] = end;

                sortSchedule();

                System.out.println("Updated.");

                return;
            }
        }

        // add new
        names[count] = name;
        startTimes[count] = start;
        endTimes[count] = end;

        count++;

        sortSchedule();

        System.out.println("Added.");
    }

    // DISPLAY
    public void displayPeriods() {

        System.out.println("\n======= SCHEDULE =======");

        if (count == 0) {

            System.out.println("No classes.");

            return;
        }

        for (int i = 0; i < count; i++) {

            System.out.println(
                    (i + 1) + ". "
                            + names[i]
                            + " | "
                            + startTimes[i]
                            + " - "
                            + endTimes[i]);
        }
    }

    // EDIT
    public void editClass(Scanner input) {

        displayPeriods();

        if (count == 0) {
            return;
        }

        System.out.print("\nClass number to edit: ");

        int choice = input.nextInt();

        input.nextLine();

        choice--;

        if (choice < 0 || choice >= count) {

            System.out.println("Invalid class.");

            return;
        }

        System.out.print("New class name: ");
        names[choice] = input.nextLine();

        System.out.print("New start time: ");
        startTimes[choice] = input.nextLine();

        System.out.print("New end time: ");
        endTimes[choice] = input.nextLine();

        sortSchedule();

        System.out.println("Class updated.");
    }

    // DELETE
    public void deleteClass(Scanner input) {

        displayPeriods();

        if (count == 0) {
            return;
        }

        System.out.print("\nClass number to delete: ");

        int choice = input.nextInt();

        input.nextLine();

        choice--;

        if (choice < 0 || choice >= count) {

            System.out.println("Invalid class.");

            return;
        }

        for (int i = choice; i < count - 1; i++) {

            names[i] = names[i + 1];
            startTimes[i] = startTimes[i + 1];
            endTimes[i] = endTimes[i + 1];
        }

        count--;

        System.out.println("Class deleted.");
    }

    // SORT
    public void sortSchedule() {

        for (int i = 0; i < count - 1; i++) {

            for (int j = i + 1; j < count; j++) {

                if (TimeUtil.toMinutes(startTimes[i])
                        > TimeUtil.toMinutes(startTimes[j])) {

                    String temp;

                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;

                    temp = startTimes[i];
                    startTimes[i] = startTimes[j];
                    startTimes[j] = temp;

                    temp = endTimes[i];
                    endTimes[i] = endTimes[j];
                    endTimes[j] = temp;
                }
            }
        }
    }

    // SAVE
    public void saveToFile() {

        try {

            PrintWriter writer =
                    new PrintWriter("schedule.txt");

            for (int i = 0; i < count; i++) {

                writer.println(
                        names[i] + ","
                                + startTimes[i] + ","
                                + endTimes[i]);
            }

            writer.close();

        } catch (Exception e) {

            System.out.println("Could not save.");
        }
    }

    // LOAD
    public void loadFromFile() {

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("schedule.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                addOrUpdatePeriod(
                        parts[0],
                        parts[1],
                        parts[2]);
            }

            reader.close();

        } catch (Exception e) {

            // no file yet
        }
    }
}
