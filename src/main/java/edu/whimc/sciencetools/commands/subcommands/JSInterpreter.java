package edu.whimc.sciencetools.commands.subcommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import edu.whimc.sciencetools.ScienceTools;
import edu.whimc.sciencetools.commands.BaseToolCommand.SubCommand;
import edu.whimc.sciencetools.utils.Utils;
import edu.whimc.sciencetools.utils.Utils.Placeholder;

public class JSInterpreter extends AbstractSubCommand {

	public JSInterpreter(ScienceTools plugin, SubCommand subCmd) {
		super(plugin, subCmd);
	}

	@Override
	protected void notEnoughArgs(CommandSender sender) {
		Utils.msg(sender, "&7Custom syntax:");
		for (Placeholder ph : Placeholder.values()) {
			Utils.msg(sender, " " + ph.fullUsage());
		}
	}

	@Override
	public boolean commandRoutine(CommandSender sender, String[] args) {

		StringBuilder builder = new StringBuilder();
		for (int ind = 0; ind < args.length; ind++) {
			builder.append(args[ind]).append(" ");
		}

		String exp = builder.toString().trim();
		if (sender instanceof Player) {
		    Player player = (Player) sender;
			exp = plugin.getToolManager().fillIn(player, builder.toString().trim(), player.getLocation());
		}
		Object res = Utils.executeExpressionDebug(sender, exp, true);

		if (res == null) {
			return false;
		}

		Utils.msg(sender, res.toString());

		return true;
	}

}
