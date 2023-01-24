package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.domain.entity.UserCash;
import automanage_user.automagane_user.infraestructure.interfaceService.IUserCash;
import automanage_user.automagane_user.infraestructure.repository.UserCashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCashService implements IUserCash {

    @Autowired
    private UserCashRepository userCashRepository;
    @Override
    public void save(UserCash infoUsuario) {
        userCashRepository.save(infoUsuario);
    }

    @Override
    public Optional<UserCash> findById(Long id) {
        return userCashRepository.findById(id);
    }

}
