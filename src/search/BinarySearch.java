package search;

public class BinarySearch {

    int binarySearch(int[] arr, int low, int high, int x) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            if (arr[mid] > x) {
                return binarySearch(arr, low, mid - 1, x);
            }
            return binarySearch(arr, mid + 1, high, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();

        int[] arr = new int[]{2, 5, 8, 10, 15, 20, 30};
        int high = arr.length - 1;
        int result = bs.binarySearch(arr, 0, high, 8);
        if (result == -1) {
            System.out.println("Element not found");
        }else{
            System.out.println("Element found at index " + result);
        }
    }
}
