package utils;

import repositories.TicketRepository;

public class TicketFactory {
    private static TicketRepository ticketInstance;
    private TicketFactory(){

    }
    public static TicketRepository getInstance() {
        if (ticketInstance == null) {
            synchronized (TicketRepository.class) {
                if (ticketInstance == null) {
                    ticketInstance = new TicketRepository();
                }
            }
        }
        return ticketInstance;
    }
}
