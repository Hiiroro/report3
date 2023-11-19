package jp.ac.uryukyu.ie.e235722;

/**
 * 生き物クラス。
 *  String name; //生物の名前
 *  int hitPoint; //生物のHP
 *  int attack; //生物の攻撃力
 *  boolean dead; //生物の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name 生物名
     * @param maximumHP 生物のHP
     * @param attack 生物の攻撃力
     */
    public LivingThing (String _name, int _maximumHP, int _attack) {
        this.name = _name;
        this.hitPoint = _maximumHP;
        this.attack = _attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    public boolean isDead(){
        return this.dead;
    }

    public String getName(){
        return this.name;
    }

    

    /**
     * 対象へ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、opponent.wounded()によりダメージ処理を実行。
     * @param opponent 攻撃対象
     */
    public void attack(LivingThing opponent){
        if(dead == false){
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.name, damage);
            opponent.wounded(damage);
        }
    }

    /**
     * 自身へ攻撃されたときのダメージ処理をするメソッド。
     * 指定されたダメージを hitPoint から引き、死亡判定を行う。
     * @param damage 受けたダメージ
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
    

    /**
     * 生物のHPを返却するメソッド。
     * 
     * @return 敵のHP
     */
    public int getHitPoint(){
        return this.hitPoint;
    }

    /**
     * 生物の攻撃力を返却するメソッド。
     * 
     * @return 生物の攻撃力
     */
    public int getAttack(){
        return this.attack;
    }

    /**
     * 生物の名前を設定するメソッド。
     * 
     * @param name 生物の名前
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 生物のHPを設定するメソッド。
     * 
     * @param hitPoint 生物のHP
     */
    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    /**
     * 生物の攻撃力を設定するメソッド。
     * 
     * @param attack 生物の攻撃力
     */
    public void setAttack(int attack){
        this.attack = attack;
    }

    /**
     * 生物の生死状態を設定するメソッド。
     * 
     * @param dead 生物の生死状態
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }

}