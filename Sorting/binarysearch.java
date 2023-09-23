public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 9};
        int target = 5;
        int n = arr.length;
        int foundIndex = -1;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                foundIndex = mid;
                break;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (foundIndex != -1) {
            System.out.println("Element found at index " + foundIndex);
        } else {
            System.out.println("Element not found.");
        }
    }
}
