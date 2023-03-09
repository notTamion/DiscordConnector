package de.tamion.dc;

import de.tamion.dc.listeners.DCChat;
import de.tamion.mc.DCChatMC;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;
import org.bukkit.configuration.file.FileConfiguration;

public class DCChatDC {

    public static ShardManager jda;
    static FileConfiguration config = DCChatMC.getPlugin().getConfig();
    public static void startup() {
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(config.getString("Bot.token"));
        builder.setStatus(OnlineStatus.ONLINE);
        builder.addEventListeners(new DCChat());
        builder.enableIntents(GatewayIntent.MESSAGE_CONTENT);

        jda = builder.build();
    }

    public static void shutdown() {
        jda.setStatus(OnlineStatus.OFFLINE);
        jda.shutdown();
    }

    public static void restart() {
        jda.shutdown();
        startup();
    }
}
