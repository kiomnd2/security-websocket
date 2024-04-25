package test.interfaces.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.application.member.MemberService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member")
public class MemberApi {
    private final MemberService memberService;

    @PostMapping("/sign-in")
    public String registerMember(@RequestBody MemberDto.RegisterMember registerMember) {
        memberService.register(registerMember);
        return "가입되었습니다";
    }

    @PostMapping("/logged-in")
    public MemberDto.ResponseLogin login(@RequestBody MemberDto.Login login) {
        return MemberDto.ResponseLogin.builder()
                .token(memberService.login(login.getUserId(), login.getPassword()))
                .build();
    }
}
