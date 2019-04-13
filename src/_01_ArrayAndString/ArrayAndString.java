package _01_ArrayAndString;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class ArrayAndString {
    /*******************************************
     * 1. 문자열이 주어졌을때 중복된 문자가 없는지 확인
     *******************************************/
    public static boolean solution01 (String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] charArr = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            if (charArr[str.charAt(i)]) {
                return false;
            }
            charArr[str.charAt(i)] = true;
        }
        return true;
    }

    /*******************************************
     * 2. 문자열 두 개가 주어졌을 때 이 둘이 순열관계인지 확인
     *******************************************/
    public static boolean solution02 (String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        

        return true;
    }

    /*******************************************
     * 3. URL 공백 변환
     *******************************************/
    public static String solution03 (String str) {
        return str.replaceAll(Pattern.quote(" "), "%20");
    }

    /*******************************************
     * 4. 주어진 문자열이 회문순열인지 확인
     *******************************************/
    public static boolean solution04 (String str) {
        int oddNumberCount = 2;
        if (str.length() % 2 != 0) {
            oddNumberCount = 1;   // 홀수
        }
        HashMap<Character, Integer> charMap = new HashMap<>();

        // Map에 캐릭터 입력 횟수 입력
        for (char ch : str.toLowerCase().toCharArray()) {
            int value = Optional.ofNullable(charMap.get(ch)).orElse(0);
            charMap.put(ch, ++value);
        }
        // 홀수 인 캐릭터의 갯수를 확인
        for (char key :charMap.keySet()) {
            if (charMap.get(key) % 2 != 0) {
                oddNumberCount--;
            }

            if (oddNumberCount < 0) {
                return false;
            }
        }

        return true;
    }


}// End of ArrayAndString class
