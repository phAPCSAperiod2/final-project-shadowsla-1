  import java.util.Scanner;

  public class Schedule {

      public static void main(String[] args) {
          Scanner input = new Scanner(System.in);

          String[] classNames = new String[10];
          int[] hours = new int[10];
         int[] minutes = new int[10];

         int numClasses;

         System.out.print("Enter number of classes (max 10): ");
         numClasses = input.nextInt();
         input.nextLine(); // clear buffer

         // Input classes
         for (int i = 0; i < numClasses; i++) {
             System.out.print("Enter class name: ");
             classNames[i] = input.nextLine();

             System.out.print("Enter start hour (0-23): ");
             hours[i] = input.nextInt();

             System.out.print("Enter start minutes (0-59): ");
             minutes[i] = input.nextInt();
             input.nextLine(); // clear buffer
         }

         // Output schedule
         System.out.println("\n--- Your Schedule ---");
         for (int i = 0; i < numClasses; i++) {
             System.out.println(classNames[i] + " at "
                 + hours[i] + ":" + (minutes[i] < 10 ? "0" : "") + minutes[i]);
         }

         // Calculate gaps
         System.out.println("\n--- Time Between Classes ---");
         for (int i = 0; i < numClasses - 1; i++) {

             int currentTime = hours[i] * 60 + minutes[i];
             int nextTime = hours[i + 1] * 60 + minutes[i + 1];

             int gap = nextTime - currentTime;

             System.out.println("Between " + classNames[i] + " and "
                 + classNames[i + 1] + ": " + gap + " minutes");

             if (gap < 10) {
                 System.out.println("WARNING: You might be late!");
             }
         }

         input.close();
     }
 }

