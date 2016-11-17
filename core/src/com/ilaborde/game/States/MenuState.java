package com.ilaborde.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ilaborde.game.Secuaz;

/**
 * Created by nacho on 11/16/2016.
 */

public class MenuState extends State {
    private Texture background;
    private Texture play;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("bg.jpg");
        play = new Texture("play.png");

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            managerState.set(new PlayState(managerState));
            dispose();
        }
    }

    @Override
    public void update(float delta) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0, 0, Secuaz.WIDTH, Secuaz.HEIGHT);
        sb.draw(play, (Secuaz.WIDTH / 2) - (play.getWidth() / 2), Secuaz.HEIGHT / 4);
        sb.end();
    }

    @Override
    public void dispose() {
        background.dispose();
        play.dispose();
    }
}
