public class Problem03_LibraryReturnDesk {

    // Stack on an array of size 3 -- every op is O(1).
    static class BookPile {
        private String[] pile = new String[3];
        private int top = -1;

        void push(String book) {
            if (top == pile.length - 1) {
                System.out.println(book + " rejected: pile is full");
                return;
            }
            pile[++top] = book;
            System.out.println(book + " placed on pile");
        }

        void pop() {
            if (top == -1) {
                System.out.println("pile is empty");
                return;
            }
            System.out.println("shelved " + pile[top--]);
        }
    }

    // Circular queue on an array of size 3 -- every op is O(1).
    static class StudentLine {
        private String[] line = new String[3];
        private int front = 0, rear = 0, size = 0;

        void enqueue(String name) {
            if (size == line.length) {
                System.out.println(name + " rejected: line is full");
                return;
            }
            line[rear] = name;
            rear = (rear + 1) % line.length;
            size++;
            System.out.println(name + " joined the line");
        }

        void dequeue() {
            if (size == 0) {
                System.out.println("no one waiting");
                return;
            }
            String name = line[front];
            front = (front + 1) % line.length;
            size--;
            System.out.println("served " + name);
        }
    }

    public static void main(String[] args) {
        String[] commands = {
            "RETURN B1", "RETURN B2", "RETURN B3", "RETURN B4",
            "WAIT Asha", "WAIT Ravi", "SHELVE", "SERVE",
            "SHELVE", "SHELVE", "SHELVE", "SERVE", "SERVE"
        };

        BookPile pile = new BookPile();
        StudentLine line = new StudentLine();

        for (String cmd : commands) {
            String[] parts = cmd.split(" ");
            switch (parts[0]) {
                case "RETURN": pile.push(parts[1]); break;
                case "SHELVE": pile.pop(); break;
                case "WAIT":   line.enqueue(parts[1]); break;
                case "SERVE":  line.dequeue(); break;
            }
        }
    }
}
