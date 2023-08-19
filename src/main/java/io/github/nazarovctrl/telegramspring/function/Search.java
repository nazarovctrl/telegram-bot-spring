package io.github.nazarovctrl.telegramspring.function;

@FunctionalInterface
public interface Search<K, L, T> {
    T search(K key, L languageCode);
}
