package socerteam.manage.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class MemberTeamDto {
    private String MemberName;
    private int age;
    private String TeamName;

    public MemberTeamDto(String memberName, int age, String teamName) {
        MemberName = memberName;
        this.age = age;
        TeamName = teamName;
    }
}
