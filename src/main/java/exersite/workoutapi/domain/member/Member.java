package exersite.workoutapi.domain.member;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id") // 연관관계가 복잡해질 때, 다른 연관관계를 순환 참조하느라 무한루프 발생할 수 있음을 id만 사용하는 것으로 해결
public class Member {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    @Embedded
    private Address address;

    /*@OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();*/

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus; // 회원 상태 [MEMBER, DELETED]

    private String name;
    @Column(unique = true)
    private String nickname;
    private String password;
    private LocalDateTime memberDate;

    // 생성메서드
    public static Member createMember(String email, Address address,
                                      String name, String nickname,
                                      String password) {
        Member member = new Member();
        member.setEmail(email);
        member.setAddress(address);
        member.setName(name);
        member.setNickname(nickname);
        member.setMemberStatus(MemberStatus.MEMBER);
        member.setPassword(password);
        member.setMemberDate(LocalDateTime.now());
        return member;
    }
}
