package com.mhc3.mhc3_3tory.src.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class templateVersion2 implements templateInterface{
    String temp;
    int id;
    int nextId;
    String backgroundImg;

    String number;
    String question;
    List<String> answer;
}
