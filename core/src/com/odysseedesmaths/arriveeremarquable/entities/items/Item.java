package com.odysseedesmaths.arriveeremarquable.entities.items;

import com.odysseedesmaths.arriveeremarquable.ArriveeGame;
import com.odysseedesmaths.arriveeremarquable.entities.Entite;
import com.odysseedesmaths.arriveeremarquable.map.Case;

public abstract class Item extends Entite {

    private int duree;

    public Item(Case c) {
        super(c);
    }

    public void trigger() {
        ArriveeGame.get().destroy(this);
    }
}
