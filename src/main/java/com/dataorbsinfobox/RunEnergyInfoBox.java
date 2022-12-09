package com.dataorbsinfobox;

import net.runelite.api.Client;
import net.runelite.api.Varbits;

import java.awt.*;
import java.awt.image.BufferedImage;


public class RunEnergyInfoBox extends AbstractDataOrbInfoBox {
    public RunEnergyInfoBox(BufferedImage image, DataOrbsInfoBoxPlugin plugin, Client client) {
        super(image, plugin, client);
    }

    @Override
    public String getText() {
        return String.valueOf(client.getEnergy() / 100);
    }

    @Override
    public Color getTextColor() {
        if (client.getVarbitValue(Varbits.RUN_SLOWED_DEPLETION_ACTIVE) == 1) {
            return Color.ORANGE;
        } else {
            return Color.WHITE;
        }
    }
}
