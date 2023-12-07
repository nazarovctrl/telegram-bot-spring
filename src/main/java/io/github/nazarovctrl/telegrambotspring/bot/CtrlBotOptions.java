package io.github.nazarovctrl.telegrambotspring.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultBotOptions;

@Component
public class CtrlBotOptions extends DefaultBotOptions {
    @Value("#{systemProperties['bot.base_url'] ?: 'https://api.telegram.org/bot'}")
    private String base_url;

    @Override
    public String getBaseUrl() {
        return base_url;
    }
}