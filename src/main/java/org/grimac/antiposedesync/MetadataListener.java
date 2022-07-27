package org.grimac.antiposedesync;

import com.github.retrooper.packetevents.event.PacketListenerAbstract;
import com.github.retrooper.packetevents.event.PacketSendEvent;
import com.github.retrooper.packetevents.protocol.packettype.PacketType;
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerEntityMetadata;

public class MetadataListener extends PacketListenerAbstract {
    @Override
    public void onPacketSend(PacketSendEvent event) {
        if (event.getPacketType() == PacketType.Play.Server.ENTITY_METADATA) {
            WrapperPlayServerEntityMetadata data = new WrapperPlayServerEntityMetadata(event);
            if (data.getEntityId() == event.getUser().getEntityId()) {
                data.getEntityMetadata().removeIf(element -> element.getIndex() == 6);
            } else {
                event.setLastUsedWrapper(null); // Optimize
            }
        }
    }
}