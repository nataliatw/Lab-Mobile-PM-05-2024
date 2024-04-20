package com.example.praktikumempatapp;

import java.util.ArrayList;

public class DataSource {
    public static ArrayList<Celebrity> celebrities = generateDummyCelebrities();

    private static ArrayList<Celebrity> generateDummyCelebrities() {
        ArrayList<Celebrity> celebrities = new ArrayList<>();
        celebrities.add(new Celebrity("Milephakphum","Mile Phakphum Romsaithong",",,, Vogue Gala Night 2024 ,,,\n" +
                "\n" +
                "Have A GN นะครับ^^", R.drawable.mile2, R.drawable.mile1));
        celebrities.add(new Celebrity("Tedsky89","Teddy Indra Wijaya", "Kami mengucapkan selamat beraktifitas dan bekerja bagi rekan-rekan semuanya… jangan lupa makan siang yang banyak biar kuat seperti adek-adek Taruna Akmil \n" +
                "\n" +
                "Happy weekdays everyone…", R.drawable.mayted4, R.drawable.mayted3));
        celebrities.add(new Celebrity("Sound_of_Coups","Choi Seungcheol", "우당탕탕 쿡스쿱스", R.drawable.scoups1, R.drawable.scoups2));
        celebrities.add(new Celebrity("Johnnyjsuh","NCT Johnny", "méxico fue increíble", R.drawable.johnny2, R.drawable.johnny1));
        celebrities.add(new Celebrity("Ppnaravit","Naravit Letratkosum", "let me cook for u", R.drawable.ppnaravit1, R.drawable.ppnaravit2));
        celebrities.add(new Celebrity("Phuwintang","Phuwin Tangsakyuen", "smile for 2022 ", R.drawable.phuwintang2, R.drawable.phuwintang1));
        celebrities.add(new Celebrity("Ateez_official_","8 Makes 1 Team", "[#인星화그램] 明日会いましょう\n" +
                "\n" +
                "#ATEEZ #에이티즈 #SEONGHWA #성화", R.drawable.ateez3, R.drawable.ateez1));
        celebrities.add(new Celebrity("leejen_o_423","NCT Jeno", "페라가모 FW24 쇼 참석하러 밀라노로 갑니다~~\n" +
                "시즈니 밀라노에서 만나요!!\n" +
                "@ferragamo #ferragamofw24 #페라가모",  R.drawable.jeno2, R.drawable.jeno1));
        celebrities.add(new Celebrity("seonho__kim","Kim Seonho", "24년 첫 팬미팅 행복했어요 늘 고맙습니다 #BANGKOK", R.drawable.seonho2, R.drawable.seonho1));
        celebrities.add(new Celebrity("that_guy_gonsta","Kyung Dohyun", "안녕하세요 경도현입니다!\n" +
                "\n" +
                "제가 스튜디오샤 채널에 참여하게 되었습니다\n" +
                "\n" +
                "사실 1학기동안 어떻게 지내야 하나 고민을 참 많이 했어요\n" +
                "제가 하고 싶은 일이 고등학생들과 참 많은 소통이 필요한 일인 바람에, 다양한 방법(유튜브나, 인스타그램이나, 커뮤니티나..)으로 소통을 시도했으나 쉽지 않더라구요.\n" +
                "왜 그런 것인가를 고민해 보니 콘텐츠를 만드는 데 드는 비용이 너무 크다는 것이 이유였던 것 같아요\n" +
                "글이나 사진으로 내용을 전달하기엔 저의 역량도 조금 부족할 뿐더러, 제가 가진 능력을 온전히 발휘하지 못하는 느낌도 들었어요!(그리고 사실 커뮤니티는 너무 어려운 것 같기도 해요.. 눈팅만 하다 보니까 글을 쓰기가 조심스러워지더라구요)\n" +
                "그래서 제가 관심있는 분야에 대해 이야기하며 지원도 받을 수 있는 유튜브 채널에 멤버로 참여하게 되었습니다!\n" +
                "\n" +
                "당연하게도, 저의 1차 목표=책 출간하기는 변함이 없고, 나름대로 착실하게 잘 진행 중이라고 느낍니다\n" +
                "다만, 제가 어느 정도까지 진행되었는가를 궁금해하시는 분들이 계셔서 어떻게 하면 공유할 수 있을까 고민 중이에요! (참고로 수1은 완성, 수2는 2단원 작업 중입니다)\n" +
                "이와 관련된 소식이 생긴다면 다른 게시물로 찾아뵙도록 하겠습니다\n" +
                "\n" +
                "정말 감사하게도, 저를 기대해주시고 지지해주시는 사람이 많다고 느끼는 요즘입니다. 그런 지지를 저버리지 않고 더 좋은 퍼포먼스를 보여주는 것이 은혜를 갚는 일이라고 생각해요!\n" +
                "\n" +
                "이만 말 줄이겠습니다.\n" +
                "우리, 자주 봐요! \n" +
                "\n" +
                "#스튜디오샤 #도도", R.drawable.dohyun1, R.drawable.dohyun2));
        return celebrities;
    }
}
