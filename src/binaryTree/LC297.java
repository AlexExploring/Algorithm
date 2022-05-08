package binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的序列化与反序列化
 */
public class LC297 {

}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return reSerialize(root,"");
    }

    public String reSerialize(TreeNode root,String str) {
        if (root == null) str += "null,";
        else {
            str += root.val + ",";
            str = reSerialize(root.left,str);
            str = reSerialize(root.right,str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return reDeserialize(dataList);
    }

    public TreeNode reDeserialize(List<String> dataList) {
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }

        TreeNode curRoot = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        curRoot.left = reDeserialize(dataList);
        curRoot.right = reDeserialize(dataList);

        return curRoot;
    }
}

