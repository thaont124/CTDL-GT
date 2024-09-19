import java.util.Scanner;

public class BieuThucToanHoc {
    static int[] a;
    static int[] arr;
    static boolean ok;
    static boolean[] dd;
    static char[] operations = { '+', '-', '*' };
    static char[] ops;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            ok = false;
            a = new int[5];
            arr = new int[5];
            dd = new boolean[5];
            ops = new char[4];
            for (int i = 0; i < 5; i++) {
                a[i] = scanner.nextInt();
            }

            backTrack(0);

            System.out.println(ok);
        }

    }

    private static void backTrack(int i) {
        // System.out.println(Arrays.toString(arr));
        if (ok) {
            return;
        }
        if (i == 5) {
            for (int o = 0; o < 3; o++) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            ops[0] = operations[o];
                            ops[1] = operations[j];
                            ops[2] = operations[k];
                            ops[3] = operations[l];
                            if (calculate() == 23) {
                                ok = true;
                            }
                        }
                    }
                }
            }
            return;
        }
        for (int j = 0; j < 5; j++) {
            if (!dd[j]) {
                dd[j] = true;
                arr[i] = a[j];
                backTrack(i + 1);
                dd[j] = false;
            }
        }
    }

    private static int calculate() {
        int result = arr[0];
        for (int i = 0; i < 4; i++) {
            switch (ops[i]) {
                case '+' -> result += arr[i + 1];
                case '-' -> result -= arr[i + 1];
                case '*' -> result *= arr[i + 1];
            }
        }
        return result;
    }
}
/*
 * 3
 * 1 1 1 1 1
 * 1 2 3 4 5
 * 2 3 5 7 11
 */