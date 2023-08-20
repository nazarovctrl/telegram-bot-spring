package io.github.nazarovctrl.telegrambotspring.service;

import io.github.nazarovctrl.telegrambotspring.function.Initialize;
import io.github.nazarovctrl.telegrambotspring.function.Search;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * The abstract class for easy work with buttons
 *
 * @param <K> key
 * @param <L> languageCode
 * @param <T> text
 * @author Azimjon Nazarov
 */
@Slf4j
public abstract class AbstractButtonService<K, L, T> implements Search<K, L, T>, Initialize {

    /**
     * map for collecting buttons
     * map key -> key
     * map value -> map<LanguageCode, Text>
     */
    private final Map<K, Map<L, T>> buttonMap = new HashMap<>();

    /**
     * default constructor for initializing buttons after program starts
     */
    public AbstractButtonService() {
        initialize();
        log.info("Buttons initialized");
    }

    /**
     * Method to get button key with text
     *
     * @param text text
     * @return key
     */
    public K getButtonKey(T text) {
        return buttonMap.entrySet().stream().filter(entry -> entry.getValue().containsValue(text)).findAny().map(Map.Entry::getKey).orElse(null);
    }

    /**
     * Method to add button
     *
     * @param key   key
     * @param value map with languageCode and text
     */
    public void addButton(K key, Map<L, T> value) {
        buttonMap.put(key, value);
    }

    @Override
    public T search(K key, L languageCode) {
        return buttonMap.get(key).get(languageCode);
    }
}
