package test.infrastructure.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.domain.member.MemberReader;

@RequiredArgsConstructor
@Component
public class MemberReaderImpl implements MemberReader {
    private final MemberRepository memberRepository;
    @Override
    public boolean checkMember(String userId, String password) {
        return memberRepository.existsByUserIdAndPassword(userId, password);
    }
}
