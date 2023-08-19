package io.github.nazarovctrl.telegramspring.bot;

import io.github.nazarovctrl.telegramspring.bot.longpolling.TelegramLongPollingBot;
import io.github.nazarovctrl.telegramspring.bot.webhook.TelegramWebhookBot;
import io.github.nazarovctrl.telegramspring.function.Initialize;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Slf4j
@Component
public class BotInitializer implements Initialize {
    @Autowired(required = false)
    private TelegramWebhookBot webBot;

    @Autowired(required = false)
    private TelegramLongPollingBot bot;

    @PostConstruct
    @Override
    public void initialize() {
        System.out.println("init");
        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);

            if (bot != null) {
                telegramBotsApi.registerBot(bot);
            } else if (webBot != null) {
                SetWebhook setWebhook = SetWebhook.builder()
                        .url(webBot.getBotUri())
                        .build();
                telegramBotsApi.registerBot(webBot, setWebhook);
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
