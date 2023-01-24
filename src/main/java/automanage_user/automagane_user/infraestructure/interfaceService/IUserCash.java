package automanage_user.automagane_user.infraestructure.interfaceService;


import automanage_user.automagane_user.domain.entity.UserCash;

import java.util.Optional;

public interface IUserCash {

    public void save(UserCash infoUsuario);

    public Optional<UserCash> findById(Long id);


}
