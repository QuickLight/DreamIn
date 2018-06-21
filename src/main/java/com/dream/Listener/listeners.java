package com.dream.Listener;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class listeners implements Listener {

    @EventHandler
    public void onPD(EntityDamageByEntityEvent event) {
        if (event.isCancelled() || !(event.getDamager() instanceof Player)) return;
        Player p = (Player) event.getDamager();
        if (p.getItemInHand() == null || p.getItemInHand().getType() == Material.AIR) return;
        ItemStack is = p.getItemInHand();
        if (!is.hasItemMeta() || !is.getItemMeta().hasLore()) return;
        List<String> l = is.getItemMeta().getLore();
        l.forEach((x) -> {
            if (x.contains("力量 ")) {
                int ll = Integer.parseInt(x.substring(x.indexOf(" ") + 1));
                event.setDamage(ll);
            }

        });

    }
}
