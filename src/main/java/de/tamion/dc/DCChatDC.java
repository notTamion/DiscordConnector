package de.tamion.dc;

import de.tamion.dc.listeners.DCChat;
import de.tamion.mc.DCChatMC;
import de.tamion.mc.listeners.Chat;
import de.tamion.mc.listeners.JoinLeave;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.w3c.dom.Text;

public class DCChatDC {

    public static ShardManager jda;
    static FileConfiguration config = DCChatMC.getPlugin().getConfig();
    public static void startup() {
        boolean startallowed = true;
        if(!config.contains("Bot.token")) {
            startallowed=false;
            Bukkit.getConsoleSender().sendMessage("§cBOT TOKEN NOT SET. PLEASE SET WITH /setBotToken [Token]");
        }
        if(!config.contains("Bot.guildid")) {
            startallowed=false;
            Bukkit.getConsoleSender().sendMessage("§cGUILDID NOT SET. PLEASE SET WITH /setGuildID [ID]");
        }
        if(!config.contains("Bot.textchannelid")) {
            startallowed=false;
            Bukkit.getConsoleSender().sendMessage("§cTEXTCHANNELID NOT SET. PLEASE SET WITH /setChannelID [ID]");
        }
        if(startallowed == false) {
            return;
        }
        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new Chat(), DCChatMC.getPlugin());
        pluginManager.registerEvents(new JoinLeave(), DCChatMC.getPlugin());
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(config.getString("Bot.token"));
        builder.setStatus(OnlineStatus.ONLINE);
        builder.addEventListeners(new DCChat());
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);

        jda = builder.build();
        Bukkit.getConsoleSender().sendMessage("§aBOT STARTED!");
    }

    public static void shutdown() {
        if(jda != null) {
            jda.setStatus(OnlineStatus.OFFLINE);
            jda.shutdown();
        } else {
            Bukkit.getConsoleSender().sendMessage("§cCANT STOP BOT! BOT NOT RUNNING!");
        }
    }

    public static void restart() {
        shutdown();
        startup();
    }
}
