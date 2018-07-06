package jp.co.plise.igarashi_ryo.ex11;

import java.util.Random;
import java.util.Scanner;

public class BattleDemo {
	public static void main(String[] args) {
		Battle battle = new Battle();
		Pokemon myPokemon = new Pikachu(50);
		Pokemon enemy = new Machoke(50);

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();
		
		while(myPokemon.getHp() > 0 && enemy.getHp() > 0) {		
			battle.printEnemyStatus(enemy);
			battle.printStatus(myPokemon);
			battle.printSkills(myPokemon);
		
   			int choise = sc.nextInt();
		
			if(myPokemon.getSpeed() > enemy.getSpeed()) {
				myPokemon.attackEnemy(enemy, myPokemon.getSkill(choise-1));
				
				battle.printEnemyStatus(enemy);
				battle.printStatus(myPokemon);
				
				enemy.attackEnemy(myPokemon, enemy.getSkill(rand.nextInt(enemy.getNumberOfSkill())));
			} else {
				enemy.attackEnemy(myPokemon, enemy.getSkill(rand.nextInt(enemy.getNumberOfSkill())));
				
				battle.printEnemyStatus(enemy);
				battle.printStatus(myPokemon);
				
				myPokemon.attackEnemy(enemy, myPokemon.getSkill(choise-1));
			}
		}
		sc.close();
		
		battle.printEnemyStatus(enemy);
		battle.printStatus(myPokemon);
	}
}
