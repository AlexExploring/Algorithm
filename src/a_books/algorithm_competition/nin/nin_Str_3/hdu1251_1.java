package a_books.algorithm_competition.nin.nin_Str_3;

import java.util.Scanner;

/**
 *���ֵ���ʵ��
 *
 * ������ʵ���ֵ���
 */
public class hdu1251_1 {
    /**
     * @param pos ���յĴ�С��������ַ����ĳ��ȼ�1
     * @param trieTree[0] �������еĸ��ڵ�
     * @param num ��ĳһ�ַ���Ϊǰ׺�ĵ�������
     */
    static int [][] trieTree = new int[1000010][26]; //�����鶨���ֵ������洢��һ���ַ���λ��
    static int [] num = new int[1000010];  //��ĳһ�ַ���Ϊǰ׺�ĵ�������
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
