package programmers.level1;

public class 동영상재생기 {
    public static class MySolution {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            int afterPos = toSeconds(pos);

            int videoLen = toSeconds(video_len);
            int opStart = toSeconds(op_start);
            int opEnd = toSeconds(op_end);
            int position = toSeconds(pos);

            afterPos = skipOp(opStart, opEnd, position);
            for (String c : commands) {
                if (c.equals("prev")) {
                    afterPos = afterPos - 10 < 0
                            ? 0 : afterPos - 10;
                } else if (c.equals("next")) {
                    afterPos = afterPos + 10 > videoLen
                            ? videoLen : afterPos + 10;
                }
                afterPos = skipOp(opStart, opEnd, afterPos);
            }

            return toString(afterPos);
        }

        private int toSeconds(String s) {
            String[] arr = s.split(":");
            return Integer.valueOf(arr[0]) * 60
                    + Integer.valueOf(arr[1]);
        }

        private String toString(int s) {
            int min = s / 60;
            int sec = s % 60;
            String minutes = min < 10? "0" + min : "" + min;
            String seconds = sec < 10? "0" + sec : "" + sec;
            return minutes + ":" + seconds;
        }

        private int skipOp(int op_start, int op_end, int pos) {
            if (op_start <= pos && pos <= op_end) {
                return op_end;
            }
            return pos;
        }
    }

    // Integer.valueOf는 Integer 객체 반환
    // Integer.parseInt는 int 프리미티브 타입 반환
    // Math.max(x - 10, 0), Math.min(x + 10, limit) -> 범위 밖으로 나가지 않게 자르기ㅣ
    // 변수, 메소드 네이밍 명확하게
    // String.format("%02d:%02d", m, s) -> 두 자리 0 채우기

    public static class OptimalSolution {
        public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
            int videoLenSec = toSeconds(video_len);
            int opStartSec = toSeconds(op_start);
            int opEndSec = toSeconds(op_end);
            int posSec = toSeconds(pos);

            posSec = skipOpening(posSec, opStartSec, opEndSec);
            for (String command : commands) {
                if (command.equals("prev")) {
                    posSec = Math.max(posSec - 10, 0);
                } else if (command.equals("next")) {
                    posSec = Math.min(posSec+ 10, videoLenSec);
                }
                posSec = skipOpening(posSec, opStartSec, opEndSec);
            }
            return toTimeString(posSec);
        }

        private int toSeconds(String time) {
            String[] parts = time.split(":");
            return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }

        private String toTimeString(int totalSec) {
            return String.format("%02d:%02d", totalSec / 60, totalSec % 60);
        }

        private int skipOpening(int posSec, int opStartSec, int opEndSec) {
            if (opStartSec <= posSec && posSec <= opEndSec) return opEndSec;
            return posSec;
        }
    }
}
