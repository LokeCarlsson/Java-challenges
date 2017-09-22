package lc222ak_assign2.ex5;

public class Word implements Comparable<Word> {
    private String word;

    /**
     * @param str - Word to be made lower case
     */
    Word(String str) {
        word = str.toLowerCase();
    }

    /**
     * @return - Returns the word
     */
    public String toString() {
        return word;
    }

    /**
     * @return - Returns hashcode of the word
     */
    public int hashCode() {
        return word.hashCode();
    }

    /**
     * @param other - Other word to be evaluated
     * @return - True if both are equal
     */
    public boolean equals(Object other) {
        return other instanceof Word && word.hashCode() == other.hashCode();
    }

    /**
     * @param w - Word to compare
     * @return - Returns lexicographic number from comparison
     */
    public int compareTo(Word w) {
        return word.compareTo(w.toString());
    }
}