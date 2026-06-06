import java.util.LinkedList;
import java.util.Queue;

public class TicketQueue {
    public static void main(String[] args) {

        Queue<String> supportTickets = new LinkedList<>();

        // Add tickets to the queue
        supportTickets.offer("Ticket #101 - Password Reset");
        supportTickets.offer("Ticket #102 - Printer Issue");
        supportTickets.offer("Ticket #103 - Email Not Working");
        supportTickets.offer("Ticket #104 - Software Installation");

        System.out.println("Current Ticket Queue:");
        System.out.println(supportTickets);

        // Process tickets in FIFO order
        System.out.println("\nProcessing Tickets:");
        while (!supportTickets.isEmpty()) {
            System.out.println("Resolved: " + supportTickets.poll());
        }

        System.out.println("\nRemaining Tickets:");
        System.out.println(supportTickets);
    }
}