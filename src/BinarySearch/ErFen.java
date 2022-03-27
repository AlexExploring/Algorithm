package BinarySearch;

public class ErFen {
    public static void main(String[] args) {
        int [] arr = {0,1,3,7,9,11,16};
        System.out.println(myErfen2(arr,7));
    }

    //二分的基础应用  搜索和目标值相等的数的下标
    public static int myErfen(int [] arr,int target){
        int low = 0;
        int high = arr.length-1;
        while(low <= high){
            //这种写法有时候会产生溢出，即low和high相加的值可能会溢出所以
            /**
             * int mid = low + (high - low)/2;
             * */
            int mid=(low+high)/2;

            if(target==arr[mid]) {
                return mid;
            }
            if(target>arr[mid]) {
                low=mid+1;
            }
            if(target<arr[mid]) {
                high=mid-1;
            }
        }
        return -1;  //没有找到 返回-1;
    }

    //查找第一个不小于目标值的数，并返回该值对应的下标，需要注意目标数并不一定在数组中
    public static int myErfen1(int [] arr,int target){

        int left = 0,right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (arr[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return left>arr.length-1 ? -1:left;
    }

    //查找第一个大于目标值的数，需要注意目标数并不一定在数组中
    public static int myErfen2(int [] arr,int target){

        int left = 0,right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if (arr[mid] <= target){
                left = mid + 1;
            }else {
                right = mid-1;
            }
        }
        return left>(arr.length-1) ? -1:left;
    }
}
