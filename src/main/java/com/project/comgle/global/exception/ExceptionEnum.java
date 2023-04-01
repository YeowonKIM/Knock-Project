package com.project.comgle.global.exception;

import lombok.Getter;

@Getter
public enum ExceptionEnum {

    /* 로그인 */
    // 잘못된 이메일 입니다.
    WRONG_EMAIL(400,"Invalid email."),
    // 잘못된 비밀번호 입니다.
    WORNG_PASSWORD(400,"Invalid password."),
    // 유효한 이메일 형식이 아닙니다.
    INVALID_EMAIL_REG(400,"Invalid email format."),
    // 비밀번호는 대소문자, 숫자, 특수문자를 포함하여 8-32자 이내여야 합니다.
    INVALID_PASSWD_REG(400,"Password must be 8-32 characters long, including case, number, and special characters."),
    //토큰이 유효하지 않습니다.
    INVALID_TOKEN(400,"Token is not valid."),
    // 잘못된 요청값입니다
    INVALID_VALUE(400,"Invalid request value."),
    // SMS 전송 에러발생입니다.
    SMS_SEND_ERR(400,"fail send sms message"),
    // SMS 전송 에러발생입니다.
    INVALID_AUTHENTICATION_CODE(400,"Invalid authentication code"),
    // SMS 인증한 내역이 없을경우
    NOT_EXIST_AUTHENTICATION_CODE(400," Not exist authentication code"),

    /* 계정 권한 */
    // ADMIN 권한이 필요합니다.
    REQUIRED_ADMIN_POSITION(400, "ADMIN permissions required."),
    // ADMIN 계정으로 직책을 변경할 수 없습니다.
    IMMULATABLE_TO_ADMIN(400,"You cannot change your position with the ADMIN account."),
    // ADMIN 계정은 직책을 변경할 수 없습니다.
    IMMULATABLE_ADMIN_POSITION(400, "The ADMIN account cannot change its position."),
    // 수정할 수 있는 권한이 없습니다.
    INVALID_PERMISSION_TO_MODIFY(400,"You do not have permission to modify."),
    // 읽을 수 있는 권한이 없습니다.
    INVALID_PERMISSION_TO_READ(400,"You do not have permission to read."),

    /* 존재하지 않는 요소 */
    // 해당 직책이 존재하지 않습니다.
    NOT_EXIST_POSITION(400,"The position does not exist."),
    // 해당 계정(사용자)이 존재하지 않습니다.
    NOT_EXIST_MEMBER(400,"That account(member) doesn't exist."),
    // 해당 회사가 존재하지 않습니다.
    NOT_EXIST_COMPANY(400, "The company does not exist."),
    // 해당 폴더가 존재하지 않습니다.
    NOT_EXIST_FOLDER(400,"The folder does not exist."),
    // 해당 게시글이 존재하지 않습니다.
    NOT_EXIST_POST(400,"The post does not exist."),
    // 해당 카테고리가 존재하지 않습니다.
    NOT_EXIST_CATEGORY(400,"The category does not exist."),
    // 해당 댓글이 존재하지 않습니다.
    NOT_EXIST_COMMENT(400,"The comment does not exist."),

    /* 중복 */
    // 중복된 회사가 존재합니다.
    DUPLICATE_COMPANY(400, "Duplicate company exists."),
    // 중복된 이메일이 존재합니다.
    DUPLICATE_EMAIL(400, "Duplicate email exists."),
    // 중복된 사용자가 존재합니다.
    DUPLICATE_MEMBER(400, "Duplicate member exists."),
    // 중복된 게시글이 존재합니다.
    DUPLICATE_POST(400, "Duplicate post exists."),
    // 중복된 폴더가 존재합니다.
    DUPLICATE_FOLDER(400, "Duplicate folder exists."),
    // 중복된 카테고리가 존재합니다.
    DUPLICATE_CATEGORY(400,"Duplicate category exists."),

    /* 그 외 */
    // 최대 폴더 갯수를 초과하였습니다.
     EXCEED_FOLDER_NUM(400,"Maximum number of folders exceeded");

    private final int code;
    private final String msg;

    ExceptionEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}