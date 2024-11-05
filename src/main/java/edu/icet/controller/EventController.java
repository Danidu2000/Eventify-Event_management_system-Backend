package edu.icet.controller;

import edu.icet.dto.Event;
import edu.icet.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    public void addEvent(@RequestPart("event") Event event, @RequestPart("image") MultipartFile image){
        try {
            service.add(event,image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @PutMapping("/update-event")
    public void updateEvent(@RequestPart("event") Event event, @RequestPart("image") MultipartFile image){
        try {
            service.update(event, image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
