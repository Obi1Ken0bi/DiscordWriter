package ru.puzikov.discordwriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
public class WriteController {
    private final DiscordApi discordApi;

    public WriteController(DiscordApi discordApi) {
        this.discordApi = discordApi;
    }

    @PostMapping("/write")
    public ResponseEntity<Message> writeToDiscord(@RequestBody Map<String, String> input) {
        String text = input.get("text");
        System.out.println(text);
        discordApi.send(text);

        return new ResponseEntity<Message>(new Message("cool"), HttpStatus.ACCEPTED);

    }


}
