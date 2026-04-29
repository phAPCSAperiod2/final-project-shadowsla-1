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
            System.out.println(names[i] + ": " + starts[i] + " - " + ends[i]);
        }
    }

    private int toMinutes(String time) {

        String[] parts = time.split(" ");
        String[] hm = parts[0].split(":");

        int hour = Integer.parseInt(hm[0]);
        int min = Integer.parseInt(hm[1]);

        if (parts[1].equals("PM") && hour != 12) hour += 12;
        if (parts[1].equals("AM") && hour == 12) hour = 0;

        return hour * 60 + min;
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
