package test.infrastructure.member;

import org.springframework.data.jpa.repository.JpaRepository;
import test.domain.member.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
    boolean existsByUserIdAndPassword(String userId, String password);
}
