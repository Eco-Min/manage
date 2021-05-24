package socerteam.manage.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import socerteam.manage.domain.Member;
import socerteam.manage.dto.MemberTeamDto;
import socerteam.manage.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        checkDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    public List<Member> findAllMember() {
        return memberRepository.findMemberTeamEntityGraph();
    }

    private void checkDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalThreadStateException("이미 존재하는 회원 입니다.");
        }
    }
}
