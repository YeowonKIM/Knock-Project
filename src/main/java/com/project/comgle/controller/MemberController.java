package com.project.comgle.controller;

import com.project.comgle.dto.request.CompanyRequestDto;

import com.project.comgle.dto.request.LoginRequestDto;

import com.project.comgle.dto.request.SignupRequestDto;
import com.project.comgle.dto.response.MessageResponseDto;
import com.project.comgle.exception.ErrorResponse;
import com.project.comgle.security.UserDetailsImpl;
import com.project.comgle.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> validException(BindingResult result){
        log.error("error msg = {}",result.getFieldError().getDefaultMessage());
        return ResponseEntity.badRequest()
                .body(ErrorResponse.of(HttpStatus.BAD_REQUEST.value(), result.getFieldError().getDefaultMessage()));
    }

    @PostMapping("/company")
    public ResponseEntity<MessageResponseDto> companyAdd(@Valid @RequestBody CompanyRequestDto companyRequestDto){
        return memberService.companyAdd(companyRequestDto);
    }

    @PostMapping("/signup")
    public ResponseEntity<MessageResponseDto> signup(@Valid @RequestBody SignupRequestDto signupRequestDto,@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return memberService.signup(signupRequestDto, userDetails.getUser());
    }

    @PostMapping("/login")
    public ResponseEntity<MessageResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response){
        return memberService.login(loginRequestDto,response);
    }

    @GetMapping("/check/email/{email}")
    public ResponseEntity<MessageResponseDto> checkEmail(@PathVariable String email, @AuthenticationPrincipal UserDetailsImpl userDetails ){
        memberService.checkEmail(email,userDetails.getUser().getCompany());
        return ResponseEntity.ok(MessageResponseDto.of(HttpStatus.OK.value(),"사용 가능합니다."));
    }

    @GetMapping("/check/name/{member-name}")
    public ResponseEntity<MessageResponseDto> checkName(@PathVariable(name = "member-name") String memberName, @AuthenticationPrincipal UserDetailsImpl userDetails){
        memberService.checkName(memberName,userDetails.getUser().getCompany());
        return ResponseEntity.ok(MessageResponseDto.of(HttpStatus.OK.value(),"사용 가능합니다."));
    }
}