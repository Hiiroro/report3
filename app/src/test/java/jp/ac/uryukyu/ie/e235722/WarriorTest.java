package jp.ac.uryukyu.ie.e235722;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class WarriorTest {
    /**
     * 倒れたはずの敵は攻撃できないことを検証。
     * 検証手順
     *  (1) ヒーローと敵を準備。ヒーローの攻撃力は敵を一撃で倒せるほど強い状態とする。
     *  (2) ヒーローが殴り、敵も殴る。敵は一撃で倒されていることを期待。
     *  (3) 敵が死んだ状態ならば攻撃できないはず。
     * 　　つまり攻撃実行してもヒーローのHPは減っていないことを期待。これを検証する。
     */
    @Test
    void attackWithWeponSkillTest() {
        int attack = 100;
        Warrior demoWarrior = new Warrior("デモ戦士", 100, attack);
        Enemy slime1 = new Enemy("スライムもどき1", 150, 30);
        Enemy slime2 = new Enemy("スライムもどき2", 150, 30);
        Enemy slime3 = new Enemy("スライムもどき3", 150, 30);

        ArrayList<Enemy> slimes =new ArrayList<>();
        slimes.add(slime1);
        slimes.add(slime2);
        slimes.add(slime3);

        for (Object s : slimes){
            Enemy slime = (Enemy)s;
            demoWarrior.attackWithWeponSkill(slime);
            int nowSlimeHp= slime.getHitPoint();

            assertEquals(nowSlimeHp,0);
        }
    }
}
    