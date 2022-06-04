package array.matrix;

/**
 * ÂİĞı¾ØÕóII
 */
public class LC59 {

    public int[][] generateMatrix(int n) {

        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int [][] ans = new int[n][n];
        int cur = 1,tar = n * n;

        while (cur <= tar) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = cur++;
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans[i][right] = cur++;
            }
            right--;

            for (int i = right; i >= left; i--) {
                ans[bottom][i] = cur++;
            }
            bottom--;

            for (int i = bottom; i >= top; i--) {
                ans[i][left] = cur++;
            }
            left++;
        }

        return ans;
    }
}
