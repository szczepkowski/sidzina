package pl.goreit.sidzina.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.goreit.api.generated.message.MessageView;
import pl.goreit.sidzina.domain.DomainException;
import pl.goreit.sidzina.domain.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping
    @ApiOperation(value = "pobiera wiadomisci uzytkownika ")
    public List<MessageView> getMessagesByEmail(@RequestParam String email) {
        return messageService.findByEmail(email);
    }

    @PostMapping
    @ApiOperation(value = "dodaje wiadomosc ")
    public Boolean createMessage(@RequestBody MessageView view) {
        return messageService.create(view);
    }
}
