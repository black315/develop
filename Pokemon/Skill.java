package jp.co.plise.igarashi_ryo.ex11;

import java.util.Arrays;
import java.util.List;

public class Skill {
	private String skillName;
	private String skillType;
	private String skillAttackType;
	private int maxPp;
	private int pp;
	private int power;
	
	private List<String> phisicalAttacks = Arrays.asList("ノーマル", "どく", "かくとう", "じめん", "ひこう", "いわ", "むし", "ゴースト");
	private List<String> specialAttacks = Arrays.asList("ほのお", "みず", "でんき", "くさ", "こおり", "エスパー", "ドラゴン");
	
	public Skill(String skillName, String skillType, int pp, int power) {
		this.skillName = skillName;
		this.skillType = skillType;
		this.pp = pp;
		this.power = power;
		maxPp = pp;
		setSkillAttackType(this);
	}
	
	public String getSkillName() {
		return skillName;
	}
	
	public String getSkillType() {
		return skillType;
	}
	
	public String getSkillAttackType() {
		return skillAttackType;
	}
	
	public int getMaxPp() {
		return maxPp;
	}
	
	public int getPp() {
		return pp;
	}
	
	public int getPower() {
		return power;
	}
	
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	
	public void setSkillType(String skillType) {
		this.skillType = skillType;
	}
	
	public void setSkillAttackType(Skill skill) {
		if(phisicalAttacks.contains(skillType)) skillAttackType = "物理攻撃";
		else if(specialAttacks.contains(skillType)) skillAttackType = "特殊攻撃";
		else skillAttackType = "";
	}
	
	public void changePp(int pp) {
		this.pp += pp;
		if(this.pp < 0) this.pp = 0;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
}
