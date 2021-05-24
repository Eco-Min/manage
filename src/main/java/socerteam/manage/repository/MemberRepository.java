package socerteam.manage.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import socerteam.manage.domain.Member;
import socerteam.manage.dto.MemberTeamDto;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m left join fetch m.team")
    List<Member> findMemberFetchAll();

    List<Member> findByName(String name);

    @EntityGraph(attributePaths = {"team"})
    @Query("select m from Member m")
    List<Member> findMemberTeamEntityGraph();
//    @Query("select new socerteam.manage.dto.MemberTeamDto(m.name, m.age, t.teamName) from Member m join m.team t")
//    List<MemberTeamDto> findMemberTeamEntityGraph();
}
