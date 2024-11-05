package edu.icet.service;

import edu.icet.dto.Event;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EventService extends CrudService<Event> {
    void add(Event event,MultipartFile image) throws IOException;
    void update(Event event,MultipartFile image) throws IOException;
}
