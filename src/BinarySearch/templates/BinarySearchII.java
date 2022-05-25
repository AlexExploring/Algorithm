package BinarySearch.templates;

public class BinarySearchII {

    public static void main(String[] args) {
        //int [] arr = {0,3,5,7,8,13,19,21};
        int [] arr = {1,3,5,6};
        System.out.println(new BinarySearchII().binarySearch(arr,3));
        System.out.println(new BinarySearchII().binarySearch1(arr,5));
        System.out.print(new BinarySearchII().binarySearch2(arr,7));
    }

    public int binarySearch(int[] arr, int target){
        if(arr == null || arr.length == 0) return -1;

        int l = 0, r = arr.length-1;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        //return arr[l] != target ? -1 : l;
        return (l == arr.length-1 && arr[l] != target) ? -1 : l;
    }

    /**
     * 查找arr中第一个不小于目标值的数的下标，需要注意目标数并不一定在数组中
     */
    public int binarySearch1(int [] arr,int target){
        if(arr == null || arr.length == 0) return -1;

        int l = 0,r = arr.length - 1;
        while (l < r){
            int mid = l + (r - l)/2;
            if (arr[mid] < target){
                l = mid + 1;
            }else {
                r = mid;
            }
        }

        return (l == arr.length-1 && arr[l] < target) ? -1 : l;
    }

    /**
     * 查找arr中第一个大于目标值的数的标，需要注意目标数并不一定在数组中
     */
    public int binarySearch2(int [] arr,int target){
        if(arr == null || arr.length == 0) return -1;

        int l = 0,r = arr.length - 1;
        while (l < r){
            int mid = l + (r - l)/2;
            if (arr[mid] <= target){
                l = mid + 1;
            }else {
                r = mid;
            }
        }

        return (l == arr.length-1 && arr[l] <= target) ? -1 : l;
    }
}
