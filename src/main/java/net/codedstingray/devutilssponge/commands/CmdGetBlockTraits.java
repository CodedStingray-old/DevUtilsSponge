package net.codedstingray.devutilssponge.commands;

import org.spongepowered.api.block.BlockState;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;
import org.spongepowered.api.world.Location;
import org.spongepowered.api.world.World;

public class CmdGetBlockTraits implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Player player;
        if(src instanceof Player) {
            player = (Player)src;
        } else {
            src.sendMessage(Text.of("Command only applicable to players"));
            return CommandResult.empty();
        }


        Location<World> playerLocation = player.getLocation();
        Location<World> blockLocation = playerLocation.add(0, -1, 0);

        BlockState state = blockLocation.getBlock();
        player.sendMessages(Text.of(TextColors.AQUA, "==== BlockTraits ===="),
                Text.of("The block below you has the following " + state.getTraitMap().size() + " traits:")
        );
        state.getTraitMap().forEach((trait, value) -> {
            player.sendMessages(Text.of("====================="),
                    Text.of("Name: " + trait.getName()),
                    Text.of("ID: " + trait.getId()),
                    Text.of("possible Values: " + trait.getPossibleValues()),
                    Text.of("Value: " + value)
            );
        });

        return CommandResult.success();
    }
}
