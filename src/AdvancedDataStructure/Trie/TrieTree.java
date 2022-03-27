package AdvancedDataStructure.Trie;

public class TrieTree {
    private int SIZE=26;
    private TrieNode root;//�ֵ����ĸ�

    TrieTree() //��ʼ���ֵ���
    {
        root=new TrieNode();
    }

    private class TrieNode //�ֵ����ڵ�
    {
        private int num;//�ж��ٵ���ͨ������ڵ�,���ɸ����ýڵ���ɵ��ַ���ģʽ���ֵĴ���,num�ĳ�ʼֵΪ1
        private TrieNode[] next;//���еĶ��ӽڵ�
        private boolean isEnd;//�ǲ������һ���ڵ�
        private char val;//�ڵ��ֵ
        private boolean haveNext;

        TrieNode()
        {
            num=1;
            next =new TrieNode[SIZE];
            isEnd=false;
            haveNext =false;
        }
    }

    //�����ֵ���
    public void insert(String str) //���ֵ����в���һ������
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

    //���㵥��ǰ׺������
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
    //��ӡָ��ǰ׺�ĵ���
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
    // ���������˽ڵ�ĵ���.
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


    //���ֵ����в���һ����ȫƥ��ĵ���.
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

    //ǰ������ֵ���.
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
        trieTree.preTraverse(trieTree.getRoot());//�������
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
