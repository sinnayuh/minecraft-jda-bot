package codes.sinister.mc.events;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MemberJoin extends ListenerAdapter {

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        User user = event.getMember().getUser();
        if (user.isBot()) return;

        event.getGuild().addRoleToMember(user, event.getGuild().getRoleById("1165997881690427537")).queue();
    }

}
