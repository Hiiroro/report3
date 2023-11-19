package jp.ac.uryukyu.ie.e235722;

/**
 * 生き物クラス。
 *  String name; //敵の名前
 *  int hitPoint; //敵のHP
 *  int attack; //敵の攻撃力
 *  boolean dead; //敵の生死状態。true=死亡。
 * Created by tnal on 2016/11/13.
 */
public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。名前、最大HP、攻撃力を指定する。
     * @param name ヒーロー名
     * @param maximumHP ヒーローのHP
     * @param attack ヒーローの攻撃力
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
     * Enemyへ攻撃するメソッド。
     * attackに応じて乱数でダメージを算出し、hero.wounded()によりダメージ処理を実行。
     * @param e 攻撃対象
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
     * 敵のHPを返却するメソッド。
     * 
     * @return 敵のHP
     */
    public int getHitPoint(){
        return this.hitPoint;
    }

    /**
     * 敵の攻撃力を返却するメソッド。
     * 
     * @return 敵の攻撃力
     */
    public int getAttack(){
        return this.attack;
    }

    /**
     * 敵の名前を設定するメソッド。
     * 
     * @param name 敵の名前
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 敵のHPを設定するメソッド。
     * 
     * @param hitPoint 敵のHP
     */
    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    /**
     * 敵の攻撃力を設定するメソッド。
     * 
     * @param attack 敵の攻撃力
     */
    public void setAttack(int attack){
        this.attack = attack;
    }

    /**
     * 敵の生死状態を設定するメソッド。
     * 
     * @param dead 敵の生死状態
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }

}