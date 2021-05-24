package socerteam.manage.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import socerteam.manage.domain.Member;
import socerteam.manage.dto.MemberTeamDto;
import socerteam.manage.service.MemberService;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members")
    public String members(Model model) {
        List<Member> data = memberService.findAllMember();
        List<MemberTeamDto> collect = data.stream()
                .map(m -> new MemberTeamDto(m.getName(), m.getAge(), m.getTeam().getTeamName()))
                .collect(Collectors.toList());
        for (MemberTeamDto memberTeamDto : collect) {
            System.out.println("memberTeamDto = " + memberTeamDto);
        }
        model.addAttribute("data", collect);
        return "response/Member";
    }

}


