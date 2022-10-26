public class Trie {
    private class Node {
        char val;
        Node[] child;
        boolean end; //标志当前节点是否为一个单词的结尾

        public Node(char ch) {
            val = ch;
            child = new Node[26];
            end = false;
        }

        public Node() {
            child = new Node[26];
            end = false;
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    

    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.child[ch - 'a'] == null) {
                cur.child[ch - 'a'] = new Node(ch);
            }
            cur = cur.child[ch - 'a'];
        }
        cur.end = true;
    }
    
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.child[ch - 'a'] == null) {
                return false;
            }
            cur = cur.child[ch - 'a'];
        }
        return cur.end;
    }
    
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (cur.child[ch - 'a'] == null) {
                return false;
            }
            cur = cur.child[ch - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie tree = new Trie();

        tree.insert("tea");
        tree.insert("test");
        
        System.out.println(tree.search("tea")); // true
        System.out.println(tree.search("test")); // true
        
        System.out.println(tree.startsWith("tes")); // true
        System.out.println(tree.search("tes")); // false

        tree.insert("tes");
        System.out.println(tree.startsWith("tes")); // true
        System.out.println(tree.search("tes")); // true

    }
}