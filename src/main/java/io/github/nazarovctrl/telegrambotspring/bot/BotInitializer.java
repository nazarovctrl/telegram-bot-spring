package io.github.nazarovctrl.telegrambotspring.bot;

import io.github.nazarovctrl.telegrambotspring.bot.longpolling.TelegramLongPollingBot;
import io.github.nazarovctrl.telegrambotspring.bot.webhook.TelegramWebhookBot;
import io.github.nazarovctrl.telegrambotspring.function.Initialize;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

/**
 * The class for initializing telegram bot
 *
 * @author Azimjon Nazarov
 */
@Slf4j
@Component
public class BotInitializer implements Initialize {

    /**
     * Bean
     * {@link TelegramWebhookBot}
     */
    @Autowired(required = false)
    private TelegramWebhookBot telegramWebhookBot;

    /**
     * Bean
     * {@link TelegramLongPollingBot}
     */
    @Autowired(required = false)
    private TelegramLongPollingBot telegramLongPollingBot;

    /**
     * Method for initializing
     * method works auto after creating {@link BotInitializer} bean
     */
    @PostConstruct
    @Override
    public void initialize() {
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

            if (telegramLongPollingBot != null) {
                telegramBotsApi.registerBot(telegramLongPollingBot);
            } else if (telegramWebhookBot != null) {
                SetWebhook setWebhook = SetWebhook.builder()
                        .url(telegramWebhookBot.getBotUri())
                        .build();
                telegramBotsApi.registerBot(telegramWebhookBot, setWebhook);
            } else {
                log.error("Could not initialize telegram bot");
                return;
            }
            log.info("Telegram bot initialized");
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
