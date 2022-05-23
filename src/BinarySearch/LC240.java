package BinarySearch;

/**
 *������ά����II
 */
public class LC240 {

    /**
     * ��ÿһ��ʹ�ö��ֲ���
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            int index = search(row, target);
            if (index >= 0) {
                return true;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int num = nums[mid];
            if (num == target) {
                return mid;
            } else if (num > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * ��ϸ����Ķ�ά������ص㣬��Ч����
     *
     * ��LC240.png
     */
    public static boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int row = 0;
        //һ��Ҫ�����ұߵ�һ�п�ʼ
        int column = matrix[0].length - 1;
        while (row < matrix.length && column >= 0) {
            if (matrix[row][column] == target) {
                return true;
            }
            if (matrix[row][column] > target) {
                column--;
            } else {
                row++;
            }
        }

        return false;
    }

    /**
     * ��ϸĶ�ά������ص㣬�����Ͻǿ�ʼ����,�ͱ���һ�Ŷ���������һ�� (��searchMatrix1�Ľⷨ���𲻴�)
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int i = matrix.length - 1, j = 0;
        while(i >= 0 && j < matrix[0].length) {
            if(matrix[i][j] > target) i--;
            else if(matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}
