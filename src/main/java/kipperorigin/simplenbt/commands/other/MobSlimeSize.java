package kipperorigin.simplenbt.commands.other;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Slime;
import org.cubeville.commons.Command;
import org.cubeville.commons.CommandParameterInteger;

import kipperorigin.simplenbt.commands.CommandMapManager;
import kipperorigin.simplenbt.resources.Colorize;

public class MobSlimeSize extends Command {

	public MobSlimeSize() {
		super("mob slime size");
		addBaseParameter(new CommandParameterInteger());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute(Player player, Set<String> flags, Map<String, Object> parameters, List<Object> baseParameters) {
		Map<String, LivingEntity> commandMap = CommandMapManager.getLivingEntityCommandMap();
		if (!commandMap.containsKey(player.getName())) {
			player.sendMessage(Colorize.addColor("&cPlease select a &6slime &cor&6 magma cube&c!"));
			return;
		} else if (commandMap.get(player.getName()) == null || !(commandMap.get(player.getName()) instanceof Slime)) {
			player.sendMessage(Colorize.addColor("&cPlease select a &6slime &cor&6 magma cube&c!"));
			return;
		}
		
		if ((int) baseParameters.get(0) > 32) {
			player.sendMessage(Colorize.addColor("&cPlease use a size smaller than &632&c!"));
			return;
		} else
			((Slime) commandMap.get(player.getName())).setSize((int) baseParameters.get(0));
	}
}

