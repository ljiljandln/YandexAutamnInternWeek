import java.util.Scanner;

public class ProblemA {

    public static final int FOUR = 4;

    static long nextLong(Scanner sc) {
        return Long.parseLong(sc.nextLine());
    }

    static int nextInt(Scanner sc) {
        return Integer.parseInt(sc.nextLine());
    }

    static long getSum1(long m, int c2) {
        return (m - 1) * c2;
    }

    static long getSum2(long m, int c5) {
        return ((m + FOUR) / FOUR) * c5;
    }

    static long getSum3(long m, int c2, int c5) {
        return (m / FOUR) * c5 + (m % FOUR - 1) * c2;
    }

    static long getMinSum(long m, int c2, int c5) {
        long sum1 = getSum1(m, c2);
        long sum2 = getSum2(m, c5);
        long sum3 = getSum3(m, c2, c5);
        return Math.min(sum1, Math.max(sum2, sum3));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = nextLong(sc), m = nextLong(sc);
        int c2 = nextInt(sc), c5 = nextInt(sc);

        long sum = 0L;
        if (m > n) {
            m -= n - 1;
            sum = getMinSum(m, c2, c5);
        }
        System.out.print(sum);
    }
}
