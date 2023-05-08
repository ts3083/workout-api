package exersite.workoutapi.validator;

import exersite.workoutapi.domain.form.MemberForm;
import exersite.workoutapi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


@Component
@RequiredArgsConstructor
public class MemberFormValidator implements Validator {

    private final MemberRepository memberRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(MemberForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // 이메일과 닉네임 중복 검사
        MemberForm memberForm = (MemberForm) target;
        if (memberRepository.existsByEmail(memberForm.getEmail())) {
            errors.rejectValue("email", "invalid.email",
                    new Object[]{memberForm.getEmail()}, "이미 사용중인 이메일입니다.");
        }
        if (memberRepository.existsByNickname(memberForm.getNickname())) {
            errors.rejectValue("nickname", "invalid.nickname",
                    new Object[]{memberForm.getNickname()}, "이미 사용중인 닉네임입니다.");
        }
    }
}
