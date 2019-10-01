package net.codedstingray.devutilssponge.commands;

import net.codedstingray.devutilssponge.DevUtilsSponge;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandSpec;

public class CommandInitializer {

    public void initCommands() {
        CommandSpec cmdGetKeys = CommandSpec.builder()
                .executor(new CmdGetBlockTraits())
                .build();
        Sponge.getCommandManager().register(DevUtilsSponge.get(), cmdGetKeys, "getblocktraits");
    }
}
