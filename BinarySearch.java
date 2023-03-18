public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 13, 23, 79, 81, 183, 137, 139};
        System.out.println(binarySearch(arr, 79));
    }

    public static int binarySearch(int[] arr, int number) {
        //定义两个变量记录要查找的范围
        int min = 0;
        int max = arr.length - 1;
        //利用循环不断的去找要查找的数据
        while (true) {
            if (min > max) {
                return -1;
            }
            //找到min和max的中间位置
            int mid = (min + max) / 2;
            //拿着min指向的元素跟要查找的元素进行比较
            //number跟mid指向的元素一样
            if (arr[mid] > number) {
                //number在mid的左边
                //min不变 max=mid-1
                max = mid - 1;
            } else if (arr[mid] < number) {
                //number在mid的右边
                //min不变 max=mid+1
                min = mid + 1;
            } else if (arr[mid] == number) {
                //number跟mid指向的值一样
                return mid;
            }
        }
    }
}
