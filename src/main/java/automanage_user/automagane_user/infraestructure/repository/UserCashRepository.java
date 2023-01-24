package automanage_user.automagane_user.infraestructure.repository;

import automanage_user.automagane_user.domain.entity.UserCash;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCashRepository extends JpaRepository<UserCash,Long> {
}
