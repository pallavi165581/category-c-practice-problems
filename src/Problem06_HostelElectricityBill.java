public class Problem06_HostelElectricityBill {

    // Slab billing: first 100 units @3, next 100 @5, above 200 @8, + 50 meter charge.
    static int billFor(int units) {
        int charge;
        if (units <= 100)      charge = units * 3;
        else if (units <= 200) charge = 100 * 3 + (units - 100) * 5;
        else                   charge = 100 * 3 + 100 * 5 + (units - 200) * 8;
        return charge + 50;
    }

    // Billing all rooms: O(n) -- one pass, constant work per room.
    public static void main(String[] args) {
        String[] rooms = {"A101", "A102", "B201", "B202", "C301"};
        int[] readings   = {80, 150, 260, -12, 200};

        int billed = 0, total = 0;
        for (int i = 0; i < rooms.length; i++) {
            if (readings[i] < 0) {
                System.out.println(rooms[i] + ": invalid reading");
                continue;
            }
            int bill = billFor(readings[i]);
            billed++;
            total += bill;
            System.out.printf("%s: %d units, bill %d%n", rooms[i], readings[i], bill);
        }
        System.out.printf("Rooms billed %d, total %d%n", billed, total);
    }
}
