package pl.olointeria.assessment.user;

import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    Optional<UserRole> findByName(String name);
}
