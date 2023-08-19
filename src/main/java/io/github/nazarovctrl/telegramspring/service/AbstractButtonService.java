package io.github.nazarovctrl.telegramspring.service;

import io.github.nazarovctrl.telegramspring.function.Initialize;
import io.github.nazarovctrl.telegramspring.function.Search;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class AbstractButtonService<K, L, T> implements Search<K, L, T>, Initialize {
    private final Map<K, Map<L, T>> buttonMap = new HashMap<>();

    public AbstractButtonService() {
        initialize();
        log.info("Buttons initialized");
    }

    public K getButtonKey(T text) {
        return buttonMap
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue().containsValue(text))
                .findAny()
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public void addButton(K key, Map<L, T> value) {
        buttonMap.put(key, value);
    }

    @Override
    public T search(K key, L languageCode) {
        return buttonMap.get(key).get(languageCode);
    }
}
