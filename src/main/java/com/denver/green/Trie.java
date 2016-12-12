package com.denver.green;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by Denver on 12/9/2016.
 */
public class Trie {

    private Map<Character, Trie>    children = new HashMap<>();
    private boolean                 isWord = false;
    private Character               value = null;
    private int                     wordCount = 0;

    // Constructors
    public Trie(char c){
        this.value = c;
    }

    public Trie(Collection<String> contacts) { contacts.forEach(this::add); }

    public Trie() {}

    /**
     * Adds the string provided to the trie datastructure.
     * @param value - string to be inserted into the trie.
     */
    public void add(String value) {
        // Ensure that trie stores all characters as lower case.
        value = value.toLowerCase();

        // Check to see if child node representing the character already exists. If it does not
        // then create it, and add it to the children array.
        Character key = value.charAt(0);
        Trie child = children.get(key);
        if (child == null) {
            child = new Trie(key);
            children.put(key, child);
        }

        // Increment the number of words that the child node is part of.
        child.wordCount++;

        // Check to see if this is the end of the string being added to the trie.
        // If it is then set the isWord flag to true.
        if (value.length() == 1) {
            child.isWord = true;
        } else {
            // add rest of string to trie.
            child.add(value.substring(1));
        }
    }

    /**
     * Looks to see if the provided string is in the trie.
     *
     * @param s - string to search for.
     * @return node that corresponds to the last character in the string.
     */
    public Trie getNode(String s) {
        s = s.toLowerCase();
        Trie node = this;
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            Trie child = node.children.get(key);
            if (child == null) {
                // String was not found in trie.
                return null;
            }
            node = child;
        }
        return node;
    }

    /**
     * Returns true if the string provided is a prefix to a word stored in the trie.
     * @param prefix to be searched for.
     * @return true if there are words in the trie that start with the provide prefix.
     */
    public boolean isPrefix(String prefix) {
        prefix = prefix.toLowerCase();
        Trie node = getNode(prefix);
        return node != null && node.children.size() > 0;
    }

    /**
     * Returns true if the trie contains the string provided.
     * @param value to be searched for.
     * @return true is value is in tre.
     */
    public boolean contains(String value) {
        value = value.toLowerCase();
        Trie node = getNode(value);
        return node != null;
    }

    /**
     * Count the number of words that start with the string provided.
     * @param partial string to be searched for.
     * @return count of the number of words that start with the given string.
     */
    public int countPartials(String partial) {
        partial = partial.toLowerCase();
        Trie node = getNode(partial);
        if (node == null) {
            return 0;
        } else {
            return node.wordCount;
        }
    }

    /**
     * Counts the number of complete words contained in the given trie.
     * @param node is the root node of the trie to be used.
     * @return count of the number of complete words in the provided trie.
     */
    public int countCompleteWords(Trie node) {
        if (node.wordCount > 0) {
            return node.wordCount;
        }

        int count = 0;
        for (Trie n : node.children.values()){
            count+= n.wordCount;
        }
        return count;
    }
}