/*
N개의 숫자가 공백 없이 써 있다. 이 숫자를 모두 합해 출력하는 프로그램을 작성하시오
입력: 1번째 줄에 숫자의 개수 N(1 <= N <= 100), 2번째 줄에 숫자 N개가 공백 없이 주어진다
출력: 입력으로 주어진 숫자 N개의 합을 출력한다.
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. 문자열 형태로 입력값을 받는다.
        // 2. 이를 문자 배열로 변환하고, 문자 배열값을 순서대로 읽으면서 숫자형으로 변환해 다시 더한다.

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String sNum = sc.next();
        char[] cNum = sNum.toCharArray();

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += cNum[i] - '0';
        }

        System.out.println(sum);
    }
}