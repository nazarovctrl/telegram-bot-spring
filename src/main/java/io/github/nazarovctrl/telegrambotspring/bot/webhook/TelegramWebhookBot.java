package io.github.nazarovctrl.telegrambotspring.bot.webhook;

import io.github.nazarovctrl.telegrambotspring.bot.BotConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * The class for used to initializing telegram bot with webhook
 *
 * @author Azimjon Nazarov
 */
@Slf4j
@Component
public class TelegramWebhookBot extends org.telegram.telegrambots.bots.TelegramWebhookBot {

    /**
     * {@link BotConfig} for getting bot configurations
     */
    private final BotConfig botConfig;

    /**
     * @param botConfig bean
     */
    public TelegramWebhookBot(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public String getBotUsername() {
        return botConfig.getName();
    }

    @Override
    public String getBotToken() {
        return botConfig.getToken();
    }

    public String getBotUri() {
        return botConfig.getUri();
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        return null;
    }

    @Override
    public String getBotPath() {
        return "/update";
    }
}
