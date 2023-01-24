package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.domain.entity.Employed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployedRepository extends JpaRepository<Employed,Long> {
}
