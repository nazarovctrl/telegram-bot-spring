package io.github.nazarovctrl.telegramspring.bot.webhook;

import io.github.nazarovctrl.telegramspring.controller.UpdateController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public class WebHookController {
    private final UpdateController updateController;

    public WebHookController(UpdateController updateController) {
        this.updateController = updateController;
    }

    @RequestMapping(value = "/callback/update", method = RequestMethod.POST)
    ResponseEntity<?> onUpdateReceived(@RequestBody Update update) {
        updateController.handle(update);
        return ResponseEntity.ok().build();
    }
}
