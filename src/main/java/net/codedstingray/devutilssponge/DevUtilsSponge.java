package net.codedstingray.devutilssponge;

import com.google.inject.Inject;
import net.codedstingray.devutilssponge.commands.CommandInitializer;
import org.slf4j.Logger;
import org.spongepowered.api.event.game.state.GameInitializationEvent;
import org.spongepowered.api.event.game.state.GameStartedServerEvent;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.plugin.Plugin;

@Plugin(
        id = "devutilssponge",
        name = "Dev Utils for Sponge",
        description = "A plugin that provides utility functions to aid development of other plugins.",
        authors = {
                "CodedStingray"
        }
)
public class DevUtilsSponge {

    @Inject
    private Logger logger;

    public DevUtilsSponge() {
        instance = this;
    }

    @Listener
    public void onInitialization(GameInitializationEvent event) {
        CommandInitializer cmdInit = new CommandInitializer();
        cmdInit.initCommands();
    }

    @Listener
    public void onServerStart(GameStartedServerEvent event) {
        logger.info("DevUtils Started");
    }

    //Singleton
    private static DevUtilsSponge instance;

    public static DevUtilsSponge get() {
        return instance;
    }
}
