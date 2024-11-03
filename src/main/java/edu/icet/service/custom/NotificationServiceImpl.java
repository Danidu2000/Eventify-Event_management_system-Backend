package edu.icet.service.custom;

import edu.icet.dto.Notification;
import edu.icet.entity.NotificationEntity;
import edu.icet.repository.NotificationRepository;
import edu.icet.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository repository;
    private final ModelMapper mapper;
    @Override
    public void add(Notification notification) {
        repository.save(mapper.map(notification, NotificationEntity.class));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<Notification> getAll() {
        List<Notification> notificationArrayList = new ArrayList<>();
        repository.findAll().forEach(notificationEntity -> {
            notificationArrayList.add(mapper.map(notificationEntity,Notification.class));
        });
        return notificationArrayList;
    }

    @Override
    public void update(Notification notification) {
        repository.save(mapper.map(notification, NotificationEntity.class));
    }

    @Override
    public Notification searchById(Integer id) {
        return null;
    }
}
