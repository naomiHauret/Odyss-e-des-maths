package com.odysseedesmaths.menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.odysseedesmaths.Assets;

public class MenuPause extends Menu {
    private TextButton retourJeu, recommencer,quitter;
    private TextButtonStyle txtButtonStyle=null;

    public MenuPause(){
        super(10, new Color(255f, 255f, 255f, 1), "fonts/pixel-life.TTF");

        Skin skin = new Skin();
        skin.addRegions(Assets.getManager().get(Assets.UI_TEST, TextureAtlas.class));

        txtButtonStyle = new TextButton.TextButtonStyle();

        txtButtonStyle.font = font;
        txtButtonStyle.up = skin.getDrawable("default-round");
        txtButtonStyle.down = skin.getDrawable("default-round-down");

        retourJeu = new TextButton("Retour",txtButtonStyle);
        recommencer = new TextButton("Recommencer",txtButtonStyle);
        quitter = new TextButton("Quitter",txtButtonStyle);

        Table tableau = new Table();
        tableau.setFillParent(true);
        //tableau.row().height(Gdx.graphics.getHeight() / 3);
        tableau.add(retourJeu).width(Gdx.graphics.getWidth() / 3).pad(10);
        tableau.getCell(retourJeu).expand();
        tableau.row();
        tableau.add(recommencer).width(Gdx.graphics.getWidth() / 3).pad(10);
        tableau.getCell(recommencer).expand();
        tableau.row();
        tableau.add(quitter).width(Gdx.graphics.getWidth() / 3).pad(10);
        tableau.getCell(quitter).expand();

        addActor(tableau);
    }

    public TextButton getRetourJeu() {
        return retourJeu;
    }

    public TextButton getRecommencer() {
        return recommencer;
    }

    public TextButton getQuitter() {
        return quitter;
    }

    public void setListener(EventListener listener) {
        retourJeu.addListener(listener);
        recommencer.addListener(listener);
        quitter.addListener(listener);
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
