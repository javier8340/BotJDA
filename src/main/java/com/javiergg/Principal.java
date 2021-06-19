package com.javiergg;

import com.javiergg.listener.MessageListener;
import lombok.extern.slf4j.Slf4j;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.TextChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.LoginException;
import java.util.List;


@Slf4j
@SpringBootApplication
public class Principal {
    public static JDA api;

    public static void main(String[] args) throws LoginException, InterruptedException {
        JDABuilder builder =  JDABuilder.createDefault("NjYxNjA2MzU1OTExNTczNTI0.Xgt27w.C6zU3qjMt8Dkj5TnTH6uLAR4Sm8");
        builder.addEventListeners(new MessageListener());
        builder.setActivity(Activity.playing("El mejor juego"));
        Principal.api = builder.build();
        api.awaitReady();


        List<TextChannel> textChannels = api.getTextChannels();
//        textChannels.sendMessage("hola").queue();
        for (TextChannel channel : textChannels) {
            channel.sendMessage("Hello, world!").queue();
        }



        SpringApplication.run(Principal.class, args);
    }
}
