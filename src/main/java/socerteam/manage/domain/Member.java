package socerteam.manage.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
public class Member extends BaseEntity{

    @Id
    @GeneratedValue
    @Column(name = "member_id", nullable = false)
    private Long id;

    @Column(name = "member_name")
    private String name;

    @Column(name = "member_age")
    private int age;

    @Column(name = "member_status")
    private String status;

    @Column(name = "member_birthday")
    private LocalDate birthday;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String name, int age, Team team) {
        this.name = name;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    public Member(String name, int age, String status, LocalDate birthday, Team team) {
        this.name = name;
        this.age = age;
        this.status = status;
        this.birthday = birthday;
        this.team = team;
    }

    private void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
