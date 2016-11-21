package kipperorigin.simplenbt.commands.block.sign;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.cubeville.commons.Command;
import org.cubeville.commons.CommandParameterInteger;
import org.cubeville.commons.CommandParameterString;

import kipperorigin.simplenbt.commands.CommandMapManager;
import kipperorigin.simplenbt.resources.Colorize;

public class BlockSignSet extends Command {

	public BlockSignSet() {
		super("block sign set");
		addBaseParameter(new CommandParameterInteger());
		addBaseParameter(new CommandParameterString());
	}

	@Override
	public void execute(Player player, Set<String> flags, Map<String, Object> parameters, List<Object> baseParameters) {
		Map<String, Block> commandMap = CommandMapManager.getBlockCommandMap();
		
		if (!commandMap.containsKey(player.getName())) {
			player.sendMessage(Colorize.addColor("&cPlease select a &6sign&c!"));
			return;
		} else if (commandMap.get(player.getName()) == null) {
 			player.sendMessage(Colorize.addColor("&cPlease select a &6sign&c!"));
			return;
		} else if (!(commandMap.get(player.getName()).getState() instanceof Sign)) {
 			player.sendMessage(Colorize.addColor("&cPlease select a &6sign&c!"));
			return;
		}
		
		if ((int) baseParameters.get(0) > 4 || (int) baseParameters.get(0) < 0) {
 			player.sendMessage(Colorize.addColor("&cInvalid sign line!"));
			return;
		}
		
		Block block = commandMap.get(player.getName());
		Sign sign = (Sign) block.getState();
		sign.setLine((int) baseParameters.get(0) - 1, Colorize.addColor((String) "&0" + baseParameters.get(1)));
		sign.update();
	}
}