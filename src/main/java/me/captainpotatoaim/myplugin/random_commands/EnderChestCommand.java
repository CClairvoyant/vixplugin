package me.captainpotatoaim.myplugin.random_commands;

import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class EnderChestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (sender.isOp() && sender instanceof Player) {
            Server server = sender.getServer();
            Player target = server.getPlayer(args[0]);
            if (target == null) {
                if (Arrays.stream(server.getOfflinePlayers()).map(OfflinePlayer::getName).toList().contains(args[0])) {
                    sender.sendMessage(args[0] + " is not online at the moment.");
                } else {
                    sender.sendMessage("That player doesn't exist.");
                }
            } else {
                ((Player) sender).openInventory(target.getEnderChest());
            }
        }
        return true;
    }
}
