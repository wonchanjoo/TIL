import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String A = st.nextToken();
        String B = st.nextToken();

        int s = 0, e = A.length();
        int min = B.length();
        while(e <= B.length()) {
            int diff = getDiff(A, B.substring(s, e));
            if(diff < min)
                min = diff;
            s++; e++;
        }

        System.out.println(min);
    }

    private static int getDiff(String A, String B) {
        int count = 0;
        for(int i = 0; i < A.length(); i++)
            if(A.charAt(i) != B.charAt(i))
                count++;
        return count;
    }
}