package com.mhc3.mhc3_3tory.src;

import com.mhc3.mhc3_3tory.config.exception.BaseException;
import com.mhc3.mhc3_3tory.config.response.BaseResponse;

import com.mhc3.mhc3_3tory.src.model.GetResTestResult;
import com.mhc3.mhc3_3tory.src.model.TemplateModel;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static com.mhc3.mhc3_3tory.config.response.BaseResponseStatus.REQUEST_ERROR;

@RestController
@RequestMapping("/api")
public class StoryController {
    private final StoryProvider storyProvider;
    private final StoryService storyService;

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


}
