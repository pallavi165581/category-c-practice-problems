public class Problem05_WeeklyRainfallAnalysis {

    // One pass: O(n) time, O(1) extra space besides the double[7] array.
    public static void main(String[] args) {
        double[] rainfall = {12, 0, 25, 18, 0, 30, 15};

        double total = 0;
        int wettest = 0;      // index of the largest value
        int dryDays = 0;
        for (int i = 0; i < rainfall.length; i++) {
            total += rainfall[i];
            if (rainfall[i] > rainfall[wettest]) wettest = i;
            if (rainfall[i] == 0) dryDays++;
        }

        System.out.print("Rainfall (mm):");
        for (double r : rainfall) System.out.printf(" %.1f", r);
        System.out.println();
        System.out.printf("Total Rainfall: %.1f mm%n", total);
        System.out.printf("Average Rainfall: %.2f mm%n", total / rainfall.length);
        System.out.printf("Wettest Day: Day %d (%.1f mm)%n", wettest + 1, rainfall[wettest]);
        System.out.println("Total Dry Days: " + dryDays);
    }
}
