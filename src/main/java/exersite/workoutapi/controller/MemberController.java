package exersite.workoutapi.controller;

import exersite.workoutapi.domain.form.MemberForm;
import exersite.workoutapi.response.BasicResponse;
import exersite.workoutapi.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

//    public ResponseEntity<? extends BasicResponse> create(@Valid @RequestBody MemberForm memberForm, BindingResult result) {
//
//    }
}
