package java8inaction.parallel;

import lombok.Getter;

/**
 * @author KangShan
 * @date 2019/12/2 23:37
 */
public class WordCounter {
    @Getter
    private final int count;
    private final boolean lastSpace;

    WordCounter(int count, boolean lastSpace) {
        this.count = count;
        this.lastSpace = lastSpace;
    }

    /**
     * accumulator of word counter
     * @param c
     * @return
     */
    WordCounter accumulator(char c) {
        if (Character.isWhitespace(c)) {
            return lastSpace ? this:new WordCounter(count, true);
        }else {
            return lastSpace? new WordCounter(count +1, false):this;
        }
    }

    /**
     * combiner of word counter
     */
    WordCounter combiner(WordCounter other) {
        return new WordCounter(count + other.getCount(), lastSpace);
    }
}
