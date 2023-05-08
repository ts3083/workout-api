package exersite.workoutapi.controller;

import exersite.workoutapi.domain.form.MemberForm;
import exersite.workoutapi.response.BasicResponse;
import exersite.workoutapi.response.GeneralResponse;
import exersite.workoutapi.service.MemberService;
import exersite.workoutapi.validator.MemberFormValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberFormValidator memberFormValidator;

    @InitBinder("memberForm")
    public void memberFormInitBinder(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(memberFormValidator);
    }

    @PostMapping("/new")
    public ResponseEntity<? extends BasicResponse> create(@Valid @RequestBody MemberForm memberForm) {
        // Valid 에러는 ExceptionController 에서 처리
        return ResponseEntity.ok()
                .body(new GeneralResponse<>(memberService.join(memberForm)));
    }
}
