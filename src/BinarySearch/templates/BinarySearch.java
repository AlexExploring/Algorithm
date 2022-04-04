package BinarySearch.templates;

public class BinarySearch {
    public static void main(String[] args) {
        int [] arr = {0,3,5,7,8,13,19,21};
        System.out.println(myErfen(arr,5));
        System.out.println(myErfen1(arr,8));
        System.out.print(myErfen2(arr,8));
    }

    //二分的基础应用  搜索和目标值相等的数的下标
    public static int myErfen(int [] arr,int target){
        int left = 0,right = arr.length-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(target==arr[mid]) {
                return mid;
            }else if(target>arr[mid]) {
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        //没找到返回-1
        return -1;
    }

    //查找arr中第一个不小于目标值的数的下标，需要注意目标数并不一定在数组中
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

    //查找arr中第一个大于目标值的数的标，需要注意目标数并不一定在数组中
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

