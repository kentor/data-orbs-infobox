package com.dataorbsinfobox;

import net.runelite.api.Client;
import net.runelite.api.Skill;

import java.awt.image.BufferedImage;


public class PrayerInfoBox extends AbstractDataOrbInfoBox {
    public PrayerInfoBox(BufferedImage image, DataOrbsInfoBoxPlugin plugin, Client client) {
        super(image, plugin, client);
    }

    @Override
    public String getText() {
        return String.valueOf(client.getBoostedSkillLevel(Skill.PRAYER));
    }
}
