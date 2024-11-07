package edu.icet.service.custom;

import edu.icet.dto.Event;
import edu.icet.entity.EventEntity;
import edu.icet.repository.EventRepository;
import edu.icet.service.EventService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository repository;
    private final ModelMapper mapper;
    private static final String UPLOAD_DIR = "C:/uploads/";
    @Override
    public void add(Event event, MultipartFile image) throws IOException {
        EventEntity eventEntity = mapper.map(event, EventEntity.class);

        if (image != null && !image.isEmpty()) {
            saveImage(image, eventEntity);
        }

        repository.save(eventEntity);
    }

    private void saveImage(MultipartFile image, EventEntity eventEntity) throws IOException {
        String fileName = image.getOriginalFilename();
        Path uploadPath = Paths.get(UPLOAD_DIR);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(fileName);
        image.transferTo(filePath.toFile());

        eventEntity.setImagePath(filePath.toString());
    }

    @Override
    public void add(Event event) {

    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Event> getAll() {
        List<Event> eventArrayList = new ArrayList<>();
        repository.findAll().forEach(eventEntity -> {
            eventArrayList.add(mapper.map(eventEntity, Event.class));
        });
        return eventArrayList;
    }

    @Override
    public void update(Event event) {
        repository.save(mapper.map(event, EventEntity.class));
    }

    @Override
    public void update(Event event, MultipartFile image) throws IOException {
        Optional<EventEntity> existingEvent = repository.findById(event.getId());
        if (existingEvent.isPresent()) {
            EventEntity eventEntity = existingEvent.get();
            eventEntity.setTitle(event.getTitle());
            eventEntity.setDescription(event.getDescription());

            // Update the image file if provided
            if (image != null && !image.isEmpty()) {
                String fileName = image.getOriginalFilename();
                Path uploadPath = Paths.get(UPLOAD_DIR);

                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                Path filePath = uploadPath.resolve(fileName);
                image.transferTo(filePath.toFile());

                eventEntity.setImagePath(filePath.toString());
            }

            repository.save(eventEntity);
        }
    }

    @Override
    public List<Event> getEventsByOrganizerId(Integer id) {
        List<Event> eventArrayList = new ArrayList<>();
        repository.findByOrganizerId(id).forEach(eventEntity -> {
                eventArrayList.add(mapper.map(eventEntity, Event.class));
            });
            return eventArrayList;
    }

    @Override
    public Event searchById(Integer id) {
        return mapper.map(repository.findById(id), Event.class);
    }
}
