package DP;

import java.util.Scanner;

//有一个环形路上有n个站点； 每个站点都有一个好人或一个坏人； 好人会给你钱，坏人会收你一定的过路费，
// 如果你带的钱不够付过路费，坏人会跳起来把你砍死； 问：从哪个站点出发，能绕一圈活着回到出发点?
//首先考虑一种情况：如果全部好人给你 的钱加起来 小于 坏人收的过路费之和，那么总有一次你的钱不够付
// 过路费，你的结局注定会被砍死。
//假如你随机选一点 start 出发，那么你肯定会选一个有好人的站点开始，因为开始的时候你没有钱，遇到坏人只能被砍死；
//现在你在start出发，走到了某个站点end，被end站点的坏人砍死了，说明你在 [start, end) 存的钱不够付
// end点坏人的过路费，因为start站点是个好人，所以在 (start, end) 里任何一点出发，你存的钱会比现在
// 还少，还是会被end站点的坏人砍死；
//于是你重新读档，聪明的选择从 end+1点出发，继续你悲壮的征程； 终于有一天，你发现自己走到了尽头（下标
// 是n-1)的站点而没有被砍死； 此时你犹豫了一下，那我继续往前走，身上的钱够不够你继续走到出发点Start?
//当然可以，因为开始已经判断过，好人给你的钱数是大于等于坏人要的过路费的，你现在攒的钱完全可以应付 [0, start)
// 这一段坏人向你收的过路费。 这时候你的嘴角微微上扬，眼眶微微湿润，因为你已经知道这个世界的终极奥秘：Start就是这个问题的答案。
public class LC134_LS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] gas = {1,2,3,4,5};
        int [] cost = {3,4,5,1,2};

        int [] gas1 = {2,3,4};
        int [] cost1 = {3,4,5};
        System.out.println(find(gas,cost));
        System.out.println(find(gas1,cost1));
    }

    public static int find(int [] gas,int [] cost){
        int n = gas.length;
        int[] res = new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            res[i] = gas[i] - cost[i];
            sum+=res[i];
        }

        if (sum < 0) return -1;
        int start=0,all_money=0;
        for (int i = 0; i < n; i++) {
            all_money += res[i];
            if (all_money < 0){
                all_money=0;
                start = i+1;
            }
        }
        if (start < n)
            return start;
        else return -1;
    }
}
