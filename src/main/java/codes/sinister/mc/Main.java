package codes.sinister.mc;

import codes.sinister.mc.events.MemberJoin;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        try {
            JDA jda = JDABuilder.createDefault("BOT_TOKEN_HERE")
                    .setActivity(Activity.playing("BOT_STATUS_HERE"))
                    .setStatus(OnlineStatus.DO_NOT_DISTURB)
                    .enableIntents(GatewayIntent.GUILD_MESSAGES, GatewayIntent.GUILD_INVITES, GatewayIntent.GUILD_MEMBERS, GatewayIntent.DIRECT_MESSAGES, GatewayIntent.MESSAGE_CONTENT)
                    .setMemberCachePolicy(MemberCachePolicy.ALL)
                    .setChunkingFilter(ChunkingFilter.ALL)
                    .addEventListeners(new MemberJoin())
                    .build()
                    .awaitReady();
            Guild guild = jda.getGuildById("GUILD_ID_HERE");
            assert guild != null;
            System.out.println("BOT ONLINE AND DOING SHIT");
        } catch (InterruptedException e) {
            System.out.println(e);;
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
