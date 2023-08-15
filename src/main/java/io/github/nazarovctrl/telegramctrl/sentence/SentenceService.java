package io.github.nazarovctrl.telegramctrl.sentence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public abstract class SentenceService<K, V, L> implements TextService<V,L> {
    private final Map<K, V> sentenceMap = new HashMap<>();

    public SentenceService() {
        initializeSentence();
        log.info("Sentences initialized");
    }

    public String getSentenceText(K key, L languageCode) {
        return getText(sentenceMap.get(key), languageCode);
    }

    protected abstract void initializeSentence();
}
