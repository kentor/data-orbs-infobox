package com.dataorbsinfobox;

import net.runelite.api.Client;
import net.runelite.api.Skill;

import java.awt.image.BufferedImage;


public class HpInfoBox extends AbstractDataOrbInfoBox {
    public HpInfoBox(BufferedImage image, DataOrbsInfoBoxPlugin plugin, Client client) {
        super(image, plugin, client);
    }

    @Override
    public String getText() {
        return String.valueOf(client.getBoostedSkillLevel(Skill.HITPOINTS));
    }
}
