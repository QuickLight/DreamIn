package com.dream.Main;

import com.dream.Listener.listeners;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;


import java.util.ArrayList;

public final class main extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new listeners(), this);
    }

    @Override
    public void onDisable() {
        System.out.println("dis");
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
//                    net.minecraft.server.v1_12_R1.ItemStack nmsItem = CraftItemStack.asNMSCopy(itemStack);
//                    NBTTagCompound compound = (nmsItem.hasTag()) ? nmsItem.getTag() : new NBTTagCompound();
//                    NBTTagList modifiers = new NBTTagList();
//                    NBTTagCompound damage = new NBTTagCompound();
//                    damage.set("AttributeName", new NBTTagString("generic.attackDamage"));
//                    damage.set("Name", new NBTTagString("Damage"));
//                    damage.set("Amount", new NBTTagInt(getPower()));
//                    damage.set("Operation", new NBTTagInt(0));
//                    damage.set("UUIDLeast", new NBTTagInt(20000));
//                    damage.set("UUIDMost", new NBTTagInt(1000));
//                    damage.set("Slot", new NBTTagString("mainhand"));
//                    modifiers.add(damage);
//                    compound.set("AttributeModifiers", modifiers);
//                    compound.set("Unbreakable", new NBTTagByte((byte) 1));
//                    nmsItem.setTag(compound);
//                    ItemStack hasNBTItem = CraftItemStack.asBukkitCopy(nmsItem);
                }
            }
        }
        return true;
    }


}
