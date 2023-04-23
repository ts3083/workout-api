package exersite.workoutapi.config.principal;

import exersite.workoutapi.domain.member.Member;
import exersite.workoutapi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String emailOrNickname) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(emailOrNickname);
        if (member == null) {
            member = memberRepository.findByNickname(emailOrNickname);
        }
        if (member == null) {
            throw new UsernameNotFoundException(emailOrNickname);
        }
        return new PrincipalDetails(member);
    }
}
