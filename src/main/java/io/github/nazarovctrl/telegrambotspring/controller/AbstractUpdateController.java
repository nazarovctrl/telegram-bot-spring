package io.github.nazarovctrl.telegrambotspring.controller;

import io.github.nazarovctrl.telegrambotspring.function.Controller;

/**
 * The abstract class for handling updates
 * You should inherit from this class and override the 'handle' method and make the child class bean
 * used in {@link io.github.nazarovctrl.telegrambotspring.bot.webhook.WebHookController} and {@link io.github.nazarovctrl.telegrambotspring.bot.longpolling.TelegramLongPollingBot}
 *
 * @author Azimjon Nazarov
 */
public abstract class AbstractUpdateController implements Controller {
}
