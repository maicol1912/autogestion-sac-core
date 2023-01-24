package automanage_user.automagane_user.infraestructure.interfaceService;

import automanage_user.automagane_user.domain.entity.Employed;

import java.util.Optional;

public interface IEmployed {

    public void save(Employed infoEmpleado);

    public Optional<Employed> findById(Long id);

}
