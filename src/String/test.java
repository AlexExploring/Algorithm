package String;

import java.util.HashSet;

public class test {
    public static void main(String[] args) {
        String s = " ";

        System.out.println(s.length());

        HashSet<Character> set = new HashSet<>();

        set.add(s.charAt(0));
        System.out.println("set.size:"+set.size());
    }
}
