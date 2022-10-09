package com.mhc3.mhc3_3tory.src;

import com.mhc3.mhc3_3tory.config.exception.BaseException;
import com.mhc3.mhc3_3tory.src.model.eventUser.EventUser;
import com.mhc3.mhc3_3tory.src.model.GetResTestResult;
import com.mhc3.mhc3_3tory.util.StoryAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StoryService {

    private final StoryDao storyDao;

    @Autowired
    public StoryService(StoryDao storyDao) {
        this.storyDao = storyDao;
    }

    public GetResTestResult getTestResult(String code) throws BaseException {
        try {
            StoryAlgorithm storyAlgorithm = new StoryAlgorithm();
            int programId = storyAlgorithm.calculateResult(code, 6);
            GetResTestResult testResult = storyDao.getTestResult(programId);
            return testResult;
        } catch (BaseException exception) {
            throw exception;
        }
    }

    public GetResTestResult getResultData(int programId) throws BaseException {
        try {
            GetResTestResult testResult = storyDao.getResultData(programId);
            return testResult;
        } catch (BaseException exception) {
            throw exception;
        }
    }
    public void countProgram(int id, String env) throws BaseException {
        try {
            storyDao.updateCount(id, env);
        } catch (BaseException exception) {
            throw exception;
        }
    }

    public int saveEventUser(EventUser eventUser, String env) throws BaseException {
        try {
            int userId = 0;
            if(env.equals("dev")) {
                userId = storyDao.saveEventUserForDev(eventUser);
            } else {
                userId = storyDao.saveEventUser(eventUser);
            }
            return userId;
        } catch (BaseException exception) {
            throw exception;
        }
    }
}
