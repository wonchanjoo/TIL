import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), "*");
        String head = st.nextToken();
        String tail = st.nextToken();

        for(int i = 0; i < N; i++) {
            String file = br.readLine();
            if(file.length() < (head + tail).length()) {
                sb.append("NE").append('\n');
                continue;
            }
            if (file.startsWith(head) && file.endsWith(tail)) {
                sb.append("DA").append('\n');
            } else {
                sb.append("NE").append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
