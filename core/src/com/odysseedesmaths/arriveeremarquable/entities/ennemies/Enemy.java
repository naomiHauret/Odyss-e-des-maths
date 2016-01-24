package com.odysseedesmaths.arriveeremarquable.entities.ennemies;

import com.badlogic.gdx.math.MathUtils;
import com.odysseedesmaths.arriveeremarquable.ArriveeGame;
import com.odysseedesmaths.arriveeremarquable.entities.Entity;
import com.odysseedesmaths.arriveeremarquable.entities.Hero;
import com.odysseedesmaths.arriveeremarquable.entities.Character;
import com.odysseedesmaths.arriveeremarquable.entities.items.Item;
import com.odysseedesmaths.arriveeremarquable.entities.items.Shield;
import com.odysseedesmaths.arriveeremarquable.map.Case;

public abstract class Enemy extends Character {

    private boolean alive;

    public Enemy(Case c) {
        super(c);
        alive = true;
    }

    public Enemy() {
        this(null);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public boolean meet(Entity e) {
        boolean continuer = true;

        if (e instanceof Hero) {
            if (ArriveeGame.get().activeItems.get(Shield.class) == null) ((Hero) e).decreasePDV();
            ArriveeGame.get().destroy(this);
            setAlive(false);
        } else if (e instanceof Item) {
            ArriveeGame.get().destroy((Item)e);
        }

        return continuer && isAlive();
    }

    public abstract void act();


    /**********
     * STATIC *
     **********/

    private static final int STICKY = 0;
    private static final int SMART = 1;
    private static final int SUPERSMART = 2;
    private static final int GREED = 3;
    private static final int LOST = 4;
    private static final int NB_TYPES = 5;

    public static final int SPAWN_MIN_DISTANCE = 7;
    public static final int SPAWN_MAX_DISTANCE = 20;
    public static final double SPAWN_CHANCE = 0.6;

    private static int[] max;
    private static int[] pop;

    public static void init() {
        pop = new int[NB_TYPES];
        for (int i=0; i < NB_TYPES; i++)
            pop[i] = 0;

        max = new int[NB_TYPES];
        max[STICKY] = 1;
        max[SMART] = 1;
        max[SUPERSMART] = 0;
        max[GREED] = 1;
        max[LOST] = 10;
    }

    public static boolean popFull(int enemy) {
        return pop[enemy] >= max[enemy];
    }

    public static boolean popFull() {
        boolean res = true;

        for (int i=0; i < NB_TYPES; i++) {
            res = res && popFull(i);
        }

        return res;
    }

    public static void increasePop(Enemy e) {
        if (e instanceof Sticky) pop[STICKY]++;
        else if (e instanceof Smart) pop[SMART]++;
        else if (e instanceof SuperSmart) pop[SUPERSMART]++;
        else if (e instanceof Greed) pop[GREED]++;
        else pop[LOST]++;
    }

    public static void decreasePop(Enemy e) {
        if (e instanceof Sticky) pop[STICKY]--;
        else if (e instanceof Smart) pop[SMART]--;
        else if (e instanceof SuperSmart) pop[SUPERSMART]--;
        else if (e instanceof Greed) pop[GREED]--;
        else pop[LOST]--;
    }

    public static Enemy make() {
        Enemy enemy;
        int num;

        do {
            num = MathUtils.random(NB_TYPES - 1);
        } while (popFull(num));

        switch (num) {
        case STICKY: enemy = new Sticky(); break;
        case SMART: enemy = new Smart(); break;
        case SUPERSMART: enemy = new SuperSmart(); break;
        case GREED: enemy = new Greed(); break;
        default: enemy = new Lost(); break;
        }

        increasePop(enemy);

        return enemy;
    }
}
