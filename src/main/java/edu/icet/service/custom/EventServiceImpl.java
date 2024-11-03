package edu.icet.service.custom;

import edu.icet.dto.Event;
import edu.icet.entity.EventEntity;
import edu.icet.repository.EventRepository;
import edu.icet.service.EventService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventRepository repository;
    private final ModelMapper mapper;
    @Override
    public void add(Event event) {
        repository.save(mapper.map(event, EventEntity.class));
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
    public Event searchById(Integer id) {
        return mapper.map(repository.findById(id), Event.class);
    }
}
