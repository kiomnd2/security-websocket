package test.infrastructure.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import test.domain.member.Member;
import test.domain.member.MemberStore;

@RequiredArgsConstructor
@Component
public class MemberStoreImpl implements MemberStore {
    private final MemberRepository memberRepository;
    @Override
    public Member store(Member member) {
        return memberRepository.save(member);
    }
}
