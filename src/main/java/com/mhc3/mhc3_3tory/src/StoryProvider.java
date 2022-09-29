package com.mhc3.mhc3_3tory.src;

import com.mhc3.mhc3_3tory.config.S3.S3Service;
import com.mhc3.mhc3_3tory.src.model.BaseTemplate;
import com.mhc3.mhc3_3tory.src.model.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
            String backGroundImg = null;
            if(baseTemplate.isHaveImg() == true) {
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
}
