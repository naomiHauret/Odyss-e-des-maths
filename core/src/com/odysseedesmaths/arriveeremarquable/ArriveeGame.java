package com.odysseedesmaths.arriveeremarquable;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.odysseedesmaths.MiniJeu;

import com.odysseedesmaths.arriveeremarquable.entities.enemies.Add;
import com.odysseedesmaths.arriveeremarquable.map.Terrain;
import com.odysseedesmaths.arriveeremarquable.entities.Heros;
import com.odysseedesmaths.arriveeremarquable.entities.enemies.Signe;

public class ArriveeGame extends MiniJeu {
	private Heros heros;
	private Horde horde;
	private Terrain terrain;
	private Array<Signe> signes;

	public Heros getHeros() {
		return heros;
	}

	public Horde getHorde() {
		return horde;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public Array<Signe> getSignes() {
		return signes;
	}

	@Override
	public void create() {
		super.create();
		terrain = Terrain.create();
		heros = new Heros(terrain.getDepart(), 5);
		signes = new Array<Signe>();
		// Tests placement de signes autour du héros
		signes.add(new Add(terrain.getCase(heros.getCase().i-3, heros.getCase().j-1)));
		signes.add(new Add(terrain.getCase(heros.getCase().i-2, heros.getCase().j+2)));

		addTexture("heros", new Texture(Gdx.files.internal("heros64.png")));
		addTexture("signe", new Texture(Gdx.files.internal("signe64.png")));
		addPathMusique("musicTest", "Arcade_Machine.ogg");;
		setScreen(new ArriveeScreen(this));
	}

	@Override
	public void render() {
		super.render();
	}

	public void dispose() {}
}
