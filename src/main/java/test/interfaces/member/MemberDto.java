package test.interfaces.member;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import test.domain.member.Member;

public class MemberDto {

    @Getter
    @Setter
    @ToString
    public static class RegisterMember {
        private String userId;
        private String name;
        private String password;
        private String email;

        public Member toEntity() {
            return Member.builder()
                    .userId(userId)
                    .username(name)
                    .email(email)
                    .password(password)
                    .build();
        }
    }

    @ToString
    @Getter
    @Setter
    public static class Login {
        private String userId;
        private String password;
    }

    @Getter
    @Setter
    @ToString
    public static class ResponseLogin {
        private String token;

        @Builder
        public ResponseLogin(String token) {
            this.token = token;
        }
    }
}
