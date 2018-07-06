package jp.co.plise.igarashi_ryo.ex11;

public class Pikachu extends Pokemon {
	public Pikachu(int level) {
		super(level);
		setBaseStatusHp(35);
		setBaseStatusAttack(55);
		setBaseStatusDefence(30);
		setBaseStatusSpeed(90);
		setBaseStatusSpecial(50);
		setStatuses();
		setName("ピカチュウ");
		setType1("でんき");
		addSkill(new Skill("でんきショック", "でんき", 30, 40));
		addSkill(new Skill("なきごえ", "ノーマル", 40, 0));
	}	
}
