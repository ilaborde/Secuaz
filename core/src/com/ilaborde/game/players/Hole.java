package com.ilaborde.game.players;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.influencers.ColorInfluencer;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by nacho on 11/16/2016.
 */

public class Hole {
    public static final int HoleWidth = 64;
    private static final int fluctiation = 130;
    private static final int flucGap = 100;
    private Texture texture;
    private Vector2 position;
    private Random random;

    public Hole(float x) {
        texture = new Texture("hole.png");
        random = new Random();
        position = new Vector2(random.nextInt(fluctiation) + flucGap + x, 80);
    }

    public void render(SpriteBatch sb) {
        sb.draw(texture, position.x, position.y);
    }

    public Vector2 getPosition(){
        return position;
    }

    public void reposition(float x){
        position.set(random.nextInt(fluctiation) + x, 80);
    }
}
