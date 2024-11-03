package edu.icet.service.custom;

import edu.icet.dto.User;
import edu.icet.entity.UserEntity;
import edu.icet.repository.UserRepository;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final ModelMapper mapper;
    @Override
    public void add(User user) {
        repository.save(mapper.map(user, UserEntity.class));
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public List<User> getAll() {
        List<User> userArrayList = new ArrayList<>();
        repository.findAll().forEach(userEntity -> {
            userArrayList.add(mapper.map(userEntity, User.class));
        });
        return userArrayList;
    }

    @Override
    public void update(User user) {
        repository.save(mapper.map(user, UserEntity.class));
    }

    @Override
    public User searchById(Integer id) {
        return mapper.map(repository.findById(id),User.class);
    }
}
