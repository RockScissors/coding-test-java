package programmers.level2;

public class JadenCase문자열만들기 {
    public static class MySolution {
        public String solution(String s) {
            char[] cArr = s.toCharArray();
            for (int i = 0; i < cArr.length; i++) {
                char c = cArr[i];
                if (isNumber(c) || isBlank(c)) continue;
                if (i == 0) {
                    if (isLowerCase(c)) cArr[i] = toUpperCase(c);
                    continue;
                }
                if (isBlank(cArr[i - 1]) && isLowerCase(c)) {
                    cArr[i] = toUpperCase(c);
                }
                if (!isBlank(cArr[i - 1]) && isUpperCase(c)) {
                    cArr[i] = toLowerCase(c);
                }
            }
            return String.valueOf(cArr);
        }
        private boolean isNumber(char c) { return ('0' <= c && c <= '9');}
        private boolean isUpperCase(char c) {return ('A' <= c && c <= 'Z');}
        private char toUpperCase(char c) {return (char) (c + ('A' - 'a'));}
        private boolean isLowerCase(char c) {return ('a' <= c && c <= 'z');}
        private char toLowerCase(char c) {return (char) (c + ('a' - 'A'));}
        private boolean isBlank(char c) {return c == ' ';}
    }

    // Character.toUpperCase , Character.toLowerCase

    // StringBuilder.setCharAt(index, 'X') - index번째 글자 변경
    // StringBuilder.delete(start, end) - 구간 삭제 (end 미포함)
    // StringBuilder.deleteCharAt(index)
    // StringBuilder.setLength(length - 1) - 길이 줄여 뒤 잘라내기
    // StringBuilder - .insert(i, x), reverse(), indexOf(), charAt()

    // String.join(" ", 배열 혹은 리스트)
    // stream.collect(Collectors.joining(" "))

    public static class OptimalSolution {
        public String solution(String s) {
            char[] cArr = s.toCharArray();
            for (int i = 0; i < cArr.length; i++) {
                boolean isWordStart = (i == 0) || cArr[i - 1] == ' ';
                cArr[i] = isWordStart
                        ? Character.toUpperCase(cArr[i])
                        : Character.toLowerCase(cArr[i]);
            }
            return String.valueOf(cArr);
        }
    }
}
