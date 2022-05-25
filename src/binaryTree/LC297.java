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
        return serialize(root,"");
    }

    public String serialize(TreeNode root, String str) {
        if (root == null) str += "null,";
        else {
            str += root.val + ",";
            str = serialize(root.left,str);
            str = serialize(root.right,str);
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArray = data.split(",");
        List<String> dataList = new LinkedList<String>(Arrays.asList(dataArray));
        return deserialize(dataList);
    }

    public TreeNode deserialize(List<String> dataList) {
        if (dataList.get(0).equals("null")) {
            dataList.remove(0);
            return null;
        }

        TreeNode curRoot = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove(0);
        curRoot.left = deserialize(dataList);
        curRoot.right = deserialize(dataList);

        return curRoot;
    }
}

