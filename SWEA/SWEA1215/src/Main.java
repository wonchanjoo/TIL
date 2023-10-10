import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static char[][] board;
    static int length; // 회문의 길이
    static List<String> palindrome;

    // 0: 세로 / 1: 가로
    static int[] dirR = {1, 0};
    static int[] dirC = {0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            board = new char[8][8];
            length = Integer.parseInt(br.readLine());
            palindrome = new ArrayList<>();

            for (int r = 0; r < 8; r++) {
                String s = br.readLine();
                for (int c = 0; c < 8; c++) {
                    board[r][c] = s.charAt(c);
                }
            }

            // (0, 0)은 따로 계산
            String s1 = ""; // 세로
            String s2 = ""; // 가로
            for (int i = 0; i < length; i++) {
                s1 += board[i][0];
                s2 += board[0][i];
            }
            dfs(new Point(length - 1, 0), s1, 0);
            dfs(new Point(0, length - 1), s2, 1);

            // 나머지
            for (int i = 1; i < 8; i++) {
                s1 = s2 = "";

                for (int j = 0; j < length; j++) {
                    s1 += board[j][i];
                    s2 += board[i][j];
                }

                dfs(new Point(length - 1, i), s1, 0);
                dfs(new Point(i, length - 1), s2, 1);
            }

            sb.append('#').append(t).append(' ').append(palindrome.size()).append('\n');
        }

        System.out.println(sb);
    }

    private static void dfs(Point end, String s, int d) {
        if (isPalindrome(s)) {
            palindrome.add(s);
        }

        // 문장 끝나는 지점 이동
        end.move(d);
        if (!rangeIn(end)) {
            return;
        }

        // 새로운 문장 만들기
        s = s.substring(1) + board[end.r][end.c];
        dfs(end, s, d);
    }

    private static boolean rangeIn(Point p) {
        return (p.r >= 0) && (p.c >= 0) && (p.r < 8) && (p.c < 8);
    }

    private static boolean isPalindrome(String s) {
        boolean palindrome = true;
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                palindrome = false;
                break;
            }

            start++;
            end--;
        }


        return palindrome;
    }

    static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        private void move(int direction) {
            this.r += dirR[direction];
            this.c += dirC[direction];
        }
    }

}