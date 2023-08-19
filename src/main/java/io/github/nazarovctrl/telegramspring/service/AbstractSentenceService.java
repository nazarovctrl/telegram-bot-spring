package io.github.nazarovctrl.telegramspring.service;

import io.github.nazarovctrl.telegramspring.function.Initialize;
import io.github.nazarovctrl.telegramspring.function.Search;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class AbstractSentenceService<K, L, T> implements Search<K, L, T>, Initialize {
    private final Map<K, Map<L, T>> sentenceMap = new HashMap<>();

    public AbstractSentenceService() {
        initialize();
        log.info("Sentence initialized");
    }

    public void addSentence(K key, Map<L, T> value) {
        sentenceMap.put(key, value);
    }

    @Override
    public T search(K key, L languageCode) {
        return sentenceMap.get(key).get(languageCode);
    }
}
