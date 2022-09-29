package com.mhc3.mhc3_3tory.util;

import com.mhc3.mhc3_3tory.config.exception.BaseException;
import lombok.Getter;
import org.springframework.stereotype.Service;

import static com.mhc3.mhc3_3tory.config.response.BaseResponseStatus.*;

@Service
@Getter
public class StoryAlgorithm {
    // 프로그램 점수
    Program barista = new Program();
    Program nanta = new Program();
    Program latin = new Program();
    Program guitar = new Program();
    Program dance = new Program();
    Program popArt = new Program();

    // 질문별 가중치
    float[] weight = {1.2f,1.4f,1.7f,4.0f,2.0f,3.0f};

    public int calculateResult(String answerCode, int questionCnt) throws BaseException {
        try {
            for (int i = 1; i <= questionCnt; i++) {
                qusetion(i, answerCode.charAt(i-1));
            }
            float[] scores = {barista.getScore(), nanta.getScore(), latin.getScore(), guitar.getScore(), dance.getScore(), popArt.getScore() };
            return whatIsBestProgram(scores);
        } catch (BaseException exception) {
            throw exception;
        }

    }


    // 질문별 점수 계산
    void qusetion(int questionNumber, char answer) throws BaseException {
        switch (questionNumber) {
            case 1:
                // Q1 답변3개
                switch (answer) {
                    case '1':
                        guitar.addScore(weight[questionNumber-1]);
                        latin.addScore(weight[questionNumber-1]);
                        break;
                    case '2':
                        nanta.addScore(weight[questionNumber-1]);
                        barista.addScore(weight[questionNumber-1]);
                        break;
                    case '3':
                        dance.addScore(weight[questionNumber-1]);
                        popArt.addScore(weight[questionNumber-1]);
                        break;
                    default:
                        System.out.println("Q1");
                        throw new BaseException(INVALID_ANSWER_Q1);
                }
                break;
            case 2:
                // Q2 답변3개
                // validation : 답변으로 올 수 있는 숫자는 1,2,3뿐 이외가 입력됐을 때 에러 처리
                switch (answer) {
                    case '1':
                        barista.addScore(weight[questionNumber-1]);
                        dance.addScore(weight[questionNumber-1]);
                        break;
                    case '2':
                        latin.addScore(weight[questionNumber-1]);
                        nanta.addScore(weight[questionNumber-1]);
                        break;
                    case '3':
                        guitar.addScore(weight[questionNumber-1]);
                        popArt.addScore(weight[questionNumber-1]);
                        break;
                    default:
                        System.out.println("Q2");
                        throw new BaseException(INVALID_ANSWER_Q2);
                }
            case 3:
                // Q3 답변4개
                // validation : 답변으로 올 수 있는 숫자는 1,2,3,4뿐 이외가 입력됐을 때 에러 처리
                switch (answer) {
                    case '1':
                        dance.addScore(weight[questionNumber-1]);
                        popArt.addScore(weight[questionNumber-1]);
                        break;
                    case '2':
                        barista.addScore(weight[questionNumber-1]);
                        break;
                    case '3':
                        latin.addScore(weight[questionNumber-1]);
                        break;
                    case '4':
                        nanta.addScore(weight[questionNumber-1]);
                        guitar.addScore(weight[questionNumber-1]);
                        break;
                    default:
                        throw new BaseException(INVALID_ANSWER_Q3);
                }
                break;
            case 4:
                // Q4 답변2개
                // validation : 답변으로 올 수 있는 숫자는 1,2,3,4뿐 이외가 입력됐을 때 에러 처리
                switch (answer) {
                    case '1':
                        latin.addScore(weight[questionNumber-1]);
                        dance.addScore(weight[questionNumber-1]);
                        nanta.addScore(weight[questionNumber-1]);
                        break;
                    case '2':
                        guitar.addScore(weight[questionNumber-1]);

                        popArt.addScore(weight[questionNumber-1]);
                        barista.addScore(weight[questionNumber-1]);
                        break;
                    default:
                        throw new BaseException(INVALID_ANSWER_Q4);
                }
                break;
            case 5:
                // Q5 답변3개
                // validation : 답변으로 올 수 있는 숫자는 1,2,3,4,5,6뿐 이외가 입력됐을 때 에러 처리
                switch (answer) {
                    case '1':
                        nanta.addScore(weight[questionNumber-1]);
                        latin.addScore(weight[questionNumber-1]);
                        break;
                    case '2':
                        dance.addScore(weight[questionNumber-1]);
                        guitar.addScore(weight[questionNumber-1]);
                        break;
                    case '3':
                        popArt.addScore(weight[questionNumber-1]);
                        barista.addScore(weight[questionNumber-1]);
                        break;
                    default:
                        throw new BaseException(INVALID_ANSWER_Q5);
                }
                break;
            case 6:
                // Q6 답변2개
                // validation : 답변으로 올 수 있는 숫자는 1,2,3,4,5,6뿐 이외가 입력됐을 때 에러 처리
                switch (answer) {
                    case '1':
                        barista.addScore(weight[questionNumber-1]);
                        guitar.addScore(weight[questionNumber-1]);
                        nanta.addScore(weight[questionNumber-1]);
                        break;
                    case '2':
                        popArt.addScore(weight[questionNumber-1]);
                        latin.addScore(weight[questionNumber-1]);
                        dance.addScore(weight[questionNumber-1]);
                        break;
                    default:
                        throw new BaseException(INVALID_ANSWER_Q6);
                }
                break;
            default:
                throw new BaseException(INVALID_QUESTION_NUMBER);
        }
    }

    int whatIsBestProgram(float[] scores) {

        // 스코어 랭킹 초기화
        int[] rankings = new int[scores.length];
        for (int i = 0; i < rankings.length; i++) {
            rankings[i] = 1;
        }
        // 랭킹 계산
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores.length; j++) {
                if (scores[i] < scores[j]) {
                    rankings[i]++;
                }
            }
        }
        // 1위인 프로그램 아이디, (동점인 경우 먼저 오는 프로그램으로)-> 2가지 경우:라틴,댄스
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

}
