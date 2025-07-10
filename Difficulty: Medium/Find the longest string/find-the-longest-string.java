import java.util.*;

class Solution {
    public String longestString(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        String longest = "";
        for (String word : words) {
            if (trie.checkAllPrefixes(word)) {
                if (word.length() > longest.length()) {
                    longest = word;
                } else if (word.length() == longest.length()) {
                    if (longest.isEmpty() || word.compareTo(longest) < 0) {
                        longest = word;
                    }
                }
            }
        }
        return longest;
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                current.children.putIfAbsent(ch, new TrieNode());
                current = current.children.get(ch);
            }
            current.isEndOfWord = true;
        }

        public boolean checkAllPrefixes(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (!current.children.containsKey(ch)) {
                    return false;
                }
                current = current.children.get(ch);
                if (!current.isEndOfWord) {
                    return false;
                }
            }
            return true;
        }
    }
}