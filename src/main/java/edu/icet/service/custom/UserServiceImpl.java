package edu.icet.service.custom;

import edu.icet.dto.LoginDetails;
import edu.icet.dto.LoginStatus;
import edu.icet.dto.User;
import edu.icet.entity.UserEntity;
import edu.icet.repository.UserRepository;
import edu.icet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public LoginStatus login(LoginDetails loginDetails) {
        Optional<UserEntity> savedDetails = repository.findByEmail(loginDetails.getEmail());
        if (savedDetails.isPresent()){
            String savedEmail = savedDetails.get().getEmail();
            String savedPassword = savedDetails.get().getPassword();
            if (loginDetails.getEmail().equals(savedEmail)&&loginDetails.getPassword().equals(savedPassword)){
                return new LoginStatus(true,"Login Success");
            }else {
                return new LoginStatus(false,"Incorrect password");
            }

        }else {
            return new LoginStatus(false,"User email is not registered");
        }
    }
}
