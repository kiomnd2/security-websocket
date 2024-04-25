package test.application.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import test.domain.member.MemberReader;
import test.domain.member.MemberStore;
import test.domain.member.TokenProvider;
import test.interfaces.member.MemberDto;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberStore memberStore;
    private final MemberReader memberReader;
    private final TokenProvider tokenProvider;

    public void register(MemberDto.RegisterMember registerMember) {
        memberStore.store(registerMember.toEntity());
    }

    public String login(String userId, String password) {
        if (memberReader.checkMember(userId, password)) {
            return tokenProvider.createToken(userId);
        } else {
            throw new RuntimeException("사용자를 찾을 수 없음");
        }
    }
}
