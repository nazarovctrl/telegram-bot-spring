package io.github.nazarovctrl.telegrambotspring.bot.longpolling;

import io.github.nazarovctrl.telegrambotspring.bot.BotConfig;
import io.github.nazarovctrl.telegrambotspring.controller.UpdateController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * The class for used to initializing telegram bot without webhook
 *
 * @author Azimjon Nazarov
 */
@Slf4j
@Component
public class TelegramLongPollingBot extends org.telegram.telegrambots.bots.TelegramLongPollingBot {

    /**
     * {@link BotConfig} for getting bot configurations
     */
    private final BotConfig botConfig;

    /**
     * {@link UpdateController} for handling update
     */
    private final UpdateController updateController;

    /**
     * @param botConfig        bean
     * @param updateController bean
     */
    public TelegramLongPollingBot(BotConfig botConfig, UpdateController updateController) {
        this.botConfig = botConfig;
        this.updateController = updateController;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        updateController.handle(update);
    }
}
