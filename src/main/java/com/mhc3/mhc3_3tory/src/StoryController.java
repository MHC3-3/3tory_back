package com.mhc3.mhc3_3tory.src;

import com.mhc3.mhc3_3tory.config.exception.BaseException;
import com.mhc3.mhc3_3tory.config.response.BaseResponse;

import com.mhc3.mhc3_3tory.src.model.GetResTestResult;
import com.mhc3.mhc3_3tory.src.model.TemplateInterface;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    public BaseResponse<ArrayList<TemplateInterface>> getTemplateList() {
        ArrayList<TemplateInterface> result = storyProvider.getTemplateList();
        return new BaseResponse<>(result);

    }

    @GetMapping("/result")
    public BaseResponse<GetResTestResult> getTestResult(@RequestParam String code) {
        try {
            GetResTestResult getResTestResult = storyService.getTestResult(code);
            return new BaseResponse<>(getResTestResult);
        } catch (BaseException exception){
            return new BaseResponse<>(exception.getStatus());
        }
    }


}
