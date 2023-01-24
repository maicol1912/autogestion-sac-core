package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.domain.entity.User;
import automanage_user.automagane_user.infraestructure.interfaceService.IUser;
import automanage_user.automagane_user.infraestructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUser {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }
}
