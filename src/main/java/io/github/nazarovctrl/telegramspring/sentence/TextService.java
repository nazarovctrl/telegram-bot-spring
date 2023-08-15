package io.github.nazarovctrl.telegramspring.sentence;

public interface TextService<V, L> {
    String getText(V sentenceDTO, L languageCode);
}
