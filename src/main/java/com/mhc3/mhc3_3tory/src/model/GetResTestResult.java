package com.mhc3.mhc3_3tory.src.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetResTestResult {
    int id;
    String name;
    String title;
    String description;
    int count;
    String resultToryImg;
    PartnerModel partnerModel;
}
