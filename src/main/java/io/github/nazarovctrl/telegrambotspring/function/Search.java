package io.github.nazarovctrl.telegrambotspring.function;

/**
 * The functional interface for searching text with key and languageCode
 *
 * @param <K> key
 * @param <L> languageCode
 * @param <T> text
 */
@FunctionalInterface
public interface Search<K, L, T> {

    /**
     * The abstract method for search button text with key and languageCode
     *
     * @param key          key
     * @param languageCode languageCode
     * @return text
     */
    T search(K key, L languageCode);
}
