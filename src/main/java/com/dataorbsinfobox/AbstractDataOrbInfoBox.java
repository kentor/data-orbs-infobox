package com.dataorbsinfobox;

import net.runelite.api.Client;
import net.runelite.client.ui.overlay.infobox.InfoBox;

import java.awt.*;
import java.awt.image.BufferedImage;


public abstract class AbstractDataOrbInfoBox extends InfoBox {
    protected final Client client;

    public AbstractDataOrbInfoBox(BufferedImage image, DataOrbsInfoBoxPlugin plugin, Client client) {
        super(image, plugin);
        this.client = client;
    }

    @Override
    public Color getTextColor() {
        return Color.WHITE;
    }
}
