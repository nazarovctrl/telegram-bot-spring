package io.github.nazarovctrl.telegramctrl.sentence;

public interface TextService<V, L> {
    String getText(V sentenceDTO, L languageCode);
}
