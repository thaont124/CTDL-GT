import java.util.Scanner;

public class CapNghichThe {
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            cnt = 0;
            int n = sc.nextInt();
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }
            a = mergeSort(a, n);
            System.out.println(cnt);
        }
    }

    private static long[] mergeSort(long[] a, int n) {
        if (n <= 1) {
            return a;
        }
        int half = a.length / 2;

        long[] left = new long[half];
        long[] right = new long[n - half];

        for (int k = 0; k < half; k++) {
            left[k] = a[k];
        }
        for (int k = 0; k < n - half; k++) {
            right[k] = a[half + k];
        }
        // System.out.println(Arrays.toString(left) + " " + Arrays.toString(right));

        left = mergeSort(left, half);
        right = mergeSort(right, n - half);

        return merge(left, right);
    }

    private static long[] merge(long[] left, long[] right) {
        int i = 0;
        int j = 0;
        int index = 0;
        long[] result = new long[left.length + right.length];

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[index++] = left[i++];
            } else {
                result[index++] = right[j++];
                cnt += (left.length - i);
            }
        }
        while (i < left.length) {
            result[index++] = left[i++];
        }
        while (j < right.length) {
            result[index++] = right[j++];
        }
        // System.out.println("merge: " + Arrays.toString(result) + " " + cnt);
        return result;
    }
}