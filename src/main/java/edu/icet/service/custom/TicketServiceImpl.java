package edu.icet.service.custom;

import edu.icet.dto.Ticket;
import edu.icet.entity.TicketEntity;
import edu.icet.repository.TicketRepository;
import edu.icet.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {
    private final TicketRepository repository;
    private final ModelMapper mapper;
    @Override
    public void add(Ticket ticket) {
        repository.save(mapper.map(ticket, TicketEntity.class));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Ticket> getAll() {
        List<Ticket> ticketArrayList = new ArrayList<>();
        repository.findAll().forEach(ticketEntity -> {
            ticketArrayList.add(mapper.map(ticketEntity, Ticket.class));
        });
        return ticketArrayList;
    }

    @Override
    public void update(Ticket ticket) {
        repository.save(mapper.map(ticket, TicketEntity.class));
    }

    @Override
    public Ticket searchById(Integer id) {
        return mapper.map(repository.findById(id), Ticket.class);
    }
}
