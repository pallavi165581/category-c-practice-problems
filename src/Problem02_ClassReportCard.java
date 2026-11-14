import java.util.ArrayList;
import java.util.List;

public class Problem02_ClassReportCard {

    static class Student {
        private String name;
        private int[] marks = new int[3];

        Student(String name) {
            this.name = name;
        }

        // Accepts marks only if all three are within 0..100.
        boolean setMarks(int a, int b, int c) {
            if (a < 0 || a > 100 || b < 0 || b > 100 || c < 0 || c > 100) return false;
            marks[0] = a; marks[1] = b; marks[2] = c;
            return true;
        }

        int total() {
            return marks[0] + marks[1] + marks[2];
        }

        double avg() {
            return total() / 3.0;   // 3.0 keeps the decimals
        }

        char grade() {
            double a = avg();
            if (a >= 80) return 'A';
            if (a >= 70) return 'B';
            if (a >= 60) return 'C';
            if (a >= 40) return 'D';
            return 'F';
        }

        @Override public String toString() {
            return String.format("%s total=%d avg=%.2f grade=%c", name, total(), avg(), grade());
        }
    }

    // Bubble sort (descending by total) that stops early when a pass makes no
    // swap. Returns the number of passes that actually swapped.
    // Best case O(n) when already sorted; worst case O(n^2).
    static int sortByTotal(Student[] a) {
        int passes = 0;
        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j].total() < a[j + 1].total()) {
                    Student t = a[j]; a[j] = a[j + 1]; a[j + 1] = t;
                    swapped = true;
                }
            }
            if (!swapped) break;
            passes++;
        }
        return passes;
    }

    public static void main(String[] args) {
        String[][] input = {
            {"Asha", "80", "90", "70"},
            {"Ravi", "60", "65", "70"},
            {"Neha", "95", "85", "105"},
            {"Kiran", "45", "50", "40"},
            {"Pooja", "88", "72", "81"}
        };

        List<Student> accepted = new ArrayList<>();
        for (String[] row : input) {
            Student s = new Student(row[0]);
            int a = Integer.parseInt(row[1]), b = Integer.parseInt(row[2]), c = Integer.parseInt(row[3]);
            if (!s.setMarks(a, b, c))
                System.out.println(row[0] + " skipped: marks must be 0 to 100");
            else
                accepted.add(s);
        }

        Student[] arr = accepted.toArray(new Student[0]);
        int passes = sortByTotal(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.println((i + 1) + ". " + arr[i]);
        System.out.println("Sorted in " + passes + " passes");
    }
}
