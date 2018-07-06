package jp.co.plise.igarashi_ryo.ex11;

public class Machoke extends Pokemon {
	public Machoke(int level) {
		super(level);
		setBaseStatusHp(80);
		setBaseStatusAttack(100);
		setBaseStatusDefence(70);
		setBaseStatusSpeed(45);
		setBaseStatusSpecial(50);
		setStatuses();
		setName("ゴーリキー");
		setType1("かくとう");
		addSkill(new Skill("からてチョップ", "かくとう", 25, 50));
		addSkill(new Skill("けたぐり", "かくとう", 20, 50));
		addSkill(new Skill("にらみつける", "ノーマル", 30, 0));
	}	
}
