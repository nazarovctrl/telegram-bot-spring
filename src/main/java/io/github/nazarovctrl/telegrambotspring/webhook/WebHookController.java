package io.github.nazarovctrl.telegrambotspring.webhook;

import io.github.nazarovctrl.telegrambotspring.util.UpdateUtil;
import io.github.nazarovctrl.telegrambotspring.context.UserContext;
import io.github.nazarovctrl.telegrambotspring.controller.AbstractUpdateController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * The class for handling requests (updates) from telegram bot with webhook
 *
 * @author Azimjon Nazarov
 */
@Slf4j
@RestController
public class WebHookController {

    /**
     * {@link AbstractUpdateController} for handling update
     */
    private final AbstractUpdateController updateController;

    /**
     * @param updateController bean
     */
    public WebHookController(AbstractUpdateController updateController) {
        this.updateController = updateController;
        log.info("Webhook controller initialized");
    }

    /**
     * @param update request body
     * @return if everything ok returns OK (status_code = 200) otherwise Internal Server Error (status_code = 500)
     */
    @RequestMapping(value = "/callback/update", method = RequestMethod.POST)
    public ResponseEntity<?> onUpdateReceived(@RequestBody Update update) {
        User user = UpdateUtil.getUserFromUpdate(update);
        process(user, update);
        return ResponseEntity.ok().build();
    }

    private void process(User user, Update update) {
        UserContext.setUser(user);
        updateController.handle(update);
        UserContext.clear();
    }
}
