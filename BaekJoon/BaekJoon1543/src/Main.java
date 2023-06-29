import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();
        int count = 0;

        while(doc.contains(word)) {
            int i = doc.indexOf(word);
            doc = doc.substring(i + word.length());
            count++;
        }

        System.out.println(count);
    }
}