package com.ilaborde.game.States;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    protected OrthographicCamera cam;
    protected Vector3 mouse;
    protected GameStateManager managerState;

    protected State(GameStateManager gsm){
        this.managerState = gsm;
        this.cam = new OrthographicCamera();
        this.mouse = new Vector3();
    }

    protected abstract void handleInput();

    public abstract void update(float delta);

    public abstract void render(SpriteBatch sb);
    public abstract void dispose();
}
