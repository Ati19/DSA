class PrefixTree {
    static class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEndOfWord=false;
    }

    private TrieNode root=new TrieNode();


    public void insert(String word) {
        TrieNode curNode=root;
        for(int i=0;i<word.length();i++){
            char cur=word.charAt(i);
            if(curNode.children[cur-'a']==null){
                TrieNode newNode=new TrieNode();
                curNode.children[cur-'a']=newNode;
            }
            curNode=curNode.children[cur-'a'];
        }
        curNode.isEndOfWord=true;

    }

    public boolean search(String word) {
        TrieNode curNode=root;
        for(int i=0;i<word.length();i++){
            char cur=word.charAt(i);
            if(curNode.children[cur-'a']==null) return false;
            curNode=curNode.children[cur-'a'];
        }
        return curNode.isEndOfWord;

    }

    public boolean startsWith(String prefix) {
        TrieNode curNode=root;
        for(int i=0;i<prefix.length();i++){
            char cur=prefix.charAt(i);
            if(curNode.children[cur-'a']==null)return false;
            curNode=curNode.children[cur-'a'];
        }
        return true;

    }
}
