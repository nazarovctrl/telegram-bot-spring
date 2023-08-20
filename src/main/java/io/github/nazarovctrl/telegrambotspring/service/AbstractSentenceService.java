package io.github.nazarovctrl.telegrambotspring.service;

import io.github.nazarovctrl.telegrambotspring.function.Initialize;
import io.github.nazarovctrl.telegrambotspring.function.Search;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * The abstract class for easy work with sentences
 *
 * @param <K> key
 * @param <L> languageCode
 * @param <T> text
 * @author Azimjon Nazarov
 */
@Slf4j
public abstract class AbstractSentenceService<K, L, T> implements Search<K, L, T>, Initialize {

    /**
     * map for collecting sentences
     * map key -> key
     * map value -> map<LanguageCode, Text>
     */
    private final Map<K, Map<L, T>> sentenceMap = new HashMap<>();

    /**
     * default constructor for initializing sentences after program starts
     */
    public AbstractSentenceService() {
        initialize();
        log.info("Sentence initialized");
    }

    /**
     * Method to add sentence
     *
     * @param key   key
     * @param value map with languageCode and text
     */
    public void addSentence(K key, Map<L, T> value) {
        sentenceMap.put(key, value);
    }

    @Override
    public T search(K key, L languageCode) {
        return sentenceMap.get(key).get(languageCode);
    }
}
