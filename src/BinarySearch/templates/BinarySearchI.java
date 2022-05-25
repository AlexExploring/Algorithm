package BinarySearch.templates;

/**
 * 该模板适合查找在所有元素均不相同的数组中查找某特定元素。
 */
public class BinarySearchI {

    public static void main(String[] args) {
        //int [] arr = {0,3,5,7,8,13,19,21};
        int [] arr = {1,3,5,6};
        System.out.println(new BinarySearchI().binarySearch(arr,7));
        System.out.println(new BinarySearchI().binarySearch1(arr,7));
        System.out.print(new BinarySearchI().binarySearch2(arr,7));
    }

    /**
     * 二分的基础应用  搜索和目标值相等的数的下标 , 没找到则返回-1
     */
    public int binarySearch(int [] arr,int target){
        if(arr == null || arr.length == 0) return -1;

        int l = 0,r = arr.length-1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(target==arr[mid]) {
                return mid;
            }else if(target>arr[mid]) {
                l=mid+1;
            }else{
                r=mid-1;
            }
        }

        return -1;
    }

    /**
     * 查找arr中第一个不小于目标值的数的下标，需要注意目标数并不一定在数组中
     */
    public int binarySearch1(int [] arr,int target){
        if(arr == null || arr.length == 0) return -1;

        int l = 0,r = arr.length - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (arr[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l > arr.length-1 ? -1 : l;
    }

    /**
     * 查找arr中第一个大于目标值的数的标，需要注意目标数并不一定在数组中
     */
    public int binarySearch2(int [] arr,int target){
        if(arr == null || arr.length == 0) return -1;

        int l = 0,r = arr.length - 1;
        while (l <= r){
            int mid = l + (r - l)/2;
            if (arr[mid] <= target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return l > (arr.length-1) ? -1 : l;
    }
}

