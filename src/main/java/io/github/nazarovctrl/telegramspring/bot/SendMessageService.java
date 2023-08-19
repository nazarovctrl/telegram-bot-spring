package io.github.nazarovctrl.telegramspring.bot;

import io.github.nazarovctrl.telegramspring.bot.longpolling.TelegramLongPollingBot;
import io.github.nazarovctrl.telegramspring.bot.webhook.TelegramWebhookBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.DefaultAbsSender;

@Service
public class SendMessageService extends DefaultAbsSender {

    @Autowired(required = false)
    public SendMessageService(TelegramWebhookBot telegramWebhookBot) {
        super(telegramWebhookBot.getOptions(), telegramWebhookBot.getBotToken());
    }

    @Autowired(required = false)
    public SendMessageService(TelegramLongPollingBot telegramLongPollingBot) {
        super(telegramLongPollingBot.getOptions(), telegramLongPollingBot.getBotToken());
    }
}
