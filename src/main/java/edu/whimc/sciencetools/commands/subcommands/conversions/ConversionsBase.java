package edu.whimc.sciencetools.commands.subcommands.conversions;

import org.bukkit.command.CommandSender;

import edu.whimc.sciencetools.ScienceTools;
import edu.whimc.sciencetools.commands.BaseToolCommand.SubCommand;
import edu.whimc.sciencetools.commands.subcommands.AbstractSubCommand;
import edu.whimc.sciencetools.utils.Utils;

public class ConversionsBase extends AbstractSubCommand {

	public ConversionsBase(ScienceTools plugin, SubCommand subCmd) {
		super(plugin, subCmd);
	}

	@Override
	public boolean commandRoutine(CommandSender sender, String[] args) {
		Utils.msg(sender, "This command is unimplemented!");
		return false;
	}

}
