
package DP;

import java.util.Scanner;
//车从i站能开到i+1。
//
//所有站里的油总量要>=车子的总耗油量。
//
//那么，假设从编号为0站开始，一直到k站都正常，在开往k+1站时车子没油了。这时，应该将起点设置为k+1站。
public class LC134_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] gas = {1,2,3,4,5};
        int [] cost = {3,4,5,1,2};

        System.out.println(find(gas,cost));
    }

    public static int find(int [] gas,int [] cost){
        int rest = 0, run = 0, start = 0;
        for (int i = 0; i < gas.length; ++i){
            run += (gas[i] - cost[i]);
            rest += (gas[i] - cost[i]);
            if (run < 0){
                start = i + 1;
                run = 0;
            }
        }
        return rest < 0 ? -1: start;
    }

}
