import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        String answer = "long ";
        if (N % 4 == 0) {
            answer = answer.repeat(N / 4);
        } else {
            answer = answer.repeat(N / 4 + 1);
        }

        System.out.println(answer + "int");
    }
}