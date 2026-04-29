public class DateManager {

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
    }

    public void printToday() {

        System.out.println("\n--- Today's Schedule ---");

        if (count == 0) {
            System.out.println("No classes");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println(names[i] + ": " + starts[i] + " - " + ends[i]);
        }
    }
}
