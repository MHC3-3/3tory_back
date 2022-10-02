package com.mhc3.mhc3_3tory.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Program {
    int id;
    String name;
    float score;

    Program(int id, String name){
        this.id = id;
        this.name = name;
        this.score = 0.0f;
    }

    void addScore(float weight) {
        this.score = this.score + weight;
    }

}
