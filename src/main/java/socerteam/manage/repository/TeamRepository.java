package socerteam.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import socerteam.manage.domain.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
