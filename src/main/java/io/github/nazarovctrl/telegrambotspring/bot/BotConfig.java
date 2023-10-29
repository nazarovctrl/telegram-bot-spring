package io.github.nazarovctrl.telegrambotspring.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The class for initializing telegram bot configurations into variables
 *
 * @author Azimjon Nazarov
 */
@Component
public class BotConfig {

    /**
     * Telegram bot username (required)
     * Example: @my_custom_bot
     */
    @Value("${bot.name}")
    private String name;

    /**
     * Telegram bot token (required)
     * Example: 1234567890:AbCDeEn10XcYV2Key1fBCjOqPtqT9RQYmUQ
     */
    @Value("${bot.token}")
    private String token;

    /**
     * Uri for sending requests (updates) from telegram bot with webhook to your application
     * Example: https://myserver.com
     */
    @Value(value = "${bot.uri:#{null}}")
    private String uri;

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    public String getUri() {
        return uri;
    }
}
