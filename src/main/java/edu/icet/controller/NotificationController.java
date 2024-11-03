package edu.icet.controller;

import edu.icet.dto.Notification;
import edu.icet.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notification")
@RequiredArgsConstructor
public class NotificationController {
    @Autowired
    final NotificationService service;
    @GetMapping("/get-all")
    public List<Notification> getAll(){
        return service.getAll();
    }
    @PostMapping("/add-notification")
    public void addNotification(@RequestBody Notification notification){
        service.add(notification);
    }
    @PutMapping("/update-notification")
    public void updateNotification(@RequestBody Notification notification){
        service.update(notification);
    }
    @DeleteMapping("/deleteById-by-id/{id}")
    public void deleteNotification(@PathVariable Integer id){
        service.deleteById(id);
    }
    @GetMapping("/search-by-id/{id}")
    public Notification searchUserById(@PathVariable Integer id){
        return service.searchById(id);
    }
}
