package com.javiergg.listener;

import com.javiergg.Principal;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class MessageListener extends ListenerAdapter {

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        if (event.getAuthor().isBot()) return;
        Principal.api.getPresence().setActivity(Activity.listening(event.getMessage().getContentRaw()));
        event.getMessage().reply("Isho que hase tu por aquí").queue();
    }
}
