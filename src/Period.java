public class Period {

      // Arrays to store multiple class periods
      String[] names = new String[10];
      String[] startTimes = new String[10];
      String[] endTimes = new String[10];
      int count = 0;

      // Method to add or update a class period
     public void addOrUpdatePeriod(String name, String start, String end) {

         // Error checking: simple string comparison for time
         if (start.compareTo(end) >= 0) {
             System.out.println("Error: Start time must be before end time.");
             return;
         }

         // Check if period already exists (update)
         for (int i = 0; i < count; i++) {
             if (names[i].equals(name)) {
                 startTimes[i] = start;
                 endTimes[i] = end;
                 System.out.println("Updated: " + formatPeriod(name, start, end));
                 return;
             }
         }

         // Add new period
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

     // Method to display all periods
     public void displayPeriods() {
         for (int i = 0; i < count; i++) {
             System.out.println(formatPeriod(names[i], startTimes[i], endTimes[i]));
         }
     }

     // Helper method to format output
     public String formatPeriod(String name, String start, String end) {
         return name + ": " + start + " - " + end;
     }

 }

