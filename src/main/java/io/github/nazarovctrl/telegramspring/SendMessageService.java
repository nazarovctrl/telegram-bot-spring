package io.github.nazarovctrl.telegramspring;

import org.springframework.stereotype.Service;

@Service
public abstract class SendMessageService {

    public TelegramBot telegramBot;

    public void setTelegramBot(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }
}
