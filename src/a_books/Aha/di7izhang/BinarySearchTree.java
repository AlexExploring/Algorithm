package a_books.Aha.di7izhang;

//二叉搜索树
//二叉搜索树，是指一棵空树或者具有下列性质的二叉树：
//1.若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
//2.若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
//3.任意节点的左，右子树也分别为二叉搜索树；
//4.没有键值相等的节点。
//创建树的时候，用到了parent，current来记录要插入节点的位置。
public class BinarySearchTree<T extends Comparable<? super T>>{
    private static class BinaryNode<T>{
        T data;
        BinaryNode left;
        BinaryNode right;
    }

    private BinaryNode<T> root;

    public void insert(T key){
        BinaryNode p = new BinaryNode();
        p.data = key;
        if (root == null){
            root = p;
        }
        else {
            BinaryNode parent = new BinaryNode();  //current用来找插入的位置,parent用来将p放在正确的位置
            BinaryNode current = root;
            while (true){
                parent = current;
                if (key.compareTo((T)current.data) > 0){
                    current = current.right;//右子树
                    if (current==null){
                        parent.right = p;
                        return;
                    }
                }
                else {  //本程序没有做key出现相等情况的处理，
                    current = current.left;
                    if (current == null){
                        parent.left = p;//左子树
                        return;
                    }
                }
            }
        }
    }

    //三种遍历方法
    //中左右
    public void preOrder(BinaryNode root){
        if (root != null){
            System.out.println(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //左中右
    public void inOrder(BinaryNode root){
        if (root != null){
            inOrder(root.left);
            System.out.println(root.data + " ");
            inOrder(root.right);
        }
    }

    //左右中
    public void postOrder(BinaryNode root){
        if (root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.println(root.data + " ");
        }
    }

    public void traverse(int traverseType)
    {    // 选择以何种方式遍历
        switch (traverseType)
        {
            case 1:
                System.out.print("preOrder traversal ");
                System.out.println();
                preOrder(root);
                System.out.println();
                break;
            case 2:
                System.out.print("inOrder traversal ");
                System.out.println();
                inOrder(root);
                System.out.println();
                break;
            case 3:
                System.out.print("postOrder traversal ");
                System.out.println();
                postOrder(root);
                System.out.println();
                break;
        }
    }

    public void makeEmpty(){
        root = null;
    }

    public boolean isEmpty(){
        return root == null;
    }

    private BinaryNode<T> findMin(BinaryNode<T> t){
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);

    }

    private BinaryNode<T> findMax(BinaryNode<T> t){
        if (t != null)
            while (t.right != null)
                t = t.left;

        return t;
    }

    /**
     * @param x is the item to search for
     * @param t the node that roots the subtree*/
    public boolean contains(T x,BinaryNode<T> t){
        if (t == null)
            return false;
        int compareResult = x.compareTo(t.data);
        if (compareResult < 0)
            return contains(x,t.left);
        else if (compareResult > 0)
            return contains(x,t.right);
        else
            return true;
    }

    public BinaryNode find(T key){
        BinaryNode current = root;
        while (key.compareTo((T)current.data) != 0){
            if (key.compareTo((T)current.data) > 0){
                current = current.right;
            }else {
                current = current.left;
            }
            if (current == null) return null;
        }
        return current;
    }

    public void show(BinaryNode node){
        if (node != null)
            System.out.println(node.data);
        else
            System.out.println("null");
    }

    //删除操作
    private BinaryNode getSuccessor(BinaryNode delNode){  //寻找要删除节点的中序后继节点
        BinaryNode successorParent = delNode;
        BinaryNode successor = delNode;
        BinaryNode current = delNode.right;

        //用来寻找后继节点
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        //如果后继节点为要删除节点的右子树的左子，需要预先调整一下要删除节点的右子树。
        if (successor != delNode.right){
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    public boolean delete(T key){
        BinaryNode parent = new BinaryNode();
        BinaryNode current = root;
        boolean isRightChild = true; //标记要删除的节点的是左子还是右子

        while (current.data != key){ //找到要删除的节点，并标记其是左子还是右子
            parent = current; //跟进到最新current所指的位置
            if (key.compareTo((T)current.data) > 0){
                current = current.right;
                isRightChild = true;
            }else {
                current = current.left;
                isRightChild = false;
            }

            if (current == null) return false;
        }

        //此时current就是要删除节点，parent为其父节点,主要操作是对当前current指向的节点后
        // ，对该节点的子节点的操作，以维护数据结构的完整性。
        //要删除结点为叶子节点。
        if (current.right == null && current.left == null){
            if (current == root){
                root = null;//整棵树清空
            }
            else {
                if (isRightChild)
                    parent.right = null;
                else
                    parent.left = null;
            }
            return true;
        }
        //要删除节点有一个子节点
        else if (current.left == null){
            if (current == root)
                root = current.right;
            else if (isRightChild)  //isRightChild表示的是要删除的节点是parent节点的左子还是右子
                parent.right = current.right;
            else
                parent.left = current.right;
            return true;
        }
        else if (current.right == null){
            if (current == null)
                root = current.right;
            else if (isRightChild)
                parent.right = current.left;
            else
                parent.left = current.left;
            return true;
        }
        //要删除节点有两个子节点
        else {
            BinaryNode successor = getSuccessor(current);
            if (current == null)
                root = successor;
            else if (isRightChild)
                parent.right = successor;
            else
                parent.left = successor;

            successor.left = current.left;
            return true;
        }
    }

    public static void main(String[] args) {
        //使用外部方法时(不管是static还是非static)，都要先new一个对象，才能使用该对象的方法。
        //因为main方法是static的静态方法，所以只能调用静态方法，
        //解决办法：把方法放入一个新建的类里，然后再main方法中实例化，再通过这个类调用
        // 或者，把方法设为static
        //静态方法不可以调用非静态方法和使用非静态变量，非静态方法可以调用静态方法和使用静态变量
        BinarySearchTree<Integer> tree = new BinarySearchTree();
        tree.insert(39);
        tree.insert(24);
        tree.insert(64);
        tree.insert(23);
        tree.insert(30);
        tree.insert(53);
        tree.insert(60);
        tree.insert(39);


        //tree.preOrder(root);
        tree.traverse(1);
        tree.traverse(2);
        tree.traverse(3);
    }
}
