package internWeek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class ProblemD {
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

    public static Map<Integer, ArrayList<Integer>> getMap(FastScanner fs, int n) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int day = fs.nextInt(), sidewalk = fs.nextInt();
            if (!map.containsKey(sidewalk)) {
                map.put(sidewalk, new ArrayList<>());
            }
            map.get(sidewalk).add(day);
        }
        return map;
    }

    public static void main(String[] args) {
        FastScanner fs = new FastScanner(System.in);
        fs.nextInt();

        int n = fs.nextInt(), m = fs.nextInt();

        Map<Integer, ArrayList<Integer>> map = getMap(fs, n);

        int count = map.keySet().size();
        long res = (count <= m) ? 0L : -1L;

        if (m != n) {
            ArrayList<Integer> lenArray = new ArrayList<>();
            for (ArrayList<Integer> list : map.values()) {
                res += list.get(list.size() - 1) - list.get(0);
                if (count < m) {
                    for (int i = 1; i < list.size(); i++) {
                        lenArray.add(list.get(i) - list.get(i - 1));
                    }
                }
            }

            Collections.sort(lenArray, Collections.reverseOrder());
            for (int i = 0; i < m - count; i++) {
                res -= lenArray.get(i);
            }
        }

        System.out.print(res );
    }
}
