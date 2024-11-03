package edu.icet.controller;

import edu.icet.dto.Ticket;
import edu.icet.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketController {
    @Autowired
    final TicketService service;
    @GetMapping("/get-all")
    public List<Ticket> getAll(){
        return service.getAll();
    }
    @PostMapping("/add-ticket")
    public void addTicket(@RequestBody Ticket ticket){
        service.add(ticket);
    }
    @PutMapping("/update-ticket")
    public void updateTicket(@RequestBody Ticket ticket){
        service.update(ticket);
    }
    @DeleteMapping("/deleteById-by-id/{id}")
    public void deleteTicket(@PathVariable Integer id){
        service.deleteById(id);
    }
    @GetMapping("/search-by-id/{id}")
    public Ticket searchUserById(@PathVariable Integer id){
        return service.searchById(id);
    }
}
