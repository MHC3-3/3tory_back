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
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page2(
            "story",
            2,
            3,
            "brown",
            null,
            "하루동안 ’토리’가 되어 살아보기",
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page3(
            "story",
            3,
            4,
            "gray",
            "#1 토리의 집",
            "토리가 침대에 누워 자고 있다.",
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page4(
            "question",
            4,
            5,
            null,
            null,
            null,
            false,
            false,
            "Q1.",
            "기상시간이 되었는지 알람소리가 들린다. 토리를 깨우는 알림음은?",
            Arrays.asList(
                    "흥겨운 재즈나 클래식",
                    "시끄러운 기본 알림음",
                    "좋아하는 아이돌 노래"
            ),
            true
    ),
    Page5(
            "story",
            5,
            6,
            "gray",
            null,
            "토리는 알람을 끄고 기상했다.",
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page6(
            "question",
            6,
            7,
            null,
            null,
            null,
            false,
            false,
            "Q2.",
            "아침에 일어나서 가장 먼저 무엇을 할까?",
            Arrays.asList(
                    "모닝 커피는 국룰! 커피를 마신다",
                    "부지런한 토리, 아침 운동을 간다",
                    "여유롭게 침대에서 뒹굴거린다"
            ),
            true
    ),
    Page7(
            "story",
            7,
            8,
            "gray",
            null,
            "오늘은 담지랑 스토리공감 카페에서 만나기로 했다. 생각보다 빨리 준비해버린 토리",
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page8(
            "question",
            8,
            9,
            null,
            null,
            null,
            false,
            false,
            "Q3.",
            "준비를 빨리 마쳐 약속시간까지 1시간이 남는다. 심심해서 유튜브에 들어간 토리에게 뜬 알고리즘은?",
            Arrays.asList(
                    "청량함이 가득한 아이돌 직캠",
                    "유튜버의 리얼한 홈카페 브이로그",
                    "짬내서 할 수 있는 간단 스트레칭",
                    "예능 하이라이트 모음 영상"
            ),
            true
    ),
    Page9(
            "story",
            9,
            10,
            "gray",
            null,
            "약속시간이 거의 다 되었다. 자 이제 약속 장소로 출발해보자.",
            false,
            false,
            null,
            null,
            null,
            false
    ),
    // 10 : 열심히 가는 중
    Page10(
            "story",
            10,
            11,
            null,
            null,
            null,
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page11(
            "story",
            11,
            12,
            "gray",
            "#2 스토리 공감 카페",
            "카페 앞에서 담지를 만났다. 카페로 들어간다.",
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page12(
            "story",
            12,
            13,
            "brown",
            "토리",
            "저희 아메리카노랑 수제 샌드위치 2개 주세요!",
            true,
            false,
            null,
            null,
            null,
            true
    ),
    Page13(
            "story",
            13,
            14,
            null,
            null,
            null,
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page14(
            "story",
            14,
            15,
            "gray",
            null,
            "수다를 떨기 시작한 담지와 토리 카페에서 신나는 댄스곡이 흘러나온다.",
            false,
            false,
            null,
            null,
            null,
            false
    ),
    Page15(
            "story",
            15,
            16,
            "orange",
            "담지",
            "이 노래 완전 신난다. 너도 춤추는 거 좋아해?",
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page16(
            "question",
            16,
            17,
            null,
            null,
            null,
            false,
            false,
            "Q4.",
            "평소의 나는?",
            Arrays.asList(
                    "나 춤추는 거 완전 좋아하지~",
                    "아니 나는 춤추는 거 안 좋아해..."
            ),
            true
    ),
    Page17(
            "story",
            17,
            18,
            "orange",
            "담지",
            "그렇구나! 나는 춤을 추면 스트레스가 해소되더라고.토리 너는 어떻게 스트레스를 풀어?",
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page18(
            "question",
            18,
            19,
            null,
            null,
            null,
            false,
            false,
            "Q5.",
            "평소 스트레스를 해소하는 방법은?",
            Arrays.asList(
                    "활동적으로 시간을 보내면서 잡생각을 떨쳐내는 것 같아",
                    "신나는 노래를 들으면 기분이 좋아져",
                    "집에서 혼자만의 시간을 가지면서 에너지를 충전해"
            ),
            true
    ),
    Page19(
            "story",
            19,
            20,
            "gray",
            null,
            "토리와 담지가 이야기를 나누던 중 아름답게 치장을 한 버드리 아주머니가 지나간다.",
            false,
            false,
            null,
            null,
            null,
            false
    ),
    Page20(
            "story",
            20,
            21,
            "green",
            "버드리",
            "토리야 담지야 어서오렴~^^",
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page21(
            "story",
            21,
            22,
            "orange",
            "담지",
            "버드리 아주머니 오늘 너무 아름다우세요!",
            false,
            false,
            null,
            null,
            null,
            true
    )
    ,Page22(
            "story",
            22,
            23,
            "green",
            "버드리",
            "요즘 여기 2층에서 라틴 댄스를 가르치고 있단다. 너희도 프로그램 체험 해보지 않을래?",
            false,
            false,
            null,
            null,
            null,
            true
    ),
    // 23 : 계단 올라가는 이미지
    Page23(
            "story",
            23,
            24,
            "gray",
            "#3 문화센터 연결 계단",
            "버드리아주머니의 소개로 함께 프로그램을 체험할 수 있는 문화센터에 가보기로 했다.",
            false,
            false,
            null,
            null,
            null,
            true
    ),
    // 24 : 2층 구경하는 이미지
    Page24(
            "story",
            24,
            25,
            null,
            null,
            null,
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page25(
            "story",
            25,
            26,
            "orange",
            "담지",
            "프로그램이 되게 많네. 토리야 너는 어떤 걸 해 보고 싶어?",
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page26(
            "story",
            26,
            27,
            null,
            null,
            null,
            false,
            false,
            "Q6.",
            "내가 토리라면?",
            Arrays.asList(
                    "무언가를 배우는 게 좋아. 성취감 뿜뿜!",
                    "이것저것 복잡한 건 싫어. 자유롭게 표현하고 즐기는 게 좋아~"
            ),
            true
    ),
    // 27 : 계단을 내려오는 토리랑 담지
    Page27(
            "story",
            27,
            28,
            null,
            null,
            null,
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page28(
            "story",
            28,
            29,
            "gray",
            "#4 하루의 끝",
            "생활문화지원센터를 둘러보고 오니 어느새 담지랑 헤어질 시간이 왔다.",
            false,
            false,
            null,
            null,
            null,
            false
    ),
    Page29(
            "story",
            29,
            30,
            "orange",
            "담지",
            "토리야 오늘 재밌었어 조심히 가~",
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page30(
            "story",
            30,
            31,
            "brown",
            "토리",
            "담지 너도 잘가!",
            false,
            false,
            null,
            null,
            null,
            true
    ),
    Page31(
            "story",
            31,
            0,
            "gray",
            null,
            "보람찬 토리의 하루가 끝이 났습니다.",
            false,
            true,
            null,
            null,
            null,
            false
    );

    /**
     * temp: string;
     *   id: number;
     *   nextId: number;
     *   color?: string;
     *   who?: string;
     *   text?: string;
     *   hidden?: boolean;
     *   isLast?: boolean;
     *   number?: string;
     *   question?: string;
     *   answer?: string[];
     *   backgroundImg: String;
     */

    private final String temp;
    private final int id;
    private final int nextId;
    private final String color;
    private final String who;
    private final String text;
    private final Boolean hidden;
    private final Boolean isLast;
    private final String number;
    private final String question;
    private final List<String> answer;
    private boolean haveImg;

    private BaseTemplate(String temp, int id, int nextId, String color, String who, String text, Boolean hidden, Boolean isLast, String number, String question, List<String> answer, boolean haveImg) {
        this.temp = temp;
        this.id = id;
        this.nextId = nextId;
        this.color = color;
        this.who = who;
        this.text = text;
        this.hidden = hidden;
        this.isLast = isLast;
        this.number = number;
        this.question = question;
        this.answer = answer;
        this.haveImg = haveImg;
    }

}
