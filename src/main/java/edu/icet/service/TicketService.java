package edu.icet.service;

import edu.icet.dto.Event;
import edu.icet.dto.Ticket;

import java.util.List;

public interface TicketService extends CrudService<Ticket> {
    List<Ticket> getTicketsByOrganizerId(Integer id);

    List<Ticket> getTicketsByEventId(Integer id);
}
