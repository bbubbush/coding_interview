package _01_ArrayAndString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;
import java.util.regex.Pattern;

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
     *
     * >> 두 문자열의 순열관계인 경우, 정렬을 하면 동일한 문자를 갖는다
     *******************************************/
    public static boolean solution02 (String first, String second) {
        // 1. 문자열을 정렬하여 비교
//        if (first.length() != second.length()) {
//            return false;
//        }
//        return sortToString(first).equals(sortToString(second));

        // 2. 각 캐릭터 별 갯수를 새서 확인
        if (first.length() != second.length()) {
            return false;
        }

        int[] letters = new int[128];       // 아스키코드로 가정
        char[] first_array = first.toCharArray();

        // first 각 문자의 반복횟수를 샌다
        for (char c: first_array) {
            letters[c]++;
        }

        // second의 문자를 하나하나 뺀다
        for (int i = 0; i < second.length(); i++) {
            int c= (int)second.charAt(i);
            letters[c]--;
            if (letters[0] < 0) {
                return false;
            }
        }
        return false;
    }

    // 입력된 문자열을 정렬하여 return
    public static String sortToString(String str) {
        byte[] byteArray = str.getBytes();
        Arrays.sort(byteArray);
        return new String(byteArray);
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
    /*******************************************
     * 6. 문자열 압축하기
     *******************************************/
    public static String solution06 (String str) {
        int countOfDuplecate = 1;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (i + 1 < str.length() && str.charAt(i) == str.charAt( i + 1)) {
                countOfDuplecate++;
            } else {
                result += str.charAt(i) + (countOfDuplecate + "");
                countOfDuplecate = 1;
            }
        }
        return result;
    }
    /*******************************************
     * 7. 행렬 회전
     *******************************************/
    public static boolean solution07 (int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return false;
        }
        System.out.println("Before :: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - layer - 1;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // 윗 부분을 저장

                // 왼쪽 -> 위쪽
                matrix[first][i] = matrix[last - offset][first];
                // 아래쪽 -> 왼쪽
                matrix[last - offset][first] = matrix[last][last - offset];
                // 오른쪽 -> 아래쪽
                matrix[last][last - offset] = matrix[i][last];
                // 위쪽 -> 오른쪽
                matrix[i][last] = top;
            }

            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("After :: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        return true;
    }
    /*******************************************
     * 8. 0 행렬
     *******************************************/
    public static boolean solution08 (int[][] matrix) {

        return true;
    }
}// End of ArrayAndString class
