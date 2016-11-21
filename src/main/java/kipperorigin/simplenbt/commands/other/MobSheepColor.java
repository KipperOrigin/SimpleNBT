package kipperorigin.simplenbt.commands.other;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.DyeColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.cubeville.commons.Command;
import org.cubeville.commons.CommandParameterEnum;

import kipperorigin.simplenbt.commands.CommandMapManager;
import kipperorigin.simplenbt.resources.Colorize;

public class MobSheepColor extends Command {

	public MobSheepColor() {
		super("mob sheep color");
		addBaseParameter(new CommandParameterEnum(DyeColor.class));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void execute(Player player, Set<String> flags, Map<String, Object> parameters, List<Object> baseParameters) {
		Map<String, LivingEntity> commandMap = CommandMapManager.getLivingEntityCommandMap();
		if (!commandMap.containsKey(player.getName())) {
			player.sendMessage(Colorize.addColor("&cPlease select a &6sheep&c!"));
			return;
		} else if (commandMap.get(player.getName()) == null || !(commandMap.get(player.getName()) instanceof Sheep)) {
			player.sendMessage(Colorize.addColor("&cPlease select a &6sheep&c!"));
			return;
		}
		
		Sheep sheep = (Sheep) commandMap.get(player.getName());
		sheep.setColor((DyeColor) baseParameters.get(0));
	}
}
