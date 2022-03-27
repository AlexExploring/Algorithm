package AdvancedDataStructure.Trie;

public class TrieTree {
    private int SIZE=26;
    private TrieNode root;//字典树的根

    TrieTree() //初始化字典树
    {
        root=new TrieNode();
    }

    private class TrieNode //字典树节点
    {
        private int num;//有多少单词通过这个节点,即由根至该节点组成的字符串模式出现的次数,num的初始值为1
        private TrieNode[] next;//所有的儿子节点
        private boolean isEnd;//是不是最后一个节点
        private char val;//节点的值
        private boolean haveNext;

        TrieNode()
        {
            num=1;
            next =new TrieNode[SIZE];
            isEnd=false;
            haveNext =false;
        }
    }

    //建立字典树
    public void insert(String str) //在字典树中插入一个单词
    {
        if(str==null||str.length()==0)
        {
            return;
        }
        TrieNode node=root;
        char [] letters = str.toCharArray();
        for(int i=0,len=str.length(); i<len; i++)
        {
            int pos=letters[i]-'a';
            if(node.next[pos]==null)
            {
                node.haveNext = true;
                node.next[pos]=new TrieNode();
                node.next[pos].val=letters[i];
            }
            else
            {
                node.next[pos].num++;
            }
            node=node.next[pos];
        }
        node.isEnd=true;
    }

    //计算单词前缀的数量
    public int countPrefix(String prefix)
    {
        if(prefix==null||prefix.length()==0) {
            return -1;
        }
        TrieNode node=root;
        char [] letters = prefix.toCharArray();
        for(int i=0,len=prefix.length(); i<len; i++)
        {
            int pos=letters[i]-'a';
            if(node.next[pos]==null) {
                return 0;
            }
            else {
                node=node.next[pos];
            }
        }
        return node.num;
    }
    //打印指定前缀的单词
    public String hasPrefix(String prefix)
    {
        if (prefix == null || prefix.length() == 0)
        {
            return null;
        }
        TrieNode node = root;
        char[] letters = prefix.toCharArray();
        for (int i = 0, len = prefix.length(); i < len; i++)
        {
            int pos = letters[i] - 'a';
            if (node.next[pos] == null)
            {
                return null;
            }
            else
            {
                node = node.next[pos];
            }
        }
        preTraverse(node, prefix);
        return null;
    }
    // 遍历经过此节点的单词.
    public void preTraverse(TrieNode node, String prefix)
    {
        if (node.haveNext)
        {
            for (TrieNode child : node.next)
            {
                if (child!=null)
                {
                    preTraverse(child, prefix+child.val);
                }
            }
            return;
        }
        System.out.println(prefix);
    }


    //在字典树中查找一个完全匹配的单词.
    public boolean has(String str)
    {
        if(str==null||str.length()==0)
        {
            return false;
        }
        TrieNode node=root;
        char[]letters=str.toCharArray();
        for(int i=0,len=str.length(); i<len; i++)
        {
            int pos=letters[i]-'a';
            if(node.next[pos]!=null)
            {
                node=node.next[pos];
            }
            else
            {
                return false;
            }
        }
        return node.isEnd;
    }

    //前序遍历字典树.
    public void preTraverse(TrieNode node)
    {
        if(node!=null)
        {
            System.out.print(node.val+"-");
            for(TrieNode child:node.next)
            {
                preTraverse(child);
            }
        }
    }

    public TrieNode getRoot()
    {
        return this.root;
    }

    public static void main(String [] args)
    {
        TrieTree trieTree = new TrieTree();
        String [] strs= {"banana","band","bee","absolute","acm"};
        String [] prefix= {"ba","b","band","abc",};
        for(String str:strs)
        {
            trieTree.insert(str);
        }
        System.out.println(trieTree.has("abc"));
        trieTree.preTraverse(trieTree.getRoot());//先序遍历
        System.out.println();
        //tree.printAllWords();
        for(String pre:prefix)
        {
            int num=trieTree.countPrefix(pre);
            System.out.println(pre+" "+num);
        }

        System.out.println(trieTree.has("bee"));
    }
}
