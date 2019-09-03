package com.backslide999.autopickup.events;

import com.backslide999.autopickup.AutoPickupPlugin;
import com.backslide999.autopickup.Constants;
import com.backslide999.autopickup.MinedBlockDetails;
import com.backslide999.autopickup.PlayerDetails;
import com.backslide999.autopickup.containers.MinedBlock;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class onItemSpawn implements Listener {

    AutoPickupPlugin plugin = null;

    public onItemSpawn(AutoPickupPlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onItemSpawn(ItemSpawnEvent event) {

        Location loc = event.getLocation().toBlockLocation();
        String locWorld = loc.getWorld().getName();
        int locX = loc.getBlockX();
        int locY = loc.getBlockY();
        int locZ = loc.getBlockZ();

        MinedBlock blockDetails = MinedBlockDetails.instance().getMinedBlocks()
                .stream()
                .filter(minedBlock -> {
                    Location miningLocation = minedBlock.getLocation();
                    return miningLocation.getBlockX() == locX
                            && miningLocation.getBlockY() == locY
                            && miningLocation.getBlockZ() == locZ
                            && miningLocation.getWorld().getName().equals(locWorld);
                })
                .findFirst()
                .orElse(null);

        if(blockDetails == null)
            return;

        //Block is mined by a used with AutoPickup on.
        Player player = blockDetails.getPlayer();
        Item item = event.getEntity();

        //Change Itemstack if user has autofurnace enabled
        if(PlayerDetails.instance().hasAutoSmeltEnabled(player)){
            ItemStack itemStack = item.getItemStack();
            switch(itemStack.getType().toString()){
                case "IRON_ORE":
                    itemStack.setType(Material.IRON_INGOT);
                    System.out.print("Player has permissions: ");
                    System.out.println(player.hasPermission("autopickup.autosmelt.fortune"));
                    if(player.hasPermission("autopickup.autosmelt.fortune")){
                        itemStack.setAmount(calculateFortuneAmount(Material.IRON_INGOT, itemStack.getAmount(), player));
                    }
                    break;
                case "GOLD_ORE":
                    itemStack.setType(Material.GOLD_INGOT);
                    if(player.hasPermission("autopickup.autosmelt.fortune")){
                        itemStack.setAmount(calculateFortuneAmount(Material.GOLD_INGOT, itemStack.getAmount(), player));
                    }
                    break;
                case "COBBLESTONE":
                    itemStack.setType(Material.STONE);
                    break;
                default: break;
            }
        }

        if(PlayerDetails.instance().hasAutoPickupEnabled(player)) {
            HashMap<Integer, ItemStack> map = player.getInventory().addItem(item.getItemStack());

            //Map returns items not given to player
            boolean succesfull = map.isEmpty();


            if (succesfull) {
                event.setCancelled(true);
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 0.1f, 1);
            }

            if (PlayerDetails.instance().hasNotificationsEnabled(player) && !succesfull) {
                player.sendMessage(ChatColor.RED + "Your inventory is full!");
                PlayerDetails.instance().removeAutoNotificationsEnabledTemporary(player);
            }
        }
    }

    private int calculateFortuneAmount(final Material material, final int defaultAmount, final Player player){
        if(defaultAmount != 1){
            //Amount dropped is not mined
            return defaultAmount;
        }

        int fortuneLevel = this.getFortuneLevel(player);
        if(fortuneLevel == 0){
            return 1;
        } else{
            int baseChance = this.plugin.fetchConfigInteger(Constants.PATH_FORTUNE + "."
                    + material.toString() + "." + fortuneLevel + ".base");
            int maxValue = this.plugin.fetchConfigInteger(Constants.PATH_FORTUNE + "."
                    + material.toString() + "." + fortuneLevel + ".max");

            Random random = new Random();
            if(random.nextInt(100) <= baseChance){
                //If base drop, return 1
                return 1;
            } else{
                //Else, calculate random integer from 2 - maxValue
                 return random.nextInt(maxValue - 2) + 2;
            }
        }
    }

    private int getFortuneLevel(final Player player){
        int fortuneLevel = 0;
        Map<Enchantment, Integer> enchantments = null;

        ItemStack mainHand = player.getInventory().getItemInMainHand();
        ItemStack offHand = player.getInventory().getItemInOffHand();
        boolean mainHandPickaxe = false;
        boolean offHandPickaxe = false;

        //Get enchantments from tool in Main Hand, if this is a pickaxe
        if(mainHand != null) {
            mainHandPickaxe = mainHand.getType().toString().toLowerCase().contains("pickaxe");
            if(mainHandPickaxe) {
                enchantments = mainHand.getEnchantments();
            }
        }

        //Get enchantments from tool in Off Hand, if this is a pickaxe and main hand is not a pickaxe
        if(offHand != null && !mainHandPickaxe) {
            offHandPickaxe = offHand.getType().toString().toLowerCase().contains("pickaxe");
            if(offHandPickaxe) {
                enchantments = offHand.getEnchantments();
            }
        }

        if(enchantments != null){
            try {
                fortuneLevel = enchantments.get(Enchantment.LOOT_BONUS_BLOCKS);
            } catch(NullPointerException e){
                fortuneLevel = 0;
            }
        }
        return fortuneLevel;
    }
}
