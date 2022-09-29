package com.mhc3.mhc3_3tory.config.response;

import lombok.Getter;
@Getter
public enum BaseResponseStatus {
    /**
     * 1000 :요청 성공
     */
    SUCCESS(true, 1000, "요청에 성공하였습니다."),


    /**
     * 2000 : Request오류
     */
    REQUEST_ERROR(false, 2000, "입력값을 확인해주세요."),
    INVALID_QUESTION_NUMBER(false,2010,"질문번호가 잘못되었습니다."),
    INVALID_ANSWER_Q1(false,2011,"Q1에 입력가능한 답안은 1,2,3 입니다."),
    INVALID_ANSWER_Q2(false,2012,"Q2에 입력가능한 답안은 1,2,3 입니다."),
    INVALID_ANSWER_Q3(false,2013,"Q3에 입력가능한 답안은 1,2,3,4입니다."),
    INVALID_ANSWER_Q4(false,2014,"Q4에 입력가능한 답안은 1,2 입니다."),
    INVALID_ANSWER_Q5(false,2015,"Q5에 입력가능한 답안은 1,2,3 입니다."),
    INVALID_ANSWER_Q6(false,2016,"Q6에 입력가능한 답안은 1,2 입니다."),

    /**
     * 4000 : Database, Server오류
     */
    DATABASE_ERROR(false, 4000, "데이터베이스 연결에 실패하였습니다."),
    SERVER_ERROR(false, 4001, "서버와의 연결에 실패하였습니다.");


    private final boolean isSuccess;
    private final int code;
    private final String message;

    private BaseResponseStatus(boolean isSuccess, int code, String message){
        this.isSuccess = isSuccess;
        this.code = code;
        this.message = message;
    }
}
