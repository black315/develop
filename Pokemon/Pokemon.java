package jp.co.plise.igarashi_ryo.ex11;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Pokemon {
	private String name;
	private String type1;
	private String type2;
	private String characteristic;
	// private String nature;
	private int level = 1;
	private int exp = 0;
	private int individualValue;
	private int baseStatusHp;
	private int baseStatusAttack;
	private int baseStatusDefence;
	private int baseStatusSpeed;
	private int baseStatusSpecial;
	private int maxHp;
	private int hp;
	private int attack;
	private int defence;
	private int speed;
	private int special;
	private String state = "健康";
	
	private List<Skill> skills = new ArrayList<>();

	public Pokemon(int level) {
		if(level < 1) this.level = 1;
		else if(level > 100) this.level = 100;
		else this.level = level;
	}

	public String getName() {
		return name;
	}

	public String getType1() {
		return type1;
	}

	public String getType2() {
		return type2;
	}

	public String getCharacteristic() {
		return characteristic;
	}

	public int getLevel() {
		return level;
	}
	
	public int getExp() {
		return exp;
	}
	
	public int getIndividualValue() {
		return individualValue;
	}
	
	public int getBaseStatusHp() {
		return baseStatusHp;
	}
	
	public int getBaseStatusAttack() {
		return baseStatusAttack;
	}
	
	public int getBaseStatusDefence() {
		return baseStatusDefence;
	}
	
	public int getBaseStatusSpeed() {
		return baseStatusSpeed;
	}
	
	public int getBaseStatusSpecial() {
		return baseStatusSpecial;
	}
	
	public int getMaxHp() {
		return maxHp;
	}

	public int getHp() {
		return hp;
	}

	public int getAttack() {
		return attack;
	}

	public int getDefence() {
		return defence;
	}

	public int getSpeed() {
		return speed;
	}

	public int getSpecial() {
		return special;
	}
	
	public String getState() {
		return state;
	}
	
	public List<Skill> getSkills() {
		return skills;
	}
	
	public int getNumberOfSkill() {
		return skills.size();
	}
	
	public Skill getSkill(int i) {
		return skills.get(i);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public void setCharacteristic(String characteristic) {
		this.characteristic = characteristic;
	}

//	public void setLevel(int level) {
//		this.level = level;
//	}
	
	public void plusExp(int exp) {
		this.exp += exp;
		if(this.exp >= (level % 10) * 1000) {
			level++;
			this.exp = 0;
			setStatuses();
		}
	}

	public void changeHp(int hp) {
		this.hp += hp;
		if(this.hp > maxHp) this.hp = maxHp;
		else if(this.hp < 0) this.hp = 0;
	}
	
	public void setBaseStatusHp(int baseStatusHp) {
		this.baseStatusHp = baseStatusHp;
	}

	public void setBaseStatusAttack(int baseStatusAttack) {
		this.baseStatusAttack = baseStatusAttack;
	}	

	public void setBaseStatusDefence(int baseStatusDefence) {
		this.baseStatusDefence = baseStatusDefence;
	}
	
	public void setBaseStatusSpeed(int baseStatusSpeed) {
		this.baseStatusSpeed = baseStatusSpeed;
	}
	
	public void setBaseStatusSpecial(int baseStatusSpecial) {
		this.baseStatusSpecial = baseStatusSpecial;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public void addSkill(Skill skill) {
		skills.add(skill);
	}
	
	public void setStatuses() {		
		Random rand = new Random();
		individualValue = rand.nextInt(16) + 1;
		
		hp = ((baseStatusHp * 2 + individualValue) * level / 100) + 10 + level;
		attack = (baseStatusAttack * 2 + individualValue) * level / 100 + 5;
		defence = (baseStatusDefence * 2 + individualValue) * level / 100 + 5;
		speed = (baseStatusSpeed * 2 + individualValue) * level / 100 + 5;
		special = (baseStatusSpecial * 2 + individualValue) * level / 100 + 5;
		
		maxHp = hp;
	}
	
	public void attackEnemy(Pokemon enemy, Skill skill) {
		int damage;
		System.out.println(this.getName() + "の" + skill.getSkillName());
		Random rand = new Random();
		if(skill.getSkillAttackType().equals("物理攻撃")) damage = (((level * 2 / 5 + 2) * skill.getPower() * this.getAttack() / enemy.getDefence()) / 50 + 2) * (rand.nextInt(16) + 85) / 100;
		else if(skill.getSkillAttackType().equals("特殊攻撃")) damage = (((level * 2 / 5 + 2) * skill.getPower() * this.getSpecial() / enemy.getSpecial()) / 50 + 2) * (rand.nextInt(16) + 85) / 100;
		else damage = 0;
		if(skill.getPower() == 0) System.out.println("しかしなにもおこらなかった");
		skill.changePp(-1);
		enemy.changeHp(-damage);
		if(enemy.getHp() <= 0) {
			System.out.println(enemy.getName() + "は倒れた");
//			System.out.println(this.getName() + "は" + enemy.getLevel() + "けいけんちをえた");
			this.plusExp(enemy.getLevel());
		}
	}

}
