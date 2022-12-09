package com.dataorbsinfobox;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("DataOrbsInfoBox")
public interface DataOrbsInfoBoxConfig extends Config
{
	@ConfigItem(
		keyName = "showHpInfoBox",
		name = "Show HP",
		description = "Show HP Infobox"
	)
	default boolean showHpInfoBox()
	{
		return false;
	}

	@ConfigItem(
			keyName = "showPrayerInfoBox",
			name = "Show Prayer",
			description = "Show Prayer Infobox"
	)
	default boolean showPrayerInfoBox()
	{
		return false;
	}

	@ConfigItem(
			keyName = "showRunEnergyInfoBox",
			name = "Show Run Energy",
			description = "Show Run Energy Infobox"
	)
	default boolean showRunEnergyInfoBox()
	{
		return false;
	}

	@ConfigItem(
			keyName = "showSpecialAttackInfoBox",
			name = "Show Special Attack",
			description = "Show Special Attack Infobox"
	)
	default boolean showSpecialAttackInfoBox()
	{
		return false;
	}
}
