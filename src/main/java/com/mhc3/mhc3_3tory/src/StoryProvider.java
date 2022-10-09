package com.mhc3.mhc3_3tory.src;

import com.mhc3.mhc3_3tory.config.S3.S3Service;
import com.mhc3.mhc3_3tory.config.exception.BaseException;
import com.mhc3.mhc3_3tory.src.model.BaseTemplate;
import com.mhc3.mhc3_3tory.src.model.TemplateModel;
import com.mhc3.mhc3_3tory.util.StoryAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class StoryProvider {
    private final S3Service s3Service;

    @Autowired
    StoryProvider(S3Service s3Service) {
        this.s3Service = s3Service;
    }

    ArrayList<TemplateModel> getTemplateList() {

        ArrayList<TemplateModel> templateList = new ArrayList<>();
        for (var baseTemplate : BaseTemplate.values()) {
            String backGroundImg;
            if(baseTemplate.getId() == 10) {
                backGroundImg = s3Service.getThumbnailPath("pageImg/loadingTory.gif");
            } else {
                backGroundImg = s3Service.getThumbnailPath("pageImg/page" + baseTemplate.getId() + ".png");
            }
            TemplateModel template = new TemplateModel(
                    baseTemplate.getTemp(),
                    baseTemplate.getId(),
                    baseTemplate.getNextId(),
                    backGroundImg,
                    baseTemplate.getColor(),
                    baseTemplate.getWho(),
                    baseTemplate.getText(),
                    baseTemplate.getHidden(),
                    baseTemplate.getIsLast(),
                    baseTemplate.getNumber(),
                    baseTemplate.getQuestion(),
                    baseTemplate.getAnswer()
            );
            // List에 삽입
            templateList.add(template);
        }
        return templateList;
    }

    ArrayList<HashMap<String, String>> getResultCase() {
        StoryAlgorithm storyAlgorithm = new StoryAlgorithm();
        int[] answerCnt = { 3, 3, 4, 2, 3, 2 };
        storyAlgorithm.numberOfCases("", 6,6, answerCnt);
        ArrayList<String> resultCase = storyAlgorithm.getResultCase();
        ArrayList<HashMap<String, String>> resultCaseMap = new ArrayList<>();
        for(String codeValue : resultCase){
            HashMap<String, String> codeMap= new HashMap<>();
            codeMap.put("code", codeValue);
            resultCaseMap.add(codeMap);
        }
        return resultCaseMap;
    }
}
