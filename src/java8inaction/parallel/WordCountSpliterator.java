package java8inaction.parallel;

import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author KangShan
 * @date 2019/12/3 0:12
 */
public class WordCountSpliterator implements Spliterator<Character> {

    private final String str;
    private int currentChar = 0;

    WordCountSpliterator(String str) {
        this.str = str;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        action.accept(str.charAt(currentChar++));

        return currentChar < str.length();
    }

    public static void main(String[] args) {
        System.out.println("asdasdf".substring(1,2));
    }

    @Override
    public Spliterator<Character> trySplit() {
        if (str.length() - currentChar < 10) {
            return null;
        } else {
            for (int splitPos = (str.length() - currentChar) / 2 + currentChar;
                 splitPos < str.length(); splitPos++) {
                if (Character.isWhitespace(str.charAt(splitPos))) {
                    Spliterator spliterator =
                            new WordCountSpliterator(str.substring(currentChar, splitPos));
                    currentChar = splitPos;
                    return spliterator;
                }
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return str.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return NONNULL + ORDERED + SIZED + SUBSIZED + IMMUTABLE;
    }
}
