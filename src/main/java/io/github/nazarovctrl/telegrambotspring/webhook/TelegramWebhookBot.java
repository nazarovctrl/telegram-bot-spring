package io.github.nazarovctrl.telegrambotspring.webhook;

import io.github.nazarovctrl.telegrambotspring.bot.BotConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.Webhook;
import org.telegram.telegrambots.updatesreceivers.DefaultWebhook;

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
    public TelegramWebhookBot(BotConfig botConfig) throws TelegramApiException {
        super(botConfig.getToken());
        this.botConfig = botConfig;

        Webhook webhook = new DefaultWebhook();
        this.onRegister();
        webhook.registerWebhook(this);

        SetWebhook setWebhook = SetWebhook.builder()
                .url(botConfig.getUri())
                .build();

        this.setWebhook(setWebhook);
        log.info("Telegram webhook bot initialized");
    }

    @Override
    public String getBotUsername() {
        return botConfig.getName();
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
