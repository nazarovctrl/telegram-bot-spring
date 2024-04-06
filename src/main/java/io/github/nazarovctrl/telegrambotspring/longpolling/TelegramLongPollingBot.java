package io.github.nazarovctrl.telegrambotspring.longpolling;

import io.github.nazarovctrl.telegrambotspring.bot.BotConfig;
import io.github.nazarovctrl.telegrambotspring.bot.TelegramBotAPIOptions;
import io.github.nazarovctrl.telegrambotspring.controller.AbstractUpdateController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

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
     * {@link AbstractUpdateController} for handling update
     */
    private final AbstractUpdateController updateController;

    /**
     * @param botConfig        bean
     * @param updateController bean
     */
    public TelegramLongPollingBot(TelegramBotAPIOptions options, BotConfig botConfig, AbstractUpdateController updateController) throws TelegramApiException {
        super(options, botConfig.getToken());
        this.botConfig = botConfig;
        this.updateController = updateController;

        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(this);
        log.info("Telegram long polling bot initialized");
    }

    @Override
    public String getBotUsername() {
        return botConfig.getName();
    }

    @Override
    public void onUpdateReceived(Update update) {
        updateController.handle(update);
    }
}
