package automanage_user.automagane_user.aplication.services;

import automanage_user.automagane_user.domain.entity.Employed;
import automanage_user.automagane_user.infraestructure.interfaceService.IEmployed;
import automanage_user.automagane_user.infraestructure.repository.EmployedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployedService implements IEmployed {
    @Autowired
    private EmployedRepository employedRepository;
    @Override
    public void save(Employed infoEmpleado) {
        employedRepository.save(infoEmpleado);
    }

    @Override
    public Optional<Employed> findById(Long id) {
        return employedRepository.findById(id);
    }
}
