package socerteam.manage.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import socerteam.manage.domain.Member;
import socerteam.manage.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TeamRepository teamRepository;

    @Test
    public void testMember() {
        Team teamA = new Team("teamA", LocalDate.of(1980, 1, 22));
        Team teamB = new Team("teamB", LocalDate.of(1992, 12, 30));
        List<Team> teams = List.of(teamA, teamB);
        for (Team team : teams) {
            teamRepository.save(team);
        }

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamA);
        Member member4 = new Member("member4", 40, teamB);
        Member member5 = new Member("member5", 50, teamB);
        List<Member> members = List.of(member1, member2, member3, member4, member5);
        for (Member member : members) {
            memberRepository.save(member);
        }

        List<Member> all = memberRepository.findAll();
        for (Member member : all) {
            System.out.println("member.getId() = " + member.getId());
            System.out.println("member.getName() = " + member.getName());
        }
    }
}