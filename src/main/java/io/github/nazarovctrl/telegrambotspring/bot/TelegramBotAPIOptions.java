package io.github.nazarovctrl.telegrambotspring.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;

/**
 * The class for changing base_url
 *
 * @author Azimjon Nazarov
 */
@Component
public class TelegramBotAPIOptions extends DefaultBotOptions {
    @Value("${bot.base_url:https://api.telegram.org/bot}")
    private String base_url;

    @Override
    public String getBaseUrl() {
        return base_url;
    }
}