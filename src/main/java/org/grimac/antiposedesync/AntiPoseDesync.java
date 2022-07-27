package org.grimac.antiposedesync;

import com.github.retrooper.packetevents.PacketEvents;
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder;
import org.bukkit.plugin.java.JavaPlugin;

public final class AntiPoseDesync extends JavaPlugin {

    @Override
    public void onLoad() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this));
        PacketEvents.getAPI().getSettings().bStats(true).checkForUpdates(false).debug(false);
        PacketEvents.getAPI().load();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        PacketEvents.getAPI().getEventManager().registerListener(new MetadataListener());
        PacketEvents.getAPI().init();
    }
}
