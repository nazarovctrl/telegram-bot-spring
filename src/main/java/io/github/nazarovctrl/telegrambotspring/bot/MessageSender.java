package io.github.nazarovctrl.telegrambotspring.bot;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;

/**
 * The class for send message to telegram bot
 *
 * @author Azimjon Nazarov
 */
@Service
public class MessageSender extends DefaultAbsSender {

    /**
     * @param botConfig bean used to get telegram bot token
     */
    public MessageSender(BotConfig botConfig) {
        super(new DefaultBotOptions(), botConfig.getToken());
    }
}