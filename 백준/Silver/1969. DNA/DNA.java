import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] count = new int[4][M]; // A C G R
        String[] DNA = new String[N];
        for(int i = 0; i < N; i++) {
            String dna = br.readLine();
            DNA[i] = dna;
            for(int j = 0; j < M; j++) {
                switch (dna.charAt(j)) {
                    case 'A' -> count[0][j]++;
                    case 'C' -> count[1][j]++;
                    case 'G' -> count[2][j]++;
                    case 'T' -> count[3][j]++;
                }
            }
        }

        StringBuilder s = new StringBuilder();
        for(int c = 0; c < M; c++) {
            int maxRow = 0;
            for(int r = 1; r < 4; r++) {
                if(count[r][c] > count[maxRow][c])
                    maxRow = r;
                else if(count[r][c] == count[maxRow][c])
                    maxRow = Math.min(r, maxRow);
            }
            switch (maxRow) {
                case 0 -> s.append("A");
                case 1 -> s.append("C");
                case 2 -> s.append("G");
                case 3 -> s.append("T");
            }
        }

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += getHammingDistance(DNA[i], s.toString());
        }

        System.out.println(s);
        System.out.println(sum);
    }

    private static int getHammingDistance(String A, String B) {
        int count = 0;
        for(int i = 0; i < A.length(); i++)
            if(A.charAt(i) != B.charAt(i))
                count++;
        return count;
    }
}