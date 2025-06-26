package OneMoment.demo.domain.user.repository;

import OneMoment.demo.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findBySsaid(String ssaid);
}
