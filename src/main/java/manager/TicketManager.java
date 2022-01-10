package manager;

import domain.Ticket;
import repository.TicketRepository;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class TicketManager {
    TicketRepository repository = new TicketRepository();

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public TicketManager() {
    }

    public void add(Ticket ticket){
        repository.save(ticket);
    }

    public Ticket[] searchBy(String text) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket: repository.findAll()) {
            if (matches(ticket, text)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                Arrays.sort(result);
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }


    public boolean matches(Ticket ticket, String search) {
            if (ticket.getDepartureAirport().contains(search)) {
                return true;
            }
            if (ticket.getArrivalAirport().contains(search)) {
                return true;
            }
            return false;
        }


}




