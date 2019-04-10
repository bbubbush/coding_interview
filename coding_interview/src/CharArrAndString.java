public class CharArrAndString {

    // 1. 중복 문자 찾기
    public static boolean isUniqueChars(String str) {
        if (str.length() > 127) {
            return false;
        }
        boolean[] isAsciiArr = new boolean[128];

        for(int i = 0; i < str.length(); i++){
            int value = str.charAt(i);
            if (isAsciiArr[value]) {
                return false;
            }
            isAsciiArr[value] = true;
        }
        return true;
    }// End of isUniqueChars method


    // 2. 하나 빼기
    public static boolean oneEditAway(String first, String second) {
        // 교체
        if (first.length() == second.length()) {
            return ondEditReplace(first, second);
        }
        // 삽입 & 삭제
        else if (first.length() < second.length()) {
            return ondEditInsert(first, second);
        }
        // 삽입 & 삭제(단, 긴 문자를 두 번째 인자로)
        else if (first.length() > second.length()) {
            return ondEditInsert(second, first);
        }
        return false;
    }

    // 교체
    public static boolean ondEditReplace(String first, String second) {
        boolean foundDifference = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }
    // 삽입 & 삭제
    public static boolean ondEditInsert(String shortStr, String longStr) {
        int shortIdx = 0;
        int longIdx = 0;
        while (shortIdx < shortStr.length() && longIdx < longStr.length()) {
            if (shortStr.charAt(shortIdx) != longStr.charAt(longIdx)) {
                if (shortIdx != longIdx) {
                    return false;
                }
                longIdx++;
            }
            else {
                shortIdx++;
                longIdx++;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println("1. 중복된 문자열 찾기");
        System.out.println(CharArrAndString.isUniqueChars("abcdef"));
        System.out.println(CharArrAndString.isUniqueChars("aabcdef"));
        System.out.println("\n2. 하나 빼기");
        System.out.println(CharArrAndString.oneEditAway("pale", "ple"));
        System.out.println(CharArrAndString.oneEditAway("pales", "pale"));
        System.out.println(CharArrAndString.oneEditAway("pale", "bale"));
        System.out.println(CharArrAndString.oneEditAway("pales", "bake"));


    }
}