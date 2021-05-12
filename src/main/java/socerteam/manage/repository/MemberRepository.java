package socerteam.manage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import socerteam.manage.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
