public class Problem04_PaymentProcessing {

    interface PaymentMode {
        double processPayment(double amount);
        String label();
    }

    static class CashPayment implements PaymentMode {
        public String label() { return "Cash"; }
        public double processPayment(double amount) { return amount; }
    }

    static class CardPayment implements PaymentMode {
        public String label() { return "Card"; }
        public double processPayment(double amount) { return amount * 1.02; }
    }

    static class UpiPayment implements PaymentMode {
        public String label() { return "UPI"; }
        public double processPayment(double amount) { return amount; }
    }

    // Processing all payments: O(n) -- one pass over the PaymentMode[] array.
    public static void main(String[] args) {
        PaymentMode[] modes = {
            new CashPayment(), new CardPayment(), new UpiPayment(), new CardPayment()
        };
        double[] amounts = {1000, 2000, 1500, 3000};

        double totalProcessed = 0;
        for (int i = 0; i < modes.length; i++) {
            PaymentMode m = modes[i];
            double processed = m.processPayment(amounts[i]);
            double fee = processed - amounts[i];
            totalProcessed += processed;
            System.out.printf("%s: amount %.1f, fee %.1f, processed %.1f%n",
                    m.label(), amounts[i], fee, processed);
        }
        System.out.printf("Total Amount Processed: %.1f%n", totalProcessed);
    }
}
