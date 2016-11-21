package kipperorigin.simplenbt.commands.other;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.cubeville.commons.Command;
import org.cubeville.commons.CommandParameterEnum;
import org.bukkit.entity.Zombie;

import kipperorigin.simplenbt.commands.CommandMapManager;
import kipperorigin.simplenbt.resources.Colorize;

public class MobVillagerProfession extends Command {

	public MobVillagerProfession() {
		super("mob villager profession");
		addBaseParameter(new CommandParameterEnum(Profession.class));
	}
	
	@Override
	public void execute(Player player, Set<String> flags, Map<String, Object> parameters, List<Object> baseParameters) {
		Map<String, LivingEntity> commandMap = CommandMapManager.getLivingEntityCommandMap();
		if (!commandMap.containsKey(player.getName())) {
			player.sendMessage(Colorize.addColor("&cPlease select a &6villager &cor&6 zombie villager&c!"));
			return;
		} else if (commandMap.get(player.getName()) == null || (!(commandMap.get(player.getName()) instanceof Zombie) && !(commandMap.get(player.getName()) instanceof Villager))) {
			player.sendMessage(Colorize.addColor("&cPlease select a &6villager &cor&6 zombie villager&c!"));
			return;
		}
		
		if (commandMap.get(player.getName()) instanceof Zombie)
			if (!((Zombie) commandMap.get(player.getName())).isVillager())
				return;
			else
				((Zombie) commandMap.get(player.getName())).setVillagerProfession((Profession) baseParameters.get(0));
		
		if (commandMap.get(player.getName()) instanceof Villager) {
			((Villager) commandMap.get(player.getName())).setProfession((Profession) baseParameters.get(0));
		}

		
	}
}