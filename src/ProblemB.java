package internWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemB {

    static int[] getArray(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nAndK = getArray(br);
        int n = nAndK[0];
        int k = nAndK[1];

        int[] arr = getArray(br);
        Arrays.sort(arr);

        int min = arr[n - 1] - arr[0];
        for (int i = 0; i <= k; i++) {
            int curr = arr[n + i - k - 1] - arr[i];
            min = Math.min(min, curr);
        }
        System.out.print(min);
    }
}
