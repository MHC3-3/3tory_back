package com.mhc3.mhc3_3tory.util;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
@Getter
public class StoryAlgorithm {
    // 프로그램 점수
    float barista = 0;
    float nanta = 0;
    float latin = 0;
    float guitar = 0;
    float dance = 0;
    float popArt = 0;



    // 경우 순번
    int resultNumber = 0;

    // 프로그램별 채택 수
    int baristaCnt = 0;
    int nantaCnt = 0;
    int latinCnt = 0;
    int guitarCnt = 0;
    int danceCnt = 0;
    int popArtCnt = 0;


    // 질문별 가중치
    float Q1 = 1.2f;
    float Q2 = 1.4f;
    float Q3 = 1.7f;
    float Q4 = 4.0f;
    float Q5 = 2.0f;
    float Q6 = 3.0f;

    // 모든 프로그램 점수 초기화
    void initScores() {
        this.barista = 0;
        this.nanta = 0;
        this.latin = 0;
        this.guitar = 0;
        this.dance = 0;
        this.popArt = 0;

    }

    // 질문별 점수 계산
    void qusetion(int questionNumber, String answer) {

        // Q1 답변3개
        if (questionNumber == 1) {
            char question1Answer = answer.charAt(questionNumber - 1);
            // validation : 답변으로 올 수 있는 숫자는 1,2,3,4뿐 이외가 입력됐을 때 에러 처리
            switch (question1Answer) {
                case '1':
                    guitar = guitar + Q1;
                    latin = latin + Q1;
                    break;
                case '2':
                    nanta = nanta + Q1;
                    barista = barista + Q1;
                    break;
                case '3':
                    dance = dance + Q1;
                    popArt = popArt + Q1;
                    break;
                default:
                    System.out.println("Invalid Answer at Q1");
                    break;
            }
        }

        // Q2 답변3개
        if (questionNumber == 2) {
            char question2Answer = answer.charAt(questionNumber - 1);
            // validation : 답변으로 올 수 있는 숫자는 1,2,3뿐 이외가 입력됐을 때 에러 처리
            switch (question2Answer) {
                case '1':
                    barista = barista + Q2;
                    dance = dance + Q2;
                    break;
                case '2':
                    latin = latin + Q2;
                    nanta = nanta + Q2;
                    break;
                case '3':
                    guitar = guitar + Q2;
                    popArt = popArt + Q2;
                    break;
                default:
                    System.out.println("Invalid Answer at Q2");
                    break;
            }
        }

        // Q3 답변4개
        if (questionNumber == 3) {
            char question3Answer = answer.charAt(questionNumber - 1);
            // validation : 답변으로 올 수 있는 숫자는 1,2,3,4뿐 이외가 입력됐을 때 에러 처리
            switch (question3Answer) {
                case '1':
                    dance = dance + Q3;
                    popArt = popArt + Q3;
                    break;
                case '2':
                    barista = barista + Q3;
                    break;
                case '3':
                    latin = latin + Q3;
                    break;
                case '4':
                    nanta = nanta + Q3;
                    guitar = guitar + Q3;
                    break;
                default:
                    System.out.println("Invalid Answer at Q3");
                    break;
            }
        }
        // Q4 답변2개
        if (questionNumber == 4) {
            char question4Answer = answer.charAt(questionNumber - 1);
            // validation : 답변으로 올 수 있는 숫자는 1,2,3,4뿐 이외가 입력됐을 때 에러 처리
            switch (question4Answer) {
                case '1':
                    latin = latin + Q4;
                    dance = dance + Q4;
                    nanta = nanta + Q4;
                    break;
                case '2':
                    guitar = guitar + Q4;

                    popArt = popArt + Q4;
                    barista = barista + Q4;
                    break;
                default:
                    System.out.println("Invalid Answer at Q4");
                    break;
            }
        }
        // Q5 답변3개
        if (questionNumber == 5) {
            char question5Answer = answer.charAt(questionNumber - 1);
            // validation : 답변으로 올 수 있는 숫자는 1,2,3,4,5,6뿐 이외가 입력됐을 때 에러 처리
            switch (question5Answer) {
                case '1':
                    nanta = nanta + Q5;
                    latin = latin + Q5;
                    break;
                case '2':
                    dance = dance + Q5;
                    guitar = guitar + Q5;
                    break;
                case '3':
                    popArt = popArt + Q5;
                    barista = barista + Q5;
                    break;
                default:
                    System.out.println("Invalid Answer at Q5");
                    break;
            }
        }
        // Q6 답변2개
        if (questionNumber == 6) {
            char question6Answer = answer.charAt(questionNumber - 1);
            // validation : 답변으로 올 수 있는 숫자는 1,2,3,4,5,6뿐 이외가 입력됐을 때 에러 처리
            switch (question6Answer) {
                case '1':
                    barista = barista + Q6;
                    guitar = guitar + Q6;
                    nanta = nanta + Q6;
                    break;
                case '2':
                    popArt = popArt + Q6;
                    latin = latin + Q6;
                    dance = dance + Q6;
                    break;
                default:
                    System.out.println("Invalid Answer at Q6");
                    break;
            }
        }
    }

    public int printQuestionResult(String answer, int questionCnt) {
        initScores();
        for (int i = 1; i <= questionCnt; i++) {
            qusetion(i, answer);
        }
        double[] scores = { barista, nanta, latin, guitar, dance, popArt };
        return whatIsBestProgram(scores);
    }

    int whatIsBestProgram(double[] scores) {

        int[] rankings = new int[scores.length];
        for (int i = 0; i < rankings.length; i++) {
            rankings[i] = 1;
        }

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores.length; j++) {
                if (scores[i] < scores[j]) {
                    rankings[i]++;
                }
            }
        }

        int programId=0;
        for (int i = 0; i < rankings.length; i++) {
            if (rankings[i] == 1) {
//                System.out.print(programWithId(i + 1) + " ");
                programId = i+1;
                break;
            }
        }
        return programId;
    }

    String programWithId(int id) {
        switch (id) {
            case 1:
                baristaCnt++;
                return "barista";
            case 2:
                nantaCnt++;
                return "nanta";
            case 3:
                latinCnt++;
                return "latin";
            case 4:
                guitarCnt++;
                return "guitar";
            case 5:
                danceCnt++;
                return "dance";
            case 6:
                popArtCnt++;
                return "popArt";
            default:
                return "NoProgram";
        }

    }

    void printProgramCnt(int id) {
        switch (id) {
            case 1:
                System.out.println("barista : " + baristaCnt);
                break;
            case 2:
                System.out.println("nanta : " + nantaCnt);
                break;
            case 3:
                System.out.println("latin : " + latinCnt);
                break;
            case 4:
                System.out.println("guitar : " + guitarCnt);
                break;
            case 5:
                System.out.println("dance : " + danceCnt);
                break;
            case 6:
                System.out.println("popArt : " + popArtCnt);
                break;
            default:
                System.out.println("No Program");
                break;
        }

    }

    void numberOfCases(String before, int end, int questionCnt, int[] answerCnt) {
        if (end == 0) {
            // 각 경우의 수 출력될 때마다 질문에 대한 점수결과값도 출력
            String result = before;
            resultNumber++;
            System.out.print(String.format("%03d", resultNumber) + " | " + result + "  |  ");
            printQuestionResult(result, questionCnt);
            return;
        }
        end--;

        for (int i = 1; i <= answerCnt[questionCnt - end - 1]; i++) {
            // 현재 답변이 i일 때
            if (before.length() < questionCnt - end) {
                before = before + i;
            } else {
                StringBuilder sb = new StringBuilder(before);
                char digit = Character.forDigit(i, 10);
                sb.setCharAt(questionCnt - end - 1, digit);
                before = sb.toString();
            }
            numberOfCases(before, end, questionCnt, answerCnt);
        }

    }
}
