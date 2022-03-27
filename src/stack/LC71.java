package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *刷题总结：
 * 不要陷入无休止的if...else条件判断，以防陷入思维误区。
 * 解题时要尽量简化，找到关键逻辑，。。。。。。
 *
 * 这里是将题目进行了拆分，分为了好几部分
 */

public class LC71 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(simplifyPath1(s));
    }

    public static String simplifyPath(String path) {
        //如果路径为空,直接返回"/"
        if (path == null || path.length() == 0) {
            return "/";
        }
        int len = path.length();
        List<String> names = new ArrayList<>();
        //获取每个目录名称
        for (int i = 0; i < len; i++) {
            if (path.charAt(i) != '/') {
                int j = i;
                while (j < len && path.charAt(j) != '/') {
                    j++;
                }
                names.add(path.substring(i, j));
                i = j;
            }
        }
        List<String> res = new ArrayList<>();
        //构造路径
        for (int i = 0; i < names.size(); i++) {
            //如果目录名称为"..",需要特殊判断
            if (names.get(i).equals("..")) {
                //如果此时路径还有目录,则返回上一级;否则,忽略它
                if (res.size() > 0)
                    res.remove(res.size() - 1);
            } else if (!names.get(i).equals(".")) {
                //如果目录名称不为"."(即当前目录),则加入路径
                res.add(names.get(i));
            }
            //如果上述情况都没匹配到,则说明该目录名称为"."(即当前目录),直接忽略
        }
        return "/" + String.join("/", res);
    }

    public static String simplifyPath1(String path){
        //如果路径为空,直接返回"/"
        if (path == null || path.length() == 0) {
            return "/";
        }

        String [] names = path.split("/");
        List<String> res = new ArrayList();
        System.out.println(Arrays.toString(names));

        for (int i = 1; i < names.length; i++) {
            //如果目录名称为"..",需要特殊判断
            if (names[i].equals("..")) {
                //如果此时路径还有目录,则返回上一级;否则,忽略它
                if (res.size() > 0)
                    res.remove(res.size() - 1);
            } else if (!names[i].equals(".")) {
                //如果目录名称不为"."(即当前目录),则加入路径
                res.add(names[i]);
            }
            //如果上述情况都没匹配到,则说明该目录名称为"."(即当前目录),直接忽略
        }
        System.out.println(res);
        return "/"+String.join("/",res);
    }

    // 简化方法：. => 指向当前目录本身; .. => 切换到上一级目录; 最后一个目录不可以是 / 结尾
    // 两个目录直接只能由一个 / 连接
    // 1. 遇到的字符为".", 则直接跳过到达下一个字符
    // 2. 遇到的字符为"..", 则回到上一个目录, 即从栈中删除一个元素
    // 3. 遇到的字符为"", 则直接跳过
    // 4. 遇到字符为目录, 则入栈
    public String simplifyPath2(String path) {

        // 将path分割, 按照 / 分割：/home//foo/ => ["", "home", "", "foo"]
        String[] subPaths = path.split("/");

        // 新建一个栈
        String[] stack = new String[subPaths.length];
        int top = -1;

        for (int i = 0; i < subPaths.length; i++) {
            if (".".equals(subPaths[i])) {
                continue;
            }
            if ("..".equals(subPaths[i])) {
                // 栈不为空才进行出栈元素
                if (top != -1)
                    top--;
                continue;
            }
            // 栈为空/为目录字符
            if (!"".equals(subPaths[i])) {
                stack[++top] = subPaths[i];
            }
        }

        if (top == -1)
            return "/";

        // 构造结果
        StringBuilder sb = new StringBuilder();
        while (top >= 0) {
            sb.insert(0, stack[top--]);
            sb.insert(0, "/");
        }

        return sb.toString();
    }
}
