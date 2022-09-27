package com.mhc3.mhc3_3tory.src;

import com.mhc3.mhc3_3tory.config.S3.S3Config;
import com.mhc3.mhc3_3tory.config.S3.S3Service;
import com.mhc3.mhc3_3tory.src.model.BaseTemplate;
import com.mhc3.mhc3_3tory.src.model.templateInterface;
import com.mhc3.mhc3_3tory.src.model.templateVersion1;
import com.mhc3.mhc3_3tory.src.model.templateVersion2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StoryProvider {
    private final StoryDao storyDao;
    private final S3Service s3Service;

    @Autowired
    StoryProvider(StoryDao storyDao, S3Service s3Service) {
        this.storyDao = storyDao;
        this.s3Service = s3Service;
    }

    ArrayList<templateInterface> getTemplateList() {
        ArrayList<templateInterface> templateList = new ArrayList<>();
        for (var baseTemplate : BaseTemplate.values()) {
            String backGroundImg = s3Service.getThumbnailPath("pageImg/page"+baseTemplate.getId()+".png");
            if (baseTemplate.getTemp().equals("story")) {
                templateInterface template = new templateVersion1(
                        baseTemplate.getTemp(),
                        baseTemplate.getId(),
                        baseTemplate.getNextId(),
                        backGroundImg,
                        baseTemplate.getColor(),
                        baseTemplate.getWho(),
                        baseTemplate.getText(),
                        baseTemplate.getHidden(),
                        baseTemplate.getIsLast()
                );
                // List에 삽입
                templateList.add(template);
            } else if (baseTemplate.getTemp().equals("question")) {
                templateInterface template = new templateVersion2(
                        baseTemplate.getTemp(),
                        baseTemplate.getId(),
                        baseTemplate.getNextId(),
                        backGroundImg,
                        baseTemplate.getNumber(),
                        baseTemplate.getQuestion(),
                        baseTemplate.getAnswer()
                );
                // List에 삽입
                templateList.add(template);
            }
        }
        return templateList;
    }
}
