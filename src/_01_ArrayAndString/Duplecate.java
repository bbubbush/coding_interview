package _01_ArrayAndString;

public class Duplecate {
    /*
        1. 문자열이 주어졌을때 중복된 문자가 없는지 확인
    */
    public static boolean solution (String str) {
        boolean[] charArr = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            if (charArr[str.charAt(i)]) {
                return false;
            }
            charArr[str.charAt(i)] = true;
        }
        return true;
    }
}// End of Duplecate class
