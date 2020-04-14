package de.phoenixts.phoenix;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamCMD implements CommandExecutor {

	private Main plugin;

	public TeamCMD(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("team").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage((plugin.getConfig().getString("no_console")));
			return true;

		}
		Player p = (Player) sender;

		if (p.hasPermission(("team.message"))) {
			p.sendMessage(plugin.getConfig().getString("Team_message"));
			
			return true;
	} else{
		p.sendMessage(plugin.getConfig().getString("no_perm"));
	}
			return false;
	}

}
