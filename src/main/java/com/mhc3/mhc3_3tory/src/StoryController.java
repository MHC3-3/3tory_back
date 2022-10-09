package com.mhc3.mhc3_3tory.src;

import com.mhc3.mhc3_3tory.config.exception.BaseException;
import com.mhc3.mhc3_3tory.config.response.BaseResponse;

import com.mhc3.mhc3_3tory.src.model.eventUser.EventUser;
import com.mhc3.mhc3_3tory.src.model.GetResTestResult;
import com.mhc3.mhc3_3tory.src.model.GetResultId;
import com.mhc3.mhc3_3tory.src.model.TemplateModel;
import com.mhc3.mhc3_3tory.src.model.eventUser.EventUserResponse;
import com.mhc3.mhc3_3tory.util.StoryAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.mhc3.mhc3_3tory.config.response.BaseResponseStatus.*;
import static com.mhc3.mhc3_3tory.util.ValidationRegex.isValidPhone;

@RestController
@RequestMapping("/api")
public class StoryController {
    private final StoryProvider storyProvider;
    private final StoryService storyService;

    @Autowired
    public StoryController(StoryProvider storyProvider, StoryService storyService) {
        this.storyProvider = storyProvider;
        this.storyService = storyService;
    }


    @GetMapping("/template")
    public BaseResponse<ArrayList<TemplateModel>> getTemplateList() {
        ArrayList<TemplateModel> result = storyProvider.getTemplateList();
        return new BaseResponse<>(result);

    }

    @GetMapping("/result")
    public BaseResponse<GetResTestResult> getTestResult(@RequestParam String code) {
        try {
            // validation : 6개의 정답
            if(code.length()!=6){
                throw new BaseException(REQUEST_ERROR);
            }
            GetResTestResult getResTestResult = storyService.getTestResult(code);
            return new BaseResponse<>(getResTestResult);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @GetMapping("/result/data")
    public BaseResponse<GetResTestResult> getResultData(@RequestParam Integer id) {
        try {
            // validation : id는 1~6
            if(id<1 && id>6){
                throw new BaseException(INVALID_PROGRAM_ID);
            }
            GetResTestResult getResTestResult = storyService.getResultData(id);
            return new BaseResponse<>(getResTestResult);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    // 답변 -> 결과 id
    @GetMapping("/result/id")
    public BaseResponse<GetResultId> getTestResultId (@RequestParam String code) {
        try {
            // validation : 6개의 정답
            if(code.length()!=6){
                throw new BaseException(REQUEST_ERROR);
            }
            StoryAlgorithm storyAlgorithm = new StoryAlgorithm();
            int programId = storyAlgorithm.calculateResult(code, 6);
            String programName = storyAlgorithm.getProgram()[programId-1].getName();
            GetResultId getResultId = new GetResultId(programId, programName);
            return new BaseResponse<>(getResultId);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    // 프로그램 카운트
    @PostMapping("/count")
    public BaseResponse<String> countProgram (@RequestParam String code, @RequestParam String env) {
        try {
            // validation : 6개의 정답
            if(code.length()!=6){
                throw new BaseException(REQUEST_ERROR);
            }
            StoryAlgorithm storyAlgorithm = new StoryAlgorithm();
            int programId = storyAlgorithm.calculateResult(code, 6);
            storyService.countProgram(programId, env);
            String programName = storyAlgorithm.getProgram()[programId-1].getName();
            String resultMessage = programName + " 카운트가 업데이트되었습니다.";
            return new BaseResponse<>(resultMessage);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }

    @PostMapping("/event")
    public BaseResponse<EventUserResponse> saveEventUser(@RequestBody EventUser eventUser, @RequestParam String env) {
        try {
            // validation 연락처
            if(!isValidPhone(eventUser.getPhoneNumber())){
                return new BaseResponse<>(INVALID_PHONE_NUMBER);
            }
            int userId = storyService.saveEventUser(eventUser, env);
            String resultMessage = "이벤트 유저 정보저장을 성공했습니다.";
            EventUserResponse eventUserResponse = new EventUserResponse(userId, resultMessage);
            return new BaseResponse<>(eventUserResponse);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }


    @GetMapping("/result/case")
    public BaseResponse<ArrayList<HashMap<String, String>>> getResultCase() {
        ArrayList<HashMap<String, String>> resultCase = storyProvider.getResultCase();
        return new BaseResponse<>(resultCase);
    }



}
