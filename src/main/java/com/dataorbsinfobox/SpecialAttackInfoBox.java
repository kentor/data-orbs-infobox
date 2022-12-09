package com.dataorbsinfobox;

import net.runelite.api.Client;
import net.runelite.api.VarPlayer;

import java.awt.image.BufferedImage;


public class SpecialAttackInfoBox extends AbstractDataOrbInfoBox {
    public SpecialAttackInfoBox(BufferedImage image, DataOrbsInfoBoxPlugin plugin, Client client) {
        super(image, plugin, client);
    }

    @Override
    public String getText() {
        // This is out of 1000 points
        int specialAttackPoints = client.getVarpValue(VarPlayer.SPECIAL_ATTACK_PERCENT);

        if (specialAttackPoints % 10 == 0) {
            return String.valueOf(specialAttackPoints / 10);
        } else {
            return String.valueOf(specialAttackPoints / 10.0);
        }
    }
}
