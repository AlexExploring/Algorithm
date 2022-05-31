package BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * ¸ñÀ×±àÂë
 */
public class LC89 {

    public static void main(String[] args) {

    }

    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < 1<<n; ++i)
            ret.add(i ^ i>>1);
        return ret;
    }
}
