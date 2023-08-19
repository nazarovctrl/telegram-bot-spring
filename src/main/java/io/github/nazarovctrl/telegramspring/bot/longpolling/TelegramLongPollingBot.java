package io.github.nazarovctrl.telegramspring.bot.longpolling;

import io.github.nazarovctrl.telegramspring.bot.BotConfig;
import io.github.nazarovctrl.telegramspring.controller.UpdateController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
@Component
public class TelegramLongPollingBot extends org.telegram.telegrambots.bots.TelegramLongPollingBot {
    private final BotConfig botConfig;
    private final UpdateController updateController;

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
