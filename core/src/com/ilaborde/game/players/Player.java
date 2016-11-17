package com.ilaborde.game.players;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by nacho on 11/16/2016.
 */

public class Player {
    private final int gravity = -5;
    private final int movement = 100;
    private final int height = 90;
    private Vector3 position;
    private Vector3 velocity;

    private Texture texture;

    public Player(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0, 0);
        texture = new Texture("cris.png");
    }

    public void update(float dt) {
        if (position.y > height)
            velocity.add(0, gravity, 0);

        velocity.scl(dt);
        position.add(movement * dt, velocity.y, 0);

        if (position.y < height)
            position.y = height;

        velocity.scl(1 / dt);
    }

    public void render(SpriteBatch sb) {
        sb.draw(texture, position.x, position.y);
    }

    public void jump() {
        velocity.y = 250;
    }

    public Vector3 getPosition(){
        return position;
    }
}
