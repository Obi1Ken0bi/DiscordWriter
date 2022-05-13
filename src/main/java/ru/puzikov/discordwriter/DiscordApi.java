package ru.puzikov.discordwriter;


import lombok.SneakyThrows;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DiscordApi {
    private final String token;
    private final JDA api;

    @SneakyThrows
    public DiscordApi(@Autowired String token) {
        this.token = token;
        api = JDABuilder.createDefault(token).build();

    }

    @Bean
    static String getToken() {
        System.out.println("Token ready");
        return "token";
    }

    public void send(String text) {
        Guild guild = api.getGuildById("261125968628809729");
        System.out.println("Guild name: " + guild.getName());

        TextChannel textChannel = guild.getTextChannelById("261125968628809729");
        System.out.println(textChannel.getName());
        textChannel.sendMessage(text).queue();
    }

}
