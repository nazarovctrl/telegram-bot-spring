package io.github.nazarovctrl.telegrambotspring.controller;

import io.github.nazarovctrl.telegrambotspring.function.Controller;
import io.github.nazarovctrl.telegrambotspring.longpolling.TelegramLongPollingBot;
import io.github.nazarovctrl.telegrambotspring.webhook.WebHookController;

/**
 * The abstract class for handling updates
 * You should inherit from this class and override the 'handle' method and make the child class bean
 * used in {@link WebHookController} and {@link TelegramLongPollingBot}
 *
 * @author Azimjon Nazarov
 */
public abstract class AbstractUpdateController implements Controller {
}
