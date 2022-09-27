package com.mhc3.mhc3_3tory.src.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class templateVersion1 implements templateInterface{
    String temp;
    int id;
    int nextId;
    String backgroundImg;
    String color;
    String who;
    String text;
    Boolean hidden;
    Boolean isLast;
}
