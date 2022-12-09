package com.dataorbsinfobox;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.Varbits;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.game.SkillIconManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.infobox.InfoBoxManager;

@Slf4j
@PluginDescriptor(
	name = "Data Orbs Infobox"
)
public class DataOrbsInfoBoxPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private DataOrbsInfoBoxConfig config;

	@Inject
	private InfoBoxManager infoBoxManager;

	@Inject
	private SkillIconManager skillIconManager;

	private HpInfoBox hpInfoBox;
	private PrayerInfoBox prayerInfoBox;
	private RunEnergyInfoBox runEnergyInfoBox;
	private SpecialAttackInfoBox specialAttackInfoBox;

	@Override
	protected void startUp() throws Exception
	{
		if (config.showHpInfoBox() && hpInfoBox == null) {
			hpInfoBox = new HpInfoBox(skillIconManager.getSkillImage(Skill.HITPOINTS), this, client);
			infoBoxManager.addInfoBox(hpInfoBox);
		}

		if (config.showPrayerInfoBox() && prayerInfoBox == null) {
			prayerInfoBox = new PrayerInfoBox(skillIconManager.getSkillImage(Skill.PRAYER), this, client);
			infoBoxManager.addInfoBox(prayerInfoBox);
		}

		if (config.showRunEnergyInfoBox() && runEnergyInfoBox == null) {
			runEnergyInfoBox = new RunEnergyInfoBox(skillIconManager.getSkillImage(Skill.AGILITY), this, client);
			infoBoxManager.addInfoBox(runEnergyInfoBox);
		}

		if (config.showSpecialAttackInfoBox() && specialAttackInfoBox == null) {
			specialAttackInfoBox = new SpecialAttackInfoBox(skillIconManager.getSkillImage(Skill.ATTACK), this, client);
			infoBoxManager.addInfoBox(specialAttackInfoBox);
		}
	}

	@Override
	protected void shutDown() throws Exception
	{
		if (hpInfoBox != null) {
			infoBoxManager.removeInfoBox(hpInfoBox);
			hpInfoBox = null;
		}

		if (prayerInfoBox != null) {
			infoBoxManager.removeInfoBox(prayerInfoBox);
			prayerInfoBox = null;
		}

		if (runEnergyInfoBox != null) {
			infoBoxManager.removeInfoBox(runEnergyInfoBox);
			runEnergyInfoBox = null;
		}

		if (runEnergyInfoBox != null) {
			infoBoxManager.removeInfoBox(specialAttackInfoBox);
			specialAttackInfoBox = null;
		}
	}

	@Subscribe
	protected void onConfigChanged(ConfigChanged event) throws Exception {
		this.startUp();

		if (!config.showHpInfoBox() && hpInfoBox != null) {
			infoBoxManager.removeInfoBox(hpInfoBox);
			hpInfoBox = null;
		}

		if (!config.showPrayerInfoBox() && prayerInfoBox != null) {
			infoBoxManager.removeInfoBox(prayerInfoBox);
			prayerInfoBox = null;
		}

		if (!config.showRunEnergyInfoBox() && runEnergyInfoBox != null) {
			infoBoxManager.removeInfoBox(runEnergyInfoBox);
			runEnergyInfoBox = null;
		}

		if (!config.showSpecialAttackInfoBox() && specialAttackInfoBox != null) {
			infoBoxManager.removeInfoBox(specialAttackInfoBox);
			specialAttackInfoBox = null;
		}
	}

	@Provides
	DataOrbsInfoBoxConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DataOrbsInfoBoxConfig.class);
	}
}
