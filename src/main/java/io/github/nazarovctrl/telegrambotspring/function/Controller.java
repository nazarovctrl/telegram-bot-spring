package io.github.nazarovctrl.telegrambotspring.function;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * The functional interface for handling update
 *
 * @author Azimjon Nazarov
 */
@FunctionalInterface
public interface Controller {

    /**
     * @param update field for handling
     */
    void handle(Update update);
}
