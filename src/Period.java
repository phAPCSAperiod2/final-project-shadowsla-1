public class Period {

    String[] names = new String[10];
    String[] starts = new String[10];
    String[] ends = new String[10];
    int count = 0;

    public void addClass(String name, String start, String end) {

        if (count < 10) {
            names[count] = name;
            starts[count] = start;
            ends[count] = end;
            count++;
        }

        sort();
    }

    public void printSchedule() {
        System.out.println("\n--- Schedule ---");
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + names[i] + ": " + starts[i] + " - " + ends[i]);
        }
    }

    public void editClass(java.util.Scanner input) {

        if (count == 0) {
            System.out.println("No classes to edit.");
            return;
        }

        printSchedule();

        System.out.print("Enter class number to edit: ");
        int index = input.nextInt() - 1;
        input.nextLine();

        if (index < 0 || index >= count) {
            System.out.println("Invalid selection.");
            return;
        }

        System.out.print("New name: ");
        names[index] = input.nextLine();

        System.out.print("New start: ");
        starts[index] = input.nextLine();

        System.out.print("New end: ");
        ends[index] = input.nextLine();

        sort();

        System.out.println("Class updated.");
    }

    public void deleteClass(java.util.Scanner input) {

        if (count == 0) {
            System.out.println("No classes to delete.");
            return;
        }

        printSchedule();

        System.out.print("Enter class number to delete: ");
        int index = input.nextInt() - 1;
        input.nextLine();

        if (index < 0 || index >= count) {
            System.out.println("Invalid selection.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            names[i] = names[i + 1];
            starts[i] = starts[i + 1];
            ends[i] = ends[i + 1];
        }

        count--;

        System.out.println("Class deleted.");
    }

    private int toMinutes(String time) {

        try {
            String[] parts = time.split(" ");
            String[] hm = parts[0].split(":");

            int hour = Integer.parseInt(hm[0]);
            int min = Integer.parseInt(hm[1]);

            if (parts[1].equals("PM") && hour != 12) hour += 12;
            if (parts[1].equals("AM") && hour == 12) hour = 0;

            return hour * 60 + min;

        } catch (Exception e) {
            return 0;
        }
    }

    private void sort() {

        for (int i = 0; i < count - 1; i++) {
            for (int j = i + 1; j < count; j++) {

                if (toMinutes(starts[i]) > toMinutes(starts[j])) {

                    String temp;

                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;

                    temp = starts[i];
                    starts[i] = starts[j];
                    starts[j] = temp;

                    temp = ends[i];
                    ends[i] = ends[j];
                    ends[j] = temp;
                }
            }
        }
    }
}
