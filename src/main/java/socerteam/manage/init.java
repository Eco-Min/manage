package socerteam.manage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import socerteam.manage.domain.Member;
import socerteam.manage.domain.Team;
import socerteam.manage.repository.MemberRepository;
import socerteam.manage.repository.TeamRepository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class init {

    private final InitDB initDB;

    @PostConstruct
    public void init() {
        initDB.dbInit();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitDB{
        private final EntityManager em;
        public void dbInit() {
            Team teamA = new Team("teamA", LocalDate.of(1980, 1, 22));
            Team teamB = new Team("teamB", LocalDate.of(1992, 12, 30));
            List<Team> teams = List.of(teamA, teamB);
            for (Team team : teams) {
                em.persist(team);
            }

            Member member1 = new Member("member1", 10, teamA);
            Member member2 = new Member("member2", 20, teamA);
            Member member3 = new Member("member3", 30, teamA);
            Member member4 = new Member("member4", 40, teamB);
            Member member5 = new Member("member5", 50, teamB);
            List<Member> members = List.of(member1, member2, member3, member4, member5);
            for (Member member : members) {
                em.persist(member);
            }
        }
    }

}
