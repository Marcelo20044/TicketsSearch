package manager;

import domain.Ticket;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketManager manager = new TicketManager();
    Ticket KrasnoyarskMoscowPobeda = new Ticket(1, 6000, "KJA", "VKO", 320);
    Ticket  KrasnoyarskMoscowAeroflot = new Ticket(2, 9000, "KJA", "SVO", 320);
    Ticket KrasnoyarskMoscowNordwind = new Ticket(3, 8000, "KJA", "SVO", 300);

    @Test
    void shouldSearchBy() {
        manager.add(KrasnoyarskMoscowPobeda);
        manager.add(KrasnoyarskMoscowNordwind);
        manager.add(KrasnoyarskMoscowAeroflot);


        Ticket[] expected = new Ticket[]{KrasnoyarskMoscowPobeda, KrasnoyarskMoscowNordwind, KrasnoyarskMoscowAeroflot};
        Ticket[] actual = manager.searchBy("KJA");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySVO() {
        manager.add(KrasnoyarskMoscowPobeda);
        manager.add(KrasnoyarskMoscowNordwind);
        manager.add(KrasnoyarskMoscowAeroflot);

        Ticket[] expected = new Ticket[]{KrasnoyarskMoscowNordwind, KrasnoyarskMoscowAeroflot};
        Ticket[] actual = manager.searchBy("SVO");
        Arrays.sort(actual);
        assertArrayEquals(expected, actual);
    }
}