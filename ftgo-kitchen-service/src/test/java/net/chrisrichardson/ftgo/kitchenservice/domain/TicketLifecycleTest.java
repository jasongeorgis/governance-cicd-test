package net.chrisrichardson.ftgo.kitchenservice.domain;

import net.chrisrichardson.ftgo.kitchenservice.api.TicketDetails;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.fail;

public class TicketLifecycleTest {
  @Test
  public void acceptedTicketCanStartPreparation() {
    Ticket ticket = new Ticket(1L, 2L, new TicketDetails());
    ticket.confirmCreate();
    ticket.accept(LocalDateTime.now().plusHours(1));
    ticket.preparing();
  }

  @Test
  public void rejectedReadyTimeDoesNotPreventLaterAcceptance() {
    Ticket ticket = new Ticket(1L, 2L, new TicketDetails());
    ticket.confirmCreate();
    try {
      ticket.accept(LocalDateTime.now().minusHours(1));
      fail("Expected an invalid ready time to be rejected");
    } catch (IllegalArgumentException expected) {
      // A later valid acceptance must still be possible.
    }
    ticket.accept(LocalDateTime.now().plusHours(1));
    ticket.preparing();
  }
}
