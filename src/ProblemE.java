import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class ProblemE {
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    static class Student {
        static int[] places;
        int rating;
        int[] wishedPrograms;
        int program;

        Student(FastScanner fs) {
            rating = fs.nextInt();
            program = -1;

            int count = fs.nextInt();
            wishedPrograms = new int[count];
            for (int i = 0; i < count; i++) {
                wishedPrograms[i] = fs.nextInt();
            }
        }

        public void distribute() {
            for (int program : wishedPrograms) {
                if (places[program] > 0) {
                    this.program = program;
                    places[program]--;
                    break;
                }
            }
        }

        public int getRating() {
            return rating;
        }
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt(), k = fs.nextInt();

        int[] places = new int[k + 1];
        for (int i = 1; i <= k; i++) {
            places[i] = fs.nextInt();
        }

        Student.places = places;
        Student[] allStudents = new Student[n];
        for (int i = 0; i < n; i++) allStudents[i] = new Student(fs);

        Student[] sortedStudents = Arrays.stream(allStudents)
                .sorted(Comparator.comparing(Student::getRating))
                .toArray(Student[]::new);

        for (Student student : sortedStudents) student.distribute();

        StringBuilder sb = new StringBuilder();
        Arrays.stream(allStudents).forEach(it -> sb.append(it.program).append(' '));

        System.out.print(sb);
    }
}
