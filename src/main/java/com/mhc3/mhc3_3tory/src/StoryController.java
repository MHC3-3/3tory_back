package com.mhc3.mhc3_3tory.src;

import com.mhc3.mhc3_3tory.config.response.BaseResponse;

import com.mhc3.mhc3_3tory.src.model.templateInterface;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api")
public class StoryController {
    private final StoryProvider storyProvider;
    private final StoryService storyService;

    StoryController(StoryProvider storyProvider, StoryService storyService) {
        this.storyProvider = storyProvider;
        this.storyService = storyService;
    }


    @GetMapping("/template")
    BaseResponse<ArrayList<templateInterface>> getTemplateList() {
        ArrayList<templateInterface> result = storyProvider.getTemplateList();
        return new BaseResponse<>(result);

    }


}
