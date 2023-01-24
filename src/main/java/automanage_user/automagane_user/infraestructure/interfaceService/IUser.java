package automanage_user.automagane_user.infraestructure.interfaceService;

import automanage_user.automagane_user.domain.entity.User;

import java.util.Optional;

public interface IUser {
    public void save(User infoUsuario);

    public Optional<User> findById(Long id);
}
