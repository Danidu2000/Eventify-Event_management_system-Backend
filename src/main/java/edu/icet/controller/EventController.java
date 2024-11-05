package edu.icet.controller;

import edu.icet.dto.Event;
import edu.icet.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@RequiredArgsConstructor
@CrossOrigin
public class EventController {
    @Autowired
    final EventService service;
    @GetMapping("/get-all")
    public List<Event> getAll(){
        return service.getAll();
    }
    @PostMapping("/add-event")
    public void addEvent(@RequestBody Event event){
        service.add(event);
    }
    @PutMapping("/update-event")
    public void updateEvent(@RequestBody Event event){
        service.update(event);
    }
    @DeleteMapping("/deleteById-by-id/{id}")
    public void deleteEvent(@PathVariable Integer id){
        service.deleteById(id);
    }
    @GetMapping("/search-by-id/{id}")
    public Event searchUserById(@PathVariable Integer id){
        return service.searchById(id);
    }
}