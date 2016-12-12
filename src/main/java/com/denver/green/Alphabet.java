package com.denver.green;

/**
 *
 */
public abstract class Alphabet {

    /**
     * Instantiate an instance of the abstract Alphabet class that is initialized with the
     * english alphabet and overides the getIndex method of the abstract class using an
     * anonymous class.
     */
    public final static Alphabet LOWERCASE = new Alphabet("abcdefghijklmnopqrstuvwxyz") {

        private final int charOffest = Character.getNumericValue('a');

        //@Override
        /**
         * Faster way to retrieve the index
         */
        public byte getIndex(char c) {
            return (byte) (Character.getNumericValue(c) - charOffest);
        }
    };
    public final String alphabet;

    public Alphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public byte[] toInt(String word) {
        byte[] r = new byte[word.length()];
        for (int i = 0; i < r.length; i++) {
            r[i] = getIndex(word.charAt(i));
        }
        return r;
    }

    public byte getIndex(char c) {
        return (byte) alphabet.indexOf(c);
    }

    public int size() {
        return alphabet.length();
    }
}