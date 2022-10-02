package com.mhc3.mhc3_3tory.src.model;

import com.mhc3.mhc3_3tory.config.S3.S3Service;
import lombok.Getter;

import java.util.List;
import java.util.Arrays;

@Getter
public enum BaseTemplate{

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
            null
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
            "기상시간이 되었는지 알람소리가 들린다.\n토리를 깨우는 알림음은?",
            Arrays.asList(
                    "흥겨운 재즈나 클래식",
                    "시끄러운 기본 알림음",
                    "좋아하는 아이돌 노래"
            )
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
            null
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
            )
    ),
    Page7(
            "story",
            7,
            8,
            "gray",
            null,
            "오늘은 담지랑 스토리공감 카페에서 만나기로 했다.\n생각보다 빨리 준비해버린 토리",
            false,
            false,
            null,
            null,
            null
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
            "준비를 빨리 마쳐 약속시간까지 1시간이 남는다.\n심심해서 유튜브에 들어간 토리에게 뜬 알고리즘은?",
            Arrays.asList(
                    "청량함이 가득한 아이돌 직캠",
                    "유튜버의 리얼한 홈카페 브이로그",
                    "짬내서 할 수 있는 간단 스트레칭",
                    "예능 하이라이트 모음 영상"
            )
    ),
    Page9(
            "story",
            9,
            10,
            "gray",
            null,
            "약속시간이 거의 다 되었다.\n자 이제 약속 장소로 출발해보자.",
            false,
            false,
            null,
            null,
            null
    ),
    // 10 : 열심히 가는 중
    Page10(
            "loading",
            10,
            11,
            null,
            null,
            null,
            false,
            false,
            null,
            null,
            null
    ),
    Page11(
            "story",
            11,
            12,
            "gray",
            "#2 스토리 공감 카페",
            "카페 앞에서 담지를 만났다.\n카페로 들어간다.",
            false,
            false,
            null,
            null,
            null
    ),
    Page12(
            "story",
            12,
            13,
            "brown",
            "토리",
            "저희 아메리카노랑 요거트 주세요!",
            true,
            false,
            null,
            null,
            null
    ),
    Page13(
            "story",
            13,
            14,
            "gray",
            null,
            "수다를 떨기 시작한 담지와 토리\n카페에서 신나는 댄스곡이 흘러나온다.",
            false,
            false,
            null,
            null,
            null
    ),
    Page14(
            "story",
            14,
            15,
            "orange",
            "담지",
            "이 노래 완전 신난다. 너도 춤추는 거 좋아해?",
            false,
            false,
            null,
            null,
            null
    ),
    Page15(
            "question",
            15,
            16,
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
            )
    ),
    Page16(
            "story",
            16,
            17,
            "orange",
            "담지",
            "그렇구나! 나는 춤을 추면 스트레스가 해소되더라고.\n토리 너는 어떻게 스트레스를 풀어?",
            false,
            false,
            null,
            null,
            null
    ),
    Page17(
            "question",
            17,
            18,
            null,
            null,
            null,
            false,
            false,
            "Q5.",
            "평소 스트레스를 해소하는 방법은?",
            Arrays.asList(
                    "활동적으로 시간을 보내면서\n잡생각을 떨쳐내는 것 같아",
                    "신나는 노래를 들으면 기분이 좋아져",
                    "집에서 혼자만의 시간을 가지면서\n에너지를 충전해"
            )
    ),
    Page18(
            "story",
            18,
            19,
            "gray",
            null,
            "토리와 담지가 이야기를 나누던 중\n아름답게 치장을 한 버드리 아주머니가 지나간다.",
            false,
            false,
            null,
            null,
            null
    ),
    Page19(
            "story",
            19,
            20,
            "green",
            "버드리",
            "토리야 담지야 어서오렴~^^",
            false,
            false,
            null,
            null,
            null
    ),
    Page20(
            "story",
            20,
            21,
            "orange",
            "담지",
            "버드리 아주머니 오늘 너무 아름다우세요!",
            false,
            false,
            null,
            null,
            null
    ),
    Page21(
            "story",
            21,
            22,
            "green",
            "버드리",
            "요즘 여기 2층에서 라틴 댄스를 가르치고 있단다.\n너희도 프로그램 체험 해보지 않을래?",
            false,
            false,
            null,
            null,
            null
    ),
    // 22 : 계단 올라가는 이미지
    Page22(
            "story",
            22,
            23,
            "gray",
            "#3 문화센터 연결 계단",
            "버드리아주머니의 소개로 함께 프로그램을\n체험할 수 있는 문화센터에 가보기로 했다.",
            false,
            false,
            null,
            null,
            null
    ),
    // 23 : 2층 구경하는 이미지
    Page23(
            "story",
            23,
            24,
            "gray",
            "#4 2층 문화센터 공간",
            "문화센터에 올라온 토리와 담지.\n토리의 신나는 뒷모습이 인상 깊다.",
            false,
            false,
            null,
            null,
            null
    ),
    Page24(
            "story",
            24,
            25,
            "orange",
            "담지",
            "프로그램이 되게 많네.\n토리야 너는 어떤 걸 해 보고 싶어?",
            false,
            false,
            null,
            null,
            null
    ),
    Page25(
            "story",
            25,
            26,
            null,
            null,
            null,
            false,
            false,
            "Q6.",
            "내가 토리라면?",
            Arrays.asList(
                    "무언가를 배우는 게 좋아. 성취감 뿜뿜!",
                    "이것저것 복잡한 건 싫어.\n자유롭게 표현하고 즐기는 게 좋아~"
            )
    ),
    // 26 : 계단을 내려오는 토리랑 담지
    Page26(
            "story",
            26,
            27,
            "gray",
            null,
            "계단을 내려오는 담지와 토리",
            false,
            false,
            null,
            null,
            null
    ),
    Page27(
            "story",
            27,
            28,
            "gray",
            "#4 하루의 끝",
            "생활문화지원센터를 둘러보고 오니\n어느새 담지랑 헤어질 시간이 왔다.",
            false,
            false,
            null,
            null,
            null
    ),
    Page28(
            "story",
            28,
            29,
            "orange",
            "담지",
            "토리야 오늘 재밌었어 조심히 가~",
            false,
            false,
            null,
            null,
            null
    ),
    Page29(
            "story",
            29,
            30,
            "brown",
            "토리",
            "담지 너도 잘가!",
            false,
            false,
            null,
            null,
            null
    ),
    Page30(
            "story",
            30,
            0,
            "gray",
            null,
            "보람찬 토리의 하루가 끝이 났습니다.",
            false,
            true,
            null,
            null,
            null
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

    private BaseTemplate(String temp, int id, int nextId, String color, String who, String text, Boolean hidden, Boolean isLast, String number, String question, List<String> answer) {
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
    }

}
