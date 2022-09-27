package com.mhc3.mhc3_3tory.src;

import com.mhc3.mhc3_3tory.src.model.templateInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StoryService {

    private final StoryProvider storyProvider;
    private final StoryDao storyDao;

    @Autowired
    StoryService(StoryProvider storyProvider, StoryDao storyDao) {
        this.storyProvider = storyProvider;
        this.storyDao = storyDao;
    }


}
