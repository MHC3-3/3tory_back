package com.mhc3.mhc3_3tory.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Program {
    float score;
    int count;

    Program(){
        this.score = 0.0f;
        this.count = 0;
    }

    void addScore(float weight) {
        this.score = this.score + weight;
    }
}
