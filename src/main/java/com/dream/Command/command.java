package com.dream.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class command implements CommandExecutor {
    Plugin plugin;

    public command(Plugin p) {
        this.plugin = p;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("error");
            return true;
        }
        Player player = (Player) sender;
        if (args.length != 0) {
            if (args[0].equalsIgnoreCase("add")) {
                if (args[1].equalsIgnoreCase("力量")) {
                    ItemStack itemStack = player.getItemInHand();
                    ItemMeta itemMeta = itemStack.getItemMeta();
                    ArrayList list = new ArrayList();
                    list.add("力量 + " + Integer.parseInt(args[2]));
                    itemMeta.setLore(list);
                    itemStack.setItemMeta(itemMeta);
                }
            }
        }
        return false;
    }
}
