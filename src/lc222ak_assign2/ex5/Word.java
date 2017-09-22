package lc222ak_assign2.ex5;

public class Word implements Comparable<Word> {
    private String word;

    Word(String str) {
        word = str.toLowerCase();
    }

    public String toString() {
        return word;
    }

    public int hashCode() {
        return word.hashCode();
    }

    public boolean equals(Object other) {
        return other instanceof Word && word.hashCode() == other.hashCode();
    }

    public int compareTo(Word w) {
        return word.compareTo(w.toString());
    }
}