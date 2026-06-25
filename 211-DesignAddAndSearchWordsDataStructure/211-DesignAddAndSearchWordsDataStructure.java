// Last updated: 6/25/2026, 8:38:22 AM
class WordDictionary {
    public class TrieNode {
        Map<Character, TrieNode> node;
        boolean isWord;
        public TrieNode() {
            this.node = new HashMap<>();
            this.isWord = false;
        }
    }

    TrieNode dict;

    public WordDictionary() {
        this.dict = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode start = this.dict;
        for (char ch: word.toCharArray()) {
            if(!start.node.containsKey(ch)) {
                start.node.put(ch, new TrieNode());
            } 
            start = start.node.get(ch);
        }
        start.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode search = this.dict;
        return dfsUtils(search, word, 0);  
    }

    private boolean dfsUtils(TrieNode root, String word, int i) {
        if(i == word.length()) {
            return root.isWord;
        } 
        char ch = word.charAt(i);
        if(ch == '.') {
            for(char ch1: root.node.keySet()) {
                if(dfsUtils(root.node.get(ch1), word, i+1)) return true;
            }
            return false;
        } else {
            if(!root.node.containsKey(ch)) return false;
            return dfsUtils(root.node.get(ch), word, i+1);
        }

    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */