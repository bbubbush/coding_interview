import _01_ArrayAndString.ArrayAndString;

public class Main {

    public static void main(String[] args) {
        ArrayAndString arrayAndString = new ArrayAndString();

//        System.out.println(arrayAndString.solution01("abc 123")); // 중복된 문자가 있는지 확인
//        System.out.println(arrayAndString.solution02("god", "dag")); // 순열관계인지 확인
//        System.out.println(arrayAndString.solution03("Mr John Smith")); // URL 공백 파싱
//        System.out.println(arrayAndString.solution04("abddba")); // URL 공백 파싱
//        System.out.println(arrayAndString.solution06("aabbcc")); // 문자열 압축하기
        int[][] param = new int[5][5];
        for (int i = 0; i < param.length; i++) {
            for (int j = 0; j < param[i].length; j++) {
                param[i][j] = i + j;
            }
        }
        System.out.println(arrayAndString.solution07(param)); // 문자열 압축하기





    }
}
