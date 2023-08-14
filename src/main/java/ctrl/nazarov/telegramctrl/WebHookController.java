package ctrl.nazarov.telegramctrl;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
public interface WebHookController {

    @RequestMapping(value = "/callback/update", method = RequestMethod.POST)
    ResponseEntity<?> onUpdateReceived(@RequestBody Update update);
}
