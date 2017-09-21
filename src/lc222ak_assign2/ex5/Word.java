package lc222ak_assign2.ex5;

public class Word implements Comparable<Word> {
    private String word;

    public Word(String str) {
        word = str.toLowerCase();
    }

    public String toString() {
        return word;
    }

    /* Override Object methods */
    public int hashCode() {
        //"compute a hash value for word"
        return word.hashCode();
    }

    public boolean equals(Object other) {
        return other instanceof Word && word.hashCode() == other.hashCode();
    }

    /* Implement Comparable */
    public int compareTo(Word w) {
        //"compares two words lexicographically"
        return word.compareTo(w.toString());
    }
}