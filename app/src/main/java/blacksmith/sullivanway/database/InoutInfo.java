package blacksmith.sullivanway.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class InoutInfo {
    private static SQLiteDatabase db;
    public static String TB_NAME = "InoutInfo";
    static String SQL_CREATE = String.format("CREATE TABLE %s(" +
            "lineNm TEXT NOT NULL," +
            "startStnNm TEXT NOT NULL," +
            "endStnNm TEXT NOT NULL," +
            "primary key(lineNm, startStnNm, endStnNm));", TB_NAME);
    static String SQL_DROP = String.format("DROP TABLE IF EXISTS %s", TB_NAME);
    static String SQL_DELETE_ALL = String.format("DELETE FROM %s", TB_NAME);

    static boolean isUpward(String lineNm, String startStnNm, String endStnNm) {
        String sql = String.format("SELECT startStnNm FROM %s WHERE lineNm='%s' AND startStnNm='%s' AND endStnNm='%s'",
                TB_NAME, lineNm, startStnNm, endStnNm);
        Cursor cursor = db.rawQuery(sql, null);
        boolean isUpward = !cursor.moveToNext();
        cursor.close();
        return isUpward;
    }

    public static String getNextStnNms(String lineNm, String stnNm, int toward) {
        String nextStnNms = "";

        String sql = (toward == 1) ?
                String.format("SELECT startStnNm FROM %s WHERE lineNM='%s' AND endStnNm='%s'",
                        TB_NAME, lineNm, stnNm) :
                String.format("SELECT endStnNm FROM %s WHERE lineNM='%s' AND startStnNm='%s'",
                        TB_NAME, lineNm, stnNm);
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToNext())
            nextStnNms += cursor.getString(0);
        while (cursor.moveToNext())
            nextStnNms += ", " + cursor.getString(0);
        cursor.close();
        return nextStnNms;
    }


    /* Database */
    private static void insert(String lineNm, String startStnNm, String endStnNm) {
        String sql = String.format(
                "INSERT INTO %s VALUES('%s','%s','%s');",
                TB_NAME, lineNm, startStnNm, endStnNm);
        db.execSQL(sql);
    }

    static void setDatabase(SQLiteDatabase db) {
        InoutInfo.db = db;
    }

    static void initDatabase() {
        // 상행 -> 하행
        // 1호선
        insert("1호선", "소요산", "동두천");
        insert("1호선", "동두천", "보산");
        insert("1호선", "보산", "동두천중앙");
        insert("1호선", "동두천중앙", "지행");
        insert("1호선", "지행", "덕정");
        insert("1호선", "덕정", "덕계");
        insert("1호선", "덕계", "양주");
        insert("1호선", "양주", "녹양");
        insert("1호선", "녹양", "가능");
        insert("1호선", "가능", "의정부");
        insert("1호선", "의정부", "회룡");
        insert("1호선", "회룡", "망월사");
        insert("1호선", "망월사", "도봉산");
        insert("1호선", "도봉산", "도봉");
        insert("1호선", "도봉", "방학");
        insert("1호선", "방학", "창동");
        insert("1호선", "창동", "녹천");
        insert("1호선", "녹천", "월계");
        insert("1호선", "월계", "광운대");
        insert("1호선", "광운대", "석계");
        insert("1호선", "석계", "신이문");
        insert("1호선", "신이문", "외대앞");
        insert("1호선", "외대앞", "회기");
        insert("1호선", "회기", "청량리");
        insert("1호선", "청량리", "제기동");
        insert("1호선", "제기동", "신설동");
        insert("1호선", "신설동", "동묘앞");
        insert("1호선", "동묘앞", "동대문");
        insert("1호선", "동대문", "종로5가");
        insert("1호선", "종로5가", "종로3가");
        insert("1호선", "종로3가", "종각");
        insert("1호선", "종각", "시청");
        insert("1호선", "시청", "서울");
        insert("1호선", "서울", "남영");
        insert("1호선", "남영", "용산");
        insert("1호선", "용산", "노량진");
        insert("1호선", "노량진", "대방");
        insert("1호선", "대방", "신길");
        insert("1호선", "신길", "영등포");
        insert("1호선", "영등포", "신도림");
        insert("1호선", "신도림", "구로");
        insert("1호선", "구로", "구일");
        insert("1호선", "구일", "개봉");
        insert("1호선", "개봉", "오류동");
        insert("1호선", "오류동", "온수");
        insert("1호선", "온수", "역곡");
        insert("1호선", "역곡", "소사");
        insert("1호선", "소사", "부천");
        insert("1호선", "부천", "중동");
        insert("1호선", "중동", "송내");
        insert("1호선", "송내", "부개");
        insert("1호선", "부개", "부평");
        insert("1호선", "부평", "백운");
        insert("1호선", "백운", "동암");
        insert("1호선", "동암", "간석");
        insert("1호선", "간석", "주안");
        insert("1호선", "주안", "도화");
        insert("1호선", "도화", "제물포");
        insert("1호선", "제물포", "도원");
        insert("1호선", "도원", "동인천");
        insert("1호선", "동인천", "인천");
        insert("1호선", "구로", "가산디지털단지");
        insert("1호선", "가산디지털단지", "독산");
        insert("1호선", "독산", "금천구청");
        insert("1호선", "금천구청", "광명");
        insert("1호선", "금천구청", "석수");
        insert("1호선", "석수", "관악");
        insert("1호선", "관악", "안양");
        insert("1호선", "안양", "명학");
        insert("1호선", "명학", "금정");
        insert("1호선", "금정", "군포");
        insert("1호선", "군포", "당정");
        insert("1호선", "당정", "의왕");
        insert("1호선", "의왕", "성균관대");
        insert("1호선", "성균관대", "화서");
        insert("1호선", "화서", "수원");
        insert("1호선", "수원", "세류");
        insert("1호선", "세류", "병점");
        insert("1호선", "병점", "서동탄");
        insert("1호선", "병점", "세마");
        insert("1호선", "세마", "오산대");
        insert("1호선", "오산대", "오산");
        insert("1호선", "오산", "진위");
        insert("1호선", "진위", "송탄");
        insert("1호선", "송탄", "서정리");
        insert("1호선", "서정리", "지제");
        insert("1호선", "지제", "평택");
        insert("1호선", "평택", "성환");
        insert("1호선", "성환", "직산");
        insert("1호선", "직산", "두정");
        insert("1호선", "두정", "천안");
        insert("1호선", "천안", "봉명");
        insert("1호선", "봉명", "쌍용(나사렛대)");
        insert("1호선", "쌍용(나사렛대)", "아산");
        insert("1호선", "아산", "배방");
        insert("1호선", "배방", "온양온천");
        insert("1호선", "온양온천", "신창(순천향대)");

        // 2호선
        insert("2호선", "시청", "을지로입구");
        insert("2호선", "을지로입구", "을지로3가");
        insert("2호선", "을지로3가", "을지로4가");
        insert("2호선", "을지로4가", "동대문역사문화공원");
        insert("2호선", "동대문역사문화공원", "신당");
        insert("2호선", "신당", "상왕십리");
        insert("2호선", "상왕십리", "왕십리");
        insert("2호선", "왕십리", "한양대");
        insert("2호선", "한양대", "뚝섬");
        insert("2호선", "뚝섬", "성수");
        insert("2호선", "성수", "용답");
        insert("2호선", "용답", "신답");
        insert("2호선", "신답", "용두");
        insert("2호선", "용두", "신설동");
        insert("2호선", "성수", "건대입구");
        insert("2호선", "건대입구", "구의");
        insert("2호선", "구의", "강변");
        insert("2호선", "강변", "잠실나루");
        insert("2호선", "잠실나루", "잠실");
        insert("2호선", "잠실", "잠실새내");
        insert("2호선", "잠실새내", "종합운동장");
        insert("2호선", "종합운동장", "삼성");
        insert("2호선", "삼성", "선릉");
        insert("2호선", "선릉", "역삼");
        insert("2호선", "역삼", "강남");
        insert("2호선", "강남", "교대");
        insert("2호선", "교대", "서초");
        insert("2호선", "서초", "방배");
        insert("2호선", "방배", "사당");
        insert("2호선", "사당", "낙성대");
        insert("2호선", "낙성대", "서울대입구");
        insert("2호선", "서울대입구", "봉천");
        insert("2호선", "봉천", "신림");
        insert("2호선", "신림", "신대방");
        insert("2호선", "신대방", "구로디지털단지");
        insert("2호선", "구로디지털단지", "대림");
        insert("2호선", "대림", "신도림");
        insert("2호선", "까치산", "신정네거리");
        insert("2호선", "신정네거리", "양천구청");
        insert("2호선", "양천구청", "도림천");
        insert("2호선", "도림천", "신도림");
        insert("2호선", "신도림", "문래");
        insert("2호선", "문래", "영등포구청");
        insert("2호선", "영등포구청", "당산");
        insert("2호선", "당산", "합정");
        insert("2호선", "합정", "홍대입구");
        insert("2호선", "홍대입구", "신촌");
        insert("2호선", "신촌", "이대");
        insert("2호선", "이대", "아현");
        insert("2호선", "아현", "충정로");
        insert("2호선", "충정로", "시청");

        // 3호선
        insert("3호선", "대화", "주엽");
        insert("3호선", "주엽", "정발산");
        insert("3호선", "정발산", "마두");
        insert("3호선", "마두", "백석");
        insert("3호선", "백석", "대곡");
        insert("3호선", "대곡", "화정");
        insert("3호선", "화정", "원당");
        insert("3호선", "원당", "원흥");
        insert("3호선", "원흥", "삼송");
        insert("3호선", "삼송", "지축");
        insert("3호선", "지축", "구파발");
        insert("3호선", "구파발", "연신내");
        insert("3호선", "연신내", "불광");
        insert("3호선", "불광", "녹번");
        insert("3호선", "녹번", "홍제");
        insert("3호선", "홍제", "무악재");
        insert("3호선", "무악재", "독립문");
        insert("3호선", "독립문", "경복궁");
        insert("3호선", "경복궁", "안국");
        insert("3호선", "안국", "종로3가");
        insert("3호선", "종로3가", "을지로3가");
        insert("3호선", "을지로3가", "충무로");
        insert("3호선", "충무로", "동대입구");
        insert("3호선", "동대입구", "약수");
        insert("3호선", "약수", "금호");
        insert("3호선", "금호", "옥수");
        insert("3호선", "옥수", "압구정");
        insert("3호선", "압구정", "신사");
        insert("3호선", "신사", "잠원");
        insert("3호선", "잠원", "고속터미널");
        insert("3호선", "고속터미널", "교대");
        insert("3호선", "교대", "남부터미널");
        insert("3호선", "남부터미널", "양재");
        insert("3호선", "양재", "매봉");
        insert("3호선", "매봉", "도곡");
        insert("3호선", "도곡", "대치");
        insert("3호선", "대치", "학여울");
        insert("3호선", "학여울", "대청");
        insert("3호선", "대청", "일원");
        insert("3호선", "일원", "수서");
        insert("3호선", "수서", "가락시장");
        insert("3호선", "가락시장", "경찰병원");
        insert("3호선", "경찰병원", "오금");

        // 4호선
        insert("4호선", "당고개", "상계");
        insert("4호선", "상계", "노원");
        insert("4호선", "노원", "창동");
        insert("4호선", "창동", "쌍문");
        insert("4호선", "쌍문", "수유(강북구청)");
        insert("4호선", "수유(강북구청)", "미아");
        insert("4호선", "미아", "미아사거리");
        insert("4호선", "미아사거리", "길음");
        insert("4호선", "길음", "성신여대입구");
        insert("4호선", "성신여대입구", "한성대입구");
        insert("4호선", "한성대입구", "혜화");
        insert("4호선", "혜화", "동대문");
        insert("4호선", "동대문", "동대문역사문화공원");
        insert("4호선", "동대문역사문화공원", "충무로");
        insert("4호선", "충무로", "명동");
        insert("4호선", "명동", "회현");
        insert("4호선", "회현", "서울");
        insert("4호선", "서울", "숙대입구");
        insert("4호선", "숙대입구", "삼각지");
        insert("4호선", "삼각지", "신용산");
        insert("4호선", "신용산", "이촌");
        insert("4호선", "이촌", "동작");
        insert("4호선", "동작", "총신대입구(이수)");
        insert("4호선", "총신대입구(이수)", "사당");
        insert("4호선", "사당", "남태령");
        insert("4호선", "남태령", "선바위");
        insert("4호선", "선바위", "경마공원");
        insert("4호선", "경마공원", "대공원");
        insert("4호선", "대공원", "과천");
        insert("4호선", "과천", "정부과천청사");
        insert("4호선", "정부과천청사", "인덕원");
        insert("4호선", "인덕원", "평촌");
        insert("4호선", "평촌", "범계");
        insert("4호선", "범계", "금정");
        insert("4호선", "금정", "산본");
        insert("4호선", "산본", "수리산");
        insert("4호선", "수리산", "대야미");
        insert("4호선", "대야미", "반월");
        insert("4호선", "반월", "상록수");
        insert("4호선", "상록수", "한대앞");
        insert("4호선", "한대앞", "중앙");
        insert("4호선", "중앙", "고잔");
        insert("4호선", "고잔", "초지");
        insert("4호선", "초지", "안산");
        insert("4호선", "안산", "신길온천");
        insert("4호선", "신길온천", "정왕");
        insert("4호선", "정왕", "오이도");

        // 5호선
        insert("5호선", "방화", "개화산");
        insert("5호선", "개화산", "김포공항");
        insert("5호선", "김포공항", "송정");
        insert("5호선", "송정", "마곡");
        insert("5호선", "마곡", "발산");
        insert("5호선", "발산", "우장산");
        insert("5호선", "우장산", "화곡");
        insert("5호선", "화곡", "까치산");
        insert("5호선", "까치산", "신정");
        insert("5호선", "신정", "목동");
        insert("5호선", "목동", "오목교");
        insert("5호선", "오목교", "양평");
        insert("5호선", "양평", "영등포구청");
        insert("5호선", "영등포구청", "영등포시장");
        insert("5호선", "영등포시장", "신길");
        insert("5호선", "신길", "여의도");
        insert("5호선", "여의도", "여의나루");
        insert("5호선", "여의나루", "마포");
        insert("5호선", "마포", "공덕");
        insert("5호선", "공덕", "애오개");
        insert("5호선", "애오개", "충정로");
        insert("5호선", "충정로", "서대문");
        insert("5호선", "서대문", "광화문");
        insert("5호선", "광화문", "종로3가");
        insert("5호선", "종로3가", "을지로4가");
        insert("5호선", "을지로4가", "동대문역사문화공원");
        insert("5호선", "동대문역사문화공원", "청구");
        insert("5호선", "청구", "신금호");
        insert("5호선", "신금호", "행당");
        insert("5호선", "행당", "왕십리");
        insert("5호선", "왕십리", "마장");
        insert("5호선", "마장", "답십리");
        insert("5호선", "답십리", "장한평");
        insert("5호선", "장한평", "군자");
        insert("5호선", "군자", "아차산");
        insert("5호선", "아차산", "광나루");
        insert("5호선", "광나루", "천호");
        insert("5호선", "천호", "강동");
        insert("5호선", "강동", "길동");
        insert("5호선", "길동", "굽은다리");
        insert("5호선", "굽은다리", "명일");
        insert("5호선", "명일", "고덕");
        insert("5호선", "고덕", "상일동");
        insert("5호선", "강동", "둔촌동");
        insert("5호선", "둔촌동", "올림픽공원");
        insert("5호선", "올림픽공원", "방이");
        insert("5호선", "방이", "오금");
        insert("5호선", "오금", "개롱");
        insert("5호선", "개롱", "거여");
        insert("5호선", "거여", "마천");

        // 6호선
        insert("6호선", "응암", "역촌");
        insert("6호선", "역촌", "불광");
        insert("6호선", "불광", "독바위");
        insert("6호선", "독바위", "연신내");
        insert("6호선", "연신내", "구산");
        insert("6호선", "구산", "응암");
        insert("6호선", "응암", "새절");
        insert("6호선", "새절", "증산");
        insert("6호선", "증산", "디지털미디어시티");
        insert("6호선", "디지털미디어시티", "월드컵경기장");
        insert("6호선", "월드컵경기장", "마포구청");
        insert("6호선", "마포구청", "망원");
        insert("6호선", "망원", "합정");
        insert("6호선", "합정", "상수");
        insert("6호선", "상수", "광흥창");
        insert("6호선", "광흥창", "대흥");
        insert("6호선", "대흥", "공덕");
        insert("6호선", "공덕", "효창공원앞");
        insert("6호선", "효창공원앞", "삼각지");
        insert("6호선", "삼각지", "녹사평(용산구청)");
        insert("6호선", "녹사평(용산구청)", "이태원");
        insert("6호선", "이태원", "한강진");
        insert("6호선", "한강진", "버티고개");
        insert("6호선", "버티고개", "약수");
        insert("6호선", "약수", "청구");
        insert("6호선", "청구", "신당");
        insert("6호선", "신당", "동묘앞");
        insert("6호선", "동묘앞", "창신");
        insert("6호선", "창신", "보문");
        insert("6호선", "보문", "안암");
        insert("6호선", "안암", "고려대");
        insert("6호선", "고려대", "월곡");
        insert("6호선", "월곡", "상월곡");
        insert("6호선", "상월곡", "돌곶이");
        insert("6호선", "돌곶이", "석계");
        insert("6호선", "석계", "태릉입구");
        insert("6호선", "태릉입구", "화랑대");
        insert("6호선", "화랑대", "봉화산(서울의료원)");

        // 7호선
        insert("7호선", "장암", "도봉산");
        insert("7호선", "도봉산", "수락산");
        insert("7호선", "수락산", "마들");
        insert("7호선", "마들", "노원");
        insert("7호선", "노원", "중계");
        insert("7호선", "중계", "하계");
        insert("7호선", "하계", "공릉");
        insert("7호선", "공릉", "태릉입구");
        insert("7호선", "태릉입구", "먹골");
        insert("7호선", "먹골", "중화");
        insert("7호선", "중화", "상봉");
        insert("7호선", "상봉", "면목");
        insert("7호선", "면목", "사가정");
        insert("7호선", "사가정", "용마산");
        insert("7호선", "용마산", "중곡");
        insert("7호선", "중곡", "군자");
        insert("7호선", "군자", "어린이대공원");
        insert("7호선", "어린이대공원", "건대입구");
        insert("7호선", "건대입구", "뚝섬유원지");
        insert("7호선", "뚝섬유원지", "청담");
        insert("7호선", "청담", "강남구청");
        insert("7호선", "강남구청", "학동");
        insert("7호선", "학동", "논현");
        insert("7호선", "논현", "반포");
        insert("7호선", "반포", "고속터미널");
        insert("7호선", "고속터미널", "내방");
        insert("7호선", "내방", "총신대입구(이수)");
        insert("7호선", "총신대입구(이수)", "남성");
        insert("7호선", "남성", "숭실대입구");
        insert("7호선", "숭실대입구", "상도");
        insert("7호선", "상도", "장승배기");
        insert("7호선", "장승배기", "신대방삼거리");
        insert("7호선", "신대방삼거리", "보라매");
        insert("7호선", "보라매", "신풍");
        insert("7호선", "신풍", "대림");
        insert("7호선", "대림", "남구로");
        insert("7호선", "남구로", "가산디지털단지");
        insert("7호선", "가산디지털단지", "철산");
        insert("7호선", "철산", "광명사거리");
        insert("7호선", "광명사거리", "천왕");
        insert("7호선", "천왕", "온수");
        insert("7호선", "온수", "까치울");
        insert("7호선", "까치울", "부천종합운동장");
        insert("7호선", "부천종합운동장", "춘의");
        insert("7호선", "춘의", "신중동");
        insert("7호선", "신중동", "부천시청");
        insert("7호선", "부천시청", "상동");
        insert("7호선", "상동", "삼산체육관");
        insert("7호선", "삼산체육관", "굴포천");
        insert("7호선", "굴포천", "부평구청");

        // 8호선
        insert("8호선", "암사", "천호");
        insert("8호선", "천호", "강동구청");
        insert("8호선", "강동구청", "몽촌토성");
        insert("8호선", "몽촌토성", "잠실");
        insert("8호선", "잠실", "석촌");
        insert("8호선", "석촌", "송파");
        insert("8호선", "송파", "가락시장");
        insert("8호선", "가락시장", "문정");
        insert("8호선", "문정", "장지");
        insert("8호선", "장지", "복정");
        insert("8호선", "복정", "산성");
        insert("8호선", "산성", "남한산성입구");
        insert("8호선", "남한산성입구", "단대오거리");
        insert("8호선", "단대오거리", "신흥");
        insert("8호선", "신흥", "수진");
        insert("8호선", "수진", "모란");

        // 9호선
        insert("9호선", "개화", "김포공항");
        insert("9호선", "김포공항", "공항시장");
        insert("9호선", "공항시장", "신방화");
        insert("9호선", "신방화", "마곡나루");
        insert("9호선", "마곡나루", "양천향교");
        insert("9호선", "양천향교", "가양");
        insert("9호선", "가양", "증미");
        insert("9호선", "증미", "등촌");
        insert("9호선", "등촌", "염창");
        insert("9호선", "염창", "신목동");
        insert("9호선", "신목동", "선유도");
        insert("9호선", "선유도", "당산");
        insert("9호선", "당산", "국회의사당");
        insert("9호선", "국회의사당", "여의도");
        insert("9호선", "여의도", "샛강");
        insert("9호선", "샛강", "노량진");
        insert("9호선", "노량진", "노들");
        insert("9호선", "노들", "흑석");
        insert("9호선", "흑석", "동작");
        insert("9호선", "동작", "구반포");
        insert("9호선", "구반포", "신반포");
        insert("9호선", "신반포", "고속터미널");
        insert("9호선", "고속터미널", "사평");
        insert("9호선", "사평", "신논현");
        insert("9호선", "신논현", "언주");
        insert("9호선", "언주", "선정릉");
        insert("9호선", "선정릉", "삼성중앙");
        insert("9호선", "삼성중앙", "봉은사");
        insert("9호선", "봉은사", "종합운동장");

        // 인천국제공항철도
        insert("인천국제공항철도", "서울", "공덕");
        insert("인천국제공항철도", "공덕", "홍대입구");
        insert("인천국제공항철도", "홍대입구", "디지털미디어시티");
        insert("인천국제공항철도", "디지털미디어시티", "김포공항");
        insert("인천국제공항철도", "김포공항", "계양");
        insert("인천국제공항철도", "계양", "검암");
        insert("인천국제공항철도", "검암", "청라국제도시");
        insert("인천국제공항철도", "청라국제도시", "영종");
        insert("인천국제공항철도", "영종", "운서");
        insert("인천국제공항철도", "운서", "공항화물청사");
        insert("인천국제공항철도", "공항화물청사", "인천국제공항");

        // 자기부상철도
        insert("자기부상철도", "인천국제공항", "장기주차장");
        insert("자기부상철도", "장기주차장", "합동청사");
        insert("자기부상철도", "합동청사", "파라다이스시티");
        insert("자기부상철도", "파라다이스시티", "워터파크");
        insert("자기부상철도", "워터파크", "용유");

        // 분당선
        insert("분당선", "왕십리", "서울숲");
        insert("분당선", "서울숲", "압구정로데오");
        insert("분당선", "압구정로데오", "강남구청");
        insert("분당선", "강남구청", "선정릉");
        insert("분당선", "선정릉", "선릉");
        insert("분당선", "선릉", "한티");
        insert("분당선", "한티", "도곡");
        insert("분당선", "도곡", "구룡");
        insert("분당선", "구룡", "개포동");
        insert("분당선", "개포동", "대모산입구");
        insert("분당선", "대모산입구", "수서");
        insert("분당선", "수서", "복정");
        insert("분당선", "복정", "가천대");
        insert("분당선", "가천대", "태평");
        insert("분당선", "태평", "모란");
        insert("분당선", "모란", "야탑");
        insert("분당선", "야탑", "이매");
        insert("분당선", "이매", "서현");
        insert("분당선", "서현", "수내");
        insert("분당선", "수내", "정자");
        insert("분당선", "정자", "미금");
        insert("분당선", "미금", "오리");
        insert("분당선", "오리", "죽전");
        insert("분당선", "죽전", "보정");
        insert("분당선", "보정", "구성");
        insert("분당선", "구성", "신갈");
        insert("분당선", "신갈", "기흥");
        insert("분당선", "기흥", "상갈");
        insert("분당선", "상갈", "청명");
        insert("분당선", "청명", "영통");
        insert("분당선", "영통", "망포");
        insert("분당선", "망포", "매탄권선");
        insert("분당선", "매탄권선", "수원시청");
        insert("분당선", "수원시청", "매교");
        insert("분당선", "매교", "수원");

        // 에버라인
        insert("에버라인", "기흥", "강남대");
        insert("에버라인", "강남대", "지석");
        insert("에버라인", "지석", "어정");
        insert("에버라인", "어정", "동백");
        insert("에버라인", "동백", "초당");
        insert("에버라인", "초당", "삼가");
        insert("에버라인", "삼가", "시청·용인대");
        insert("에버라인", "시청·용인대", "명지대");
        insert("에버라인", "명지대", "김량장");
        insert("에버라인", "김량장", "운동장·송담대");
        insert("에버라인", "운동장·송담대", "고진");
        insert("에버라인", "고진", "보평");
        insert("에버라인", "보평", "둔전");
        insert("에버라인", "둔전", "전대·에버랜드");

        // 경춘선
        insert("경춘선", "청량리", "회기");
        insert("경춘선", "회기", "중랑");
        insert("경춘선", "중랑", "상봉");
        insert("경춘선", "상봉", "망우");
        insert("경춘선", "망우", "신내");
        insert("경춘선", "신내", "갈매");
        insert("경춘선", "갈매", "별내");
        insert("경춘선", "별내", "퇴계원");
        insert("경춘선", "퇴계원", "사릉");
        insert("경춘선", "사릉", "금곡");
        insert("경춘선", "금곡", "평내호평");
        insert("경춘선", "평내호평", "천마산");
        insert("경춘선", "천마산", "마석");
        insert("경춘선", "마석", "대성리");
        insert("경춘선", "대성리", "청평");
        insert("경춘선", "청평", "상천");
        insert("경춘선", "상천", "가평");
        insert("경춘선", "가평", "굴봉산");
        insert("경춘선", "굴봉산", "백양리");
        insert("경춘선", "백양리", "강촌");
        insert("경춘선", "강촌", "김유정");
        insert("경춘선", "김유정", "남춘천");
        insert("경춘선", "남춘천", "춘천");

        // 인천1호선
        insert("인천1호선", "계양", "귤현");
        insert("인천1호선", "귤현", "박촌");
        insert("인천1호선", "박촌", "임학");
        insert("인천1호선", "임학", "계산");
        insert("인천1호선", "계산", "경인교대입구");
        insert("인천1호선", "경인교대입구", "작전");
        insert("인천1호선", "작전", "갈산");
        insert("인천1호선", "갈산", "부평구청");
        insert("인천1호선", "부평구청", "부평시장");
        insert("인천1호선", "부평시장", "부평");
        insert("인천1호선", "부평", "동수");
        insert("인천1호선", "동수", "부평삼거리");
        insert("인천1호선", "부평삼거리", "간석오거리");
        insert("인천1호선", "간석오거리", "인천시청");
        insert("인천1호선", "인천시청", "예술회관");
        insert("인천1호선", "예술회관", "인천터미널");
        insert("인천1호선", "인천터미널", "문학경기장");
        insert("인천1호선", "문학경기장", "선학");
        insert("인천1호선", "선학", "신연수");
        insert("인천1호선", "신연수", "원인재");
        insert("인천1호선", "원인재", "동춘");
        insert("인천1호선", "동춘", "동막");
        insert("인천1호선", "동막", "캠퍼스타운");
        insert("인천1호선", "캠퍼스타운", "테크노파크");
        insert("인천1호선", "테크노파크", "지식정보단지");
        insert("인천1호선", "지식정보단지", "인천대입구");
        insert("인천1호선", "인천대입구", "센트럴파크");
        insert("인천1호선", "센트럴파크", "국제업무지구");

        // 인천2호선
        insert("인천2호선", "검단오류", "왕길");
        insert("인천2호선", "왕길", "검단사거리");
        insert("인천2호선", "검단사거리", "마전");
        insert("인천2호선", "마전", "완정");
        insert("인천2호선", "완정", "독정");
        insert("인천2호선", "독정", "검암");
        insert("인천2호선", "검암", "검바위");
        insert("인천2호선", "검바위", "아시아드경기장");
        insert("인천2호선", "아시아드경기장", "서구청");
        insert("인천2호선", "서구청", "가정");
        insert("인천2호선", "가정", "가정중앙시장");
        insert("인천2호선", "가정중앙시장", "석남");
        insert("인천2호선", "석남", "서부여성회관");
        insert("인천2호선", "서부여성회관", "인천가좌");
        insert("인천2호선", "인천가좌", "가재울");
        insert("인천2호선", "가재울", "주안국가산단");
        insert("인천2호선", "주안국가산단", "주안");
        insert("인천2호선", "주안", "시민공원");
        insert("인천2호선", "시민공원", "석바위시장");
        insert("인천2호선", "석바위시장", "인천시청");
        insert("인천2호선", "인천시청", "석천사거리");
        insert("인천2호선", "석천사거리", "모래내시장");
        insert("인천2호선", "모래내시장", "만수");
        insert("인천2호선", "만수", "남동구청");
        insert("인천2호선", "남동구청", "인천대공원");
        insert("인천2호선", "인천대공원", "운연");

        // 경의중앙선
        insert("경의중앙선", "문산", "파주");
        insert("경의중앙선", "파주", "월롱");
        insert("경의중앙선", "월롱", "금촌");
        insert("경의중앙선", "금촌", "금릉");
        insert("경의중앙선", "금릉", "운정");
        insert("경의중앙선", "운정", "야당");
        insert("경의중앙선", "야당", "탄현");
        insert("경의중앙선", "탄현", "일산");
        insert("경의중앙선", "일산", "풍산");
        insert("경의중앙선", "풍산", "백마");
        insert("경의중앙선", "백마", "곡산");
        insert("경의중앙선", "곡산", "대곡");
        insert("경의중앙선", "대곡", "능곡");
        insert("경의중앙선", "능곡", "행신");
        insert("경의중앙선", "행신", "강매");
        insert("경의중앙선", "강매", "화전");
        insert("경의중앙선", "화전", "수색");
        insert("경의중앙선", "수색", "디지털미디어시티");
        insert("경의중앙선", "디지털미디어시티", "가좌");
        insert("경의중앙선", "가좌", "신촌(경의중앙선)");
        insert("경의중앙선", "신촌(경의중앙선)", "서울");
        insert("경의중앙선", "가좌", "홍대입구");
        insert("경의중앙선", "홍대입구", "서강대");
        insert("경의중앙선", "서강대", "공덕");
        insert("경의중앙선", "공덕", "효창공원앞");
        insert("경의중앙선", "효창공원앞", "용산");
        insert("경의중앙선", "용산", "이촌");
        insert("경의중앙선", "이촌", "서빙고");
        insert("경의중앙선", "서빙고", "한남");
        insert("경의중앙선", "한남", "옥수");
        insert("경의중앙선", "옥수", "응봉");
        insert("경의중앙선", "응봉", "왕십리");
        insert("경의중앙선", "왕십리", "청량리");
        insert("경의중앙선", "청량리", "회기");
        insert("경의중앙선", "회기", "중랑");
        insert("경의중앙선", "중랑", "상봉");
        insert("경의중앙선", "상봉", "망우");
        insert("경의중앙선", "망우", "양원");
        insert("경의중앙선", "양원", "구리");
        insert("경의중앙선", "구리", "도농");
        insert("경의중앙선", "도농", "양정");
        insert("경의중앙선", "양정", "덕소");
        insert("경의중앙선", "덕소", "도심");
        insert("경의중앙선", "도심", "팔당");
        insert("경의중앙선", "팔당", "운길산");
        insert("경의중앙선", "운길산", "양수");
        insert("경의중앙선", "양수", "신원");
        insert("경의중앙선", "신원", "국수");
        insert("경의중앙선", "국수", "아신");
        insert("경의중앙선", "아신", "오빈");
        insert("경의중앙선", "오빈", "양평");
        insert("경의중앙선", "양평", "원덕");
        insert("경의중앙선", "원덕", "용문");
        insert("경의중앙선", "용문", "지평");

        // 경강선
        insert("경강선", "판교", "이매");
        insert("경강선", "이매", "삼동");
        insert("경강선", "삼동", "경기광주");
        insert("경강선", "경기광주", "초월");
        insert("경강선", "초월", "곤지암");
        insert("경강선", "곤지암", "신둔도예촌");
        insert("경강선", "신둔도예촌", "이천");
        insert("경강선", "이천", "부발");
        insert("경강선", "부발", "세종대왕릉");
        insert("경강선", "세종대왕릉", "여주");

        // 신분당선
        insert("신분당선", "강남", "양재");
        insert("신분당선", "양재", "양재시민의숲");
        insert("신분당선", "양재시민의숲", "청계산입구");
        insert("신분당선", "청계산입구", "판교");
        insert("신분당선", "판교", "정자");
        insert("신분당선", "정자", "동천");
        insert("신분당선", "동천", "수지구청");
        insert("신분당선", "수지구청", "성복");
        insert("신분당선", "성복", "상현");
        insert("신분당선", "상현", "광교중앙");
        insert("신분당선", "광교중앙", "광교");

        // 수인선
        insert("수인선", "오이도", "달월");
        insert("수인선", "달월", "월곶");
        insert("수인선", "월곶", "소래포구");
        insert("수인선", "소래포구", "인천논현");
        insert("수인선", "인천논현", "호구포");
        insert("수인선", "호구포", "남동인더스파크");
        insert("수인선", "남동인더스파크", "원인재");
        insert("수인선", "원인재", "연수");
        insert("수인선", "연수", "송도");
        insert("수인선", "송도", "인하대");
        insert("수인선", "인하대", "숭의");
        insert("수인선", "숭의", "신포");
        insert("수인선", "신포", "인천");

        // 의정부경전철
        insert("의정부경전철", "발곡", "회룡");
        insert("의정부경전철", "회룡", "범골");
        insert("의정부경전철", "범골", "경전철의정부");
        insert("의정부경전철", "경전철의정부", "의정부시청");
        insert("의정부경전철", "의정부시청", "흥선");
        insert("의정부경전철", "흥선", "의정부중앙");
        insert("의정부경전철", "의정부중앙", "동오");
        insert("의정부경전철", "동오", "새말");
        insert("의정부경전철", "새말", "경기도청북부청사");
        insert("의정부경전철", "경기도청북부청사", "효자");
        insert("의정부경전철", "효자", "곤제");
        insert("의정부경전철", "곤제", "어룡");
        insert("의정부경전철", "어룡", "송산");
        insert("의정부경전철", "송산", "탑석");

        // 우이신설선
        insert("우이신설선", "북한산우이", "솔밭공원");
        insert("우이신설선", "솔밭공원", "4.19민주묘지");
        insert("우이신설선", "4.19민주묘지", "가오리");
        insert("우이신설선", "가오리", "화계");
        insert("우이신설선", "화계", "삼양");
        insert("우이신설선", "삼양", "삼양사거리");
        insert("우이신설선", "삼양사거리", "솔샘");
        insert("우이신설선", "솔샘", "북한산보국문");
        insert("우이신설선", "북한산보국문", "정릉");
        insert("우이신설선", "정릉", "성신여대입구");
        insert("우이신설선", "성신여대입구", "보문");
        insert("우이신설선", "보문", "신설동");

    }
    
}
