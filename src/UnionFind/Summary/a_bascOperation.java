package UnionFind.Summary;

/**
 *https://blog.csdn.net/weixin_43914593/article/details/104108049
 */
public class a_bascOperation {
    static int maxn = 1050;
    static int s[] = new int[maxn];
    //1
    public static void init(){//��ʼ�� ���鼯
        for(int i = 1; i <= maxn; i++)
            s[i] = i;
    }
    public static int find(int x){  //����
        return x==s[x]? x:find(s[x]);
    }

    public static void merge(int x, int y){//�ϲ�
        x = find(x);
        y = find(y);
        if(x != y) s[x] = s[y];     //��x�ϲ���y�ϣ�y�ĸ���Ϊx�ĸ�
    }

    //2
    static int [] height = new int[maxn];
    public static void init1(){//��ʼ�� ���鼯
        for(int i = 1; i <= maxn; i++)
            s[i] = i;
    }

    //������Ĳ�ѯ����find_set()�У���ѯԪ��i�����ļ�����Ҫ����·���ҵ�
    // ����㣬���صĽ���Ǹ���㡣��������·�����ܺܳ�������ڷ��ص�ʱ��
    // ˳���i�����ļ��ĳɸ���㣬��ô�´����ѵ�ʱ�򣬾�����O(1)��ʱ���ڵõ������
    public static int find1(int x){
        if(x != s[x])
            s[x] = find1(s[x]);   //·��ѹ��
        return s[x];
    }

    //������õݹ�ʵ�֣�������ݹ�ģ̫�󣬵��ı�ջ������������ķǵݹ���룺
    public static int find1_1(int x){
        int r = x;
        while ( s[r] != r ) r=s[r];  //�ҵ������
        int i = x, j;
        while(i != r){
            j = s[i];     //����ʱ����j��¼
            s[i]= r ;     //��·����Ԫ�صļ���Ϊ�����
            i = j;
        }
        return r;
    }

    //�ϲ�Ԫ��x��yʱ�����ѵ����ǵĸ���㣬
    // Ȼ���ٺϲ�����������㣬����һ�������ļ�
    // �ĳ���һ������㡣�����������ĸ߶Ȳ�ͬ������Ѹ߶Ƚ�С�ļ��ϲ�
    // ���ϴ�ļ��ϣ��ܼ������ĸ߶ȡ��������Ż���Ĵ��룬�ڳ�ʼ��ʱ��height[i]��
    // ��Ԫ��i�ĸ߶ȣ��ںϲ�ʱ���ġ�
    public static void merge1(int x,int y){
        x = find1(x);
        y = find1(y);
        if (height[x] == height[y]) {
            height[x] = height[x] + 1;      //�ϲ������ĸ߶ȼ�һ
            s[y] = x;
        }
        else{                            //�Ѱ������������ϣ������ĸ߶ȱ��ֲ���
            if (height[x] < height[y])  s[x] = y;
            else   s[y] = x;
        }
    }

    //3.��Ȩ���鼯
    //����������뵽���������ݽṹ���ᷢ�֣����鼯ʵ��������ά�����ɿ��������鼯�ĺϲ��Ͳ�ѯ
    // �Ż���ʵ�������ڸı�������״����ԭ����ϸ�����ġ�������Ч�Ĵ�����С����������ˡ��ֶ̡���
    // ��������Ч���������������������ԭ���ġ�С�����ϣ���֮����Ȩֵ����ô�������鼯���Ż�֮��
    // �ɡ�����������ЩȨֵ�Ĳ���Ҳ��ø�Ч�ˡ�
    static int [] d = new int[1050];//Ȩֵ����
    //��Ȩֵ��·��ѹ��
    public static int find3(int x){
        if(x != s[x]) {
            int t = s[x];            //��¼�����
            s[x] = find3(s[x]);   //·��ѹ�����ݹ���󷵻ص��Ǹ����
            d[x] += d[t];            //Ȩֵ����Ϊx�����ڵ��Ȩֵ
        }
        return s[x];
    }
    //ע������е�ϸ�ڡ�ԭ����d[x]�ǵ�x�����ĸ�����Ȩֵ������·��ѹ����xֱ��ָ�����
    // �㣬d[x]Ҳ����Ϊx��������Ȩֵ������ͨ���ݹ�ʵ�ֵġ�

    //��Ȩֵ�ĺϲ�
    //�ںϲ������У��ѵ�x�뵽��y�ϲ������ǰ�x�ĸ����fx�ϲ���y�ĸ����fy����fx��fy֮������Ȩֵ�����ȨֵҪ������Ŀ��Ҫ��

}
