import java.util.concurrent.locks.*;

class TicketBooking implements Runnable {
    private static int availableSeats = 10;
    private static final Lock lock = new ReentrantLock();
    private String name;

    public TicketBooking(String name) {
        this.name = name;
    }

    public void run() {
        lock.lock();
        try {
            if (availableSeats > 0) {
                System.out.println(name + " booked seat number " + availableSeats);
                availableSeats--;
            } else {
                System.out.println(name + " booking failed. No seats available.");
            }
        } finally {
            lock.unlock();
        }
    }
}

public class TicketSystem {
    public static void main(String[] args) {
        Thread t1 = new Thread(new TicketBooking("VIP User"));
        Thread t2 = new Thread(new TicketBooking("Regular User"));
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
