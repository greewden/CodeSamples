package com.denver.green;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Denver on 12/10/2016.
 */
public class TrieTest {
    @Test
    public void add() throws Exception {
        Trie contactBook = new Trie();
        contactBook.add("Denver");
        assertTrue(contactBook.contains("Denver"));
    }

    @Test
    public void isPrefix() throws Exception {
        Trie contactBook = new Trie();
        contactBook.add("Triathalon");
        assertTrue(contactBook.isPrefix("tri"));
    }

    @Test
    public void contains() throws Exception {

    }

    @Test
    public void countPartials() throws Exception {
        Trie contactBook = new Trie();
        contactBook.add("Denver");
        contactBook.add("Hackerrank");
        contactBook.add("Mason");
        contactBook.add("Hack");
        contactBook.add("Delroy");
        contactBook.add("Dennis");
        contactBook.add("Mark");
        assertEquals(2, contactBook.countPartials("Hac"));
    }

    @Test
    public void countPartials2() throws Exception {
        Trie contactBook = new Trie();
        contactBook.add("S");
        contactBook.add("SS");
        contactBook.add("SSS");
        contactBook.add("SSSS");
        contactBook.add("SSSSS");

        assertEquals(5, contactBook.countPartials("S"));
        assertEquals(4, contactBook.countPartials("SS"));
        assertEquals(3, contactBook.countPartials("SSS"));
        assertEquals(2, contactBook.countPartials("SSSS"));
        assertEquals(1, contactBook.countPartials("SSSSS"));
        assertEquals(0, contactBook.countPartials("SSSSSS"));
    }

    @Test
    public void countCompleteWords() throws Exception {
        Trie contactBook = new Trie();
        contactBook.add("Denver");
        contactBook.add("Lois");
        contactBook.add("Mason");
        contactBook.add("Olivia");
        contactBook.add("Delroy");
        contactBook.add("Dennis");
        contactBook.add("Mark");
        assertEquals(7, contactBook.countCompleteWords(contactBook));
    }
}