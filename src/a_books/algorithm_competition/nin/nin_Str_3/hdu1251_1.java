package a_books.algorithm_competition.nin.nin_Str_3;

import java.util.Scanner;

/**
 *用字典树实现
 *
 * 用数组实现字典树
 */
public class hdu1251_1 {
    /**
     * @param pos 最终的大小代表最长的字符串的长度减1
     * @param trieTree[0] 代表树中的根节点
     * @param num 以某一字符串为前缀的单词数量
     */
    static int [][] trieTree = new int[1000010][26]; //用数组定义字典树，存储下一个字符的位置
    static int [] num = new int[1000010];  //以某一字符串为前缀的单词数量
    static int pos = 1;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String [] data = {"banana","band","bee","absolute","acm"};
        for (int i = 0; i < data.length; i++) {
            insert(data[i]);
        }
        while (scan.hasNext()){
            System.out.println(Find(scan.next()));
        }
    }

    public static void insert(String str){
        int p = 0;
        char [] letters = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            int n = letters[i]-'a';
            if (trieTree[p][n] == 0){
                trieTree[p][n] = pos++;
            }
            p = trieTree[p][n];
            num[p]++;
        }
    }

    public static int Find(String str){
        int p = 0;
        char [] letters = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            int n = letters[i]-'a';
            if (trieTree[p][n]==0){
                return 0;
            }
            p = trieTree[p][n];
        }
        return num[p];
    }
}
