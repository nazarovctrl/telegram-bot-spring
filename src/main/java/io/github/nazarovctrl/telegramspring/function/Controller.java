package io.github.nazarovctrl.telegramspring.function;

import org.telegram.telegrambots.meta.api.objects.Update;

@FunctionalInterface
public interface Controller {
    void handle(Update update);
}
