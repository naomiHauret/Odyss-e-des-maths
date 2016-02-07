package com.odysseedesmaths;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.odysseedesmaths.menus.ScreenPause;
import com.odysseedesmaths.minigames.arriveeremarquable.ArriveeRemarquable;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new OdysseeDesMaths(), config);
	}
}
