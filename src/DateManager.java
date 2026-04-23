 public class DateManager {


     // Store up to 30 different dates
     String[] dates = new String[30];

     // Each date can have up to 10 class periods
     String[][] classNames = new String[30][10];
     String[][] startTimes = new String[30][10];
     String[][] endTimes = new String[30][10];

     int[] counts = new int[30]; // number of classes per day
     int totalDates = 0;

     // Method to get today's date automatically
     public String getTodayDate() {
         long millis = System.currentTimeMillis();
         long days = millis / (1000 * 60 * 60 * 24);
         return "DAY_" + days; // simple unique date key
     }

     // Method to add/update schedule for today
     public void DateManager(String name, String start, String end) {

         String today = getTodayDate();
         int index = -1;

         // Check if today's schedule already exists
         for (int i = 0; i < totalDates; i++) {
             if (dates[i].equals(today)) {
                 index = i;
                 break;
             }
         }

         // If not found, create new date entry
         if (index == -1) {
             index = totalDates;
             dates[index] = today;
             counts[index] = 0;
             totalDates++;
         }

         // Error check: time validity
         if (start.compareTo(end) >= 0) {
             System.out.println("Error: Start time must be before end time.");
             return;
         }

         // Check if class already exists → update
         for (int i = 0; i < counts[index]; i++) {
             if (classNames[index][i].equals(name)) {
                 startTimes[index][i] = start;
                 endTimes[index][i] = end;
                 System.out.println("Updated for today: " + name);
                 return;
             }
         }

         // Add new class
         if (counts[index] < 10) {
             classNames[index][counts[index]] = name;
             startTimes[index][counts[index]] = start;
             endTimes[index][counts[index]] = end;
             counts[index]++;
             System.out.println("Added for today: " + name);
         } else {
             System.out.println("Error: Daily schedule full.");
         }
     }

     // Method to display today's schedule
     public void displayTodaySchedule() {
         String today = getTodayDate();

         for (int i = 0; i < totalDates; i++) {
             if (dates[i].equals(today)) {

                 if (counts[i] == 0) {
                     System.out.println("Error: No schedule found for today.");
                     return;
                 }

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

         System.out.println("Error: No schedule set for today.");
     }
 }
