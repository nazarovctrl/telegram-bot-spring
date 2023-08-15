package io.github.nazarovctrl.telegramctrl.sentence;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public abstract class ButtonService<K, V> implements TextService {
    private final Map<K, V> buttonMap = new HashMap<>();

    public ButtonService() {
        initializeButtonText();
        log.info("Sentences initialized");
    }

    public abstract K getButtonKey(String text);

    public String getButtonText(K buttonKey, String languageCode) {
        return getText(buttonMap.get(buttonKey), languageCode);
    }

    protected abstract void initializeButtonText();

}
