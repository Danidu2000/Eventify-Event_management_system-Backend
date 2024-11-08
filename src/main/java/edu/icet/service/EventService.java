package edu.icet.service;

import edu.icet.dto.Event;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface EventService extends CrudService<Event> {
    Integer add(Event event,MultipartFile image) throws IOException;
    void update(Event event,MultipartFile image) throws IOException;

    List<Event> getEventsByOrganizerId(Integer id);
}
