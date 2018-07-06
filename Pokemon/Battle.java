package jp.co.plise.igarashi_ryo.ex11;

import java.util.List;

public class Battle {
	public void printEnemyStatus(Pokemon pokemon) {
		int printHp = (int)((double)pokemon.getHp() / pokemon.getMaxHp() * 10);
		System.out.println("|" + pokemon.getName() + ":L" + pokemon.getLevel());
		System.out.print("|HP: ");
		for(int i = 0; i < printHp; i++) System.out.print("■");
		System.out.println();
		for(int i = 0; i < 15; i++) System.out.print("-");
		System.out.println("→\n");
	}
	
	public void printStatus(Pokemon pokemon) {
		int printHp = (int)((double)pokemon.getHp() / pokemon.getMaxHp() * 10);
		System.out.println("|" + pokemon.getName() + ":L" + pokemon.getLevel());
		System.out.print("|HP: ");
		for(int i = 0; i < printHp; i++) System.out.print("■");
		System.out.println();
		System.out.println("| " + pokemon.getHp() + "/  " + pokemon.getMaxHp());
		for(int i = 0; i < 15; i++) System.out.print("-");
		System.out.println("→\n");
	}
	
	public void printSkills(Pokemon pokemon) {
		List<Skill> skills = pokemon.getSkills();
		System.out.println("-----------------------------------");
		int i = 1;
		for(Skill skill: skills) System.out.println((i++) + " " + skill.getSkillName() + "　　" + skill.getPp() + "/" + skill.getMaxPp() + "　　わざタイプ/" + skill.getSkillType());
		System.out.println("-----------------------------------");
	}
}
