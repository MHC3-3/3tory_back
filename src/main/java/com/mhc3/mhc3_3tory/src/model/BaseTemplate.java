package com.mhc3.mhc3_3tory.src.model;

import com.mhc3.mhc3_3tory.config.S3.S3Service;
import lombok.Getter;

import java.util.List;
import java.util.Arrays;

@Getter
public enum BaseTemplate{

    Page1(
            "story",
            1,
            2,
            "brown",
            null,
            "오류동 버들마을에는 '토리'라는 깜찍한 주민이 살고 있답니다.",
            true,
            false
    ),
    Page2(
            "story",
            2,
            3,
            "brown",
            null,
            "오늘 하루 '토리'가 되어 버들마을의 사랑방을 구경해보세요",
            true,
            false
    ),
    Page3(
            "story",
            3,
            4,
            "gray",
            "토리의 집",
            "토리가 침대에 누워 자고 있다.",
            true,
            false
    ),
    Page4(
            "question",
            4,
            5,
            "Q1.",
            "기상시간이 되었는지 알람소리가 들린다. 토리를 깨우는 알림음은?",
            Arrays.asList("흥겨운 재즈나 클래식","시끄러운 기본 알림음","좋아하는 아이돌 노래")
    ),
    Page5(
            "story",
            5,
            6,
            "gray",
            "토리의 집",
            "토리는 알람을 끄고 기상했다.",
            true,
            false
    ),
    Page6(
            "question",
            6,
            7,
            "Q2.",
            "아침에 일어나서 가장 먼저 무엇을 할까?",
            Arrays.asList("모닝 커피는 국룰! 커피를 마신다","부지런한 토리, 아침 운동을 간다","여유롭게 침대에서 뒹굴거린다")
    );



    private String temp;
    private int id;
    private int nextId;

    private String color;
    private String who;
    private String text;
    private Boolean hidden;
    private Boolean isLast;

    private String number;
    private String question;
//    private HashMap<Integer,String> answer = new HashMap<>();
    private List<String> answer;
    private BaseTemplate( String temp, int id, int nextId, String color, String who, String text, Boolean hidden, Boolean isLast) {
        this.temp = temp;
        this.id = id;
        this.nextId = nextId;
        this.color = color;
        this.who = who;
        this.text = text;
        this.hidden = hidden;
        this.isLast = isLast;

    }
    private BaseTemplate(String temp, int id, int nextId, String number, String question, List<String> answer) {
        this.temp = temp;
        this.id = id;
        this.nextId = nextId;
        this.number = number;
        this.question = question;
        this.answer = answer;
    }
}
