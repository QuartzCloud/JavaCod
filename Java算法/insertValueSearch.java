public class insertValueSearch {
    public static void main(String[] args) {
        int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22};
        System.out.println(insertValueSearch(arr, 13));
    }

    public static int insertValueSearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (true) {
            if (low > high || key > arr[high] || key < arr[low]) {
                return -1;
            }
            int mid = low + (key - arr[low]) * (high - low) / (arr[high] - arr[low]);
            int midVal = arr[mid];
            //key在mid对应的值的左边的
            if (midVal > key) {
                high = mid - 1;
            } else if (midVal < key) {
                low = mid + 1;
            } else if (midVal == key) {
                return mid;
            }
        }
    }
}
