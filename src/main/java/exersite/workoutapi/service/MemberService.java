package exersite.workoutapi.service;

import exersite.workoutapi.domain.dtos.MemberDto;
import exersite.workoutapi.domain.form.MemberForm;
import exersite.workoutapi.domain.member.Address;
import exersite.workoutapi.domain.member.Member;
import exersite.workoutapi.domain.member.MemberStatus;
import exersite.workoutapi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public MemberDto join(MemberForm memberForm) {
        Member member = Member.builder()
                .email(memberForm.getEmail())
                .address(new Address(memberForm.getCity(), memberForm.getStreet(), memberForm.getZipcode()))
                .name(memberForm.getName())
                .nickname(memberForm.getNickname())
                .password(passwordEncoder.encode(memberForm.getPassword()))
                .memberStatus(MemberStatus.MEMBER)
                .memberDate(LocalDateTime.now())
                .build();
        memberRepository.save(member);
        return new MemberDto(member);
    }
}
