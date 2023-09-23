import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    public static void main(String[] args) {
        double[] arr = {0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51};
        int n = arr.length;
        List<Double>[] buckets = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            int index = (int) (n * arr[i]);
            if (buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (buckets[i] != null) {
                Collections.sort(buckets[i]);
            }
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            if (buckets[i] != null) {
                for (double num : buckets[i]) {
                    arr[index++] = num;
                }
            }
        }

        for (double num : arr) {
            System.out.print(num + " ");
        }
    }
}
