package com.github.roitoayanokoji.dice_ver11;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.awt.*;
import java.util.Random;

public class DiceCommandExecutor implements CommandExecutor {

    private final Dice_ver11 plugin;

    public DiceCommandExecutor(Dice_ver11 plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (command.getName().equalsIgnoreCase("dice")){
            if (!(sender instanceof Player)){
                sender.sendMessage("プレイヤーのみ実行可能");
            }
            Player player = (Player) sender;

            int sides = 6;
            //ダイス面の初期値
            if (args.length > 0){
                try {
                    sides = Integer.parseInt(args[0]);
                    if (sides <= 0){
                        player.sendMessage("０面ダイスってなんやねん");
                        return true;
                    }
                } catch (NumberFormatException e) {
                    player.sendMessage("指定が間違っています。");
                    return true;
                }
            }
            //ダイスの処理
            int random = new Random().nextInt(sides) + 1;
            String resultMessage = String.format("%sが%d面ダイスを振って%dが出た", player.getName(), sides, random);
            String pl = "[Dice]";

            //プレイヤーへのメッセージ
            player.sendMessage(pl + "結果 : " + random);

            //broadcast
            Component broadcastMessage = Component.text(resultMessage);
            plugin.getServer().sendMessage(broadcastMessage);
            return true;
        }
        return false;
    }
}
