package me.captainpotatoaim.myplugin.sandbox;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class SandboxMainCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 0) return false;

        if (sender.isOp()) {

            switch (args[0]) {

                case "create" -> {
                    return SandboxCreateCommand.onCommand(sender, command, label, args);
                }
                case "delete" -> {
                    return SandboxDeleteCommand.onCommand(sender, command, label, args);
                }
                case "join" -> {
                    return SandboxJoinCommand.onCommand(sender, command, label, args);
                }
                case "leave" -> {
                    return SandboxLeaveCommand.onCommand(sender, command, label, args);
                }

            }

        }

        return true;
    }
}
