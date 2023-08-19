package io.github.nazarovctrl.telegramspring.bot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Service
public class MessageSender extends DefaultAbsSender {
    public MessageSender(BotConfig botConfig) {
        super(new DefaultBotOptions(), botConfig.getToken());
    }
}