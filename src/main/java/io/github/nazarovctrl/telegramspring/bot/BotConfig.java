package io.github.nazarovctrl.telegramspring.bot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("application.properties")
public class BotConfig {
    @Value("${bot.name}")
    private String name;

    @Value("${bot.token}")
    private String token;

    @Value("${bot.uri}")
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
