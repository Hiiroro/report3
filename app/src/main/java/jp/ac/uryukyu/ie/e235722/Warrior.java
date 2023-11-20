package jp.ac.uryukyu.ie.e235722;

/**
 * 戦士クラス。
 *  String name; //戦士の名前
 *  int hitPoint; //戦士のHP
 *  int attack; //戦士の攻撃力
 *  boolean dead; //戦士の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class Warrior extends Hero{

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 戦士名
     * @param maximumHP 戦士のHP
     * @param attack 戦士の攻撃力
     */
    public Warrior (String _name, int _maximumHP, int _attack) {
        super(_name, _maximumHP, _attack);
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    @Override
    public void wounded(int damage){
        int nowHp = getHitPoint() - damage;
        setHitPoint(nowHp);
        if( nowHp < 0 ) {
            setDead(true);
            System.out.printf("戦士%sは道半ばで力尽きてしまった。\n", getName());
        }
    }

    public void attackWithWeponSkill(LivingThing opponent){
        if(isDead() == false){
            int damage = (int)(this.getAttack() * 1.5);
            System.out.printf("%sの攻撃！ウェポンスキルを発動！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            opponent.wounded(damage);
        }


    }
}