package BinarySearch.templates;

public class BinarySearchII {

    public int binarySearch(int[] arr, int target){
        if(arr == null || arr.length == 0) return -1;

        int l = 0, r = arr.length;
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

        // Post-processing:
        // End Condition: l == r
        if(l != arr.length && arr[l] == target) return l;
        return -1;
    }
}
