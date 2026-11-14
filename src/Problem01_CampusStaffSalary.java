public class Problem01_CampusStaffSalary {

    static class Staff {
        String name;
        double baseSalary;

        Staff(String name, double baseSalary) {
            this.name = name;
            this.baseSalary = baseSalary;
        }

        // Overridable bonus; plain staff get none.
        double getBonus() {
            return 0.0;
        }

        double getTotal() {
            return baseSalary + getBonus();
        }

        String type() {
            return getClass().getSimpleName();
        }
    }

    static class Teacher extends Staff {
        Teacher(String name, double baseSalary) { super(name, baseSalary); }
        @Override double getBonus() { return 5000.0; }
    }

    static class LabAssistant extends Staff {
        LabAssistant(String name, double baseSalary) { super(name, baseSalary); }
        @Override double getBonus() { return 2000.0; }
    }

    // Printing all salaries: O(n) -- one pass over the Staff[] array.
    public static void main(String[] args) {
        Staff[] staff = {
            new Teacher("Rahul", 30000),
            new LabAssistant("Priya", 20000),
            new Staff("Amit", 25000),
            new Teacher("Sneha", 35000),
            new LabAssistant("Karan", 18000)
        };

        double grandTotal = 0;
        for (Staff s : staff) {   // single loop
            double total = s.getTotal();
            grandTotal += total;
            System.out.printf("%s (%s): base %.1f, bonus %.1f, total %.1f%n",
                    s.name, s.type(), s.baseSalary, s.getBonus(), total);
        }
        System.out.printf("Grand Total Salary: %.1f%n", grandTotal);
    }
}
