package com.mhc3.mhc3_3tory.src;

import com.mhc3.mhc3_3tory.config.exception.BaseException;
import com.mhc3.mhc3_3tory.src.model.GetResTestResult;
import com.mhc3.mhc3_3tory.util.StoryAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.mhc3.mhc3_3tory.config.response.BaseResponseStatus.DATABASE_ERROR;

@Service
public class StoryService {

    private final StoryProvider storyProvider;
    private final StoryDao storyDao;
    private static StoryAlgorithm storyAlgorithm = null;

    @Autowired
    public StoryService(StoryProvider storyProvider, StoryDao storyDao, StoryAlgorithm storyAlgorithm) {
        this.storyProvider = storyProvider;
        this.storyDao = storyDao;
        this.storyAlgorithm = storyAlgorithm;
    }

    public GetResTestResult getTestResult(String code) throws BaseException {
        try {
            int programId = storyAlgorithm.printQuestionResult(code, 6);
            GetResTestResult getResTestResult = storyDao.getTestResult(programId);
            return getResTestResult;
        } catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }


}
