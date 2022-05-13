package ru.puzikov.discordwriter;


import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.security.auth.login.LoginException;

@Component
@Slf4j
public class DiscordApi {

    private final JDA api;

    public DiscordApi(@Value("${discord.token}") String token) {
        try {
            log.info(token);
            api = JDABuilder.createDefault(token).setToken(token).build();
        } catch (LoginException e) {
            throw new RuntimeException(e);
        }

    }


    public void send(String text) {
        Guild guild = api.getGuildById("261125968628809729");
        System.out.println("Guild name: " + guild.getName());

        TextChannel textChannel = guild.getTextChannelById("261125968628809729");
        System.out.println(textChannel.getName());
        textChannel.sendMessage(text).queue();
    }

}
