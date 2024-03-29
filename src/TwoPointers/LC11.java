package TwoPointers;

/**
 * 盛水最多的容器
 */
public class LC11 {

    /**
     * 正确性证明：
     * 若暴力枚举，水槽两板围成面积S(i,j) 的状态总数为 C(n,2) 。
     *
     * 假设状态 S(i,j) 下 h[i]<h[j] ，在向内移动短板至 S(i+1,j) ，则相当于消去了 {S(i, j - 1), S(i, j - 2), ... , S(i, i + 1)}
     * 状态集合。而所有消去状态的面积一定都小于当前面积（即 < S(i, j)<S(i,j)），因为这些状态：
     *
     * 短板高度：相比S(i,j) 相同或更短（即 ≤h[i] ）；
     * 底边宽度：相比S(i,j) 更短；
     * 因此，每轮向内移动短板，所有消去的状态都 不会导致面积最大值丢失 ，证毕。
     */
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, ans = 0;

        //不断向内移动短板，直到两短板相遇
        while(l < r) {
            ans = height[l] <= height[r] ?
                    Math.max(ans, (r - l) * height[l++]):
                    Math.max(ans, (r - l) * height[r--]);
        }

        return ans;
    }
}