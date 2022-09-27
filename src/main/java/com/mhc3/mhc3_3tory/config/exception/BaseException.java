package com.mhc3.mhc3_3tory.config.exception;

import com.mhc3.mhc3_3tory.config.response.BaseResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseException extends Exception{

    private BaseResponseStatus status;
}