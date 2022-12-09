package com.dataorbsinfobox;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class DataOrbsInfoBoxTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(DataOrbsInfoBoxPlugin.class);
		RuneLite.main(args);
	}
}