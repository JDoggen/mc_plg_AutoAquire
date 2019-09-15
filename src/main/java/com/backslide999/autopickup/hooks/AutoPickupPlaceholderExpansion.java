package com.backslide999.autopickup.hooks;

import com.backslide999.autopickup.AutoPickupPlugin;
import com.backslide999.autopickup.PlayerDetails;
import com.backslide999.autopickup.commands.executors.AutoPickup;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;

public class AutoPickupPlaceholderExpansion extends PlaceholderExpansion{

    @Override
    public String getAuthor() {
        return "backslide999";
    }

    @Override
    public String getIdentifier() {
        return "AutoPickup";
    }

    @Override
    public String getVersion() {
        return "1.0.0.0";
    }

    /**
     * This is the method called when a placeholder with our identifier is found and needs a value
     * We specify the value identifier in this method
     */
    @Override
    public String onPlaceholderRequest(Player p, String identifier) {

        if (p == null || identifier == null) {
            return null;
        }

        String trueString = AutoPickupPlugin.getInstance().fetchConfigString("api.placeholder.messages.true");
        String falseString = AutoPickupPlugin.getInstance().fetchConfigString("api.placeholder.messages.false");

        switch(identifier.toLowerCase()){
            case "hasautopickupenabled":
                return PlayerDetails.instance().hasAutoPickupEnabled(p) ? trueString: falseString;
            case "hasnotificationsenabled":
                return PlayerDetails.instance().hasNotificationsEnabled(p) ? trueString : falseString;
            case "hasautosmeltenabled":
                return PlayerDetails.instance().hasAutoSmeltEnabled(p) ? trueString : falseString;
            case "hasautoblockenabled":
                return PlayerDetails.instance().hasAutoBlockEnabled(p) ? trueString : falseString;
            default :
                return null;
        }
    }
}



