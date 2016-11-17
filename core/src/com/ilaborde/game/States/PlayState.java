package com.ilaborde.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.ilaborde.game.Secuaz;
import com.ilaborde.game.players.Hole;
import com.ilaborde.game.players.Player;

/**
 * Created by nacho on 11/16/2016.
 */

public class PlayState extends State {
    private Player player;
    private Texture bg;
    private static final int holeSpace = 125;
    private static final int holeCount = 2;

    private Array<Hole> holes;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        player = new Player(10, 80);
        cam.setToOrtho(false, Secuaz.WIDTH / 2, Secuaz.HEIGHT / 2);
        bg = new Texture("bg-play.jpg");
        holes = new Array<Hole>();

        for (int i = 0; i <= holeCount; i++) {

            holes.add(new Hole(i * (holeSpace + Hole.HoleWidth)));
        }
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            player.jump();
        }
    }

    @Override
    public void update(float delta) {
        handleInput();
        player.update(delta);
        cam.position.x = player.getPosition().x + 80;

        for (Hole hole : holes) {
            if (cam.position.x - (cam.viewportWidth / 2) > hole.getPosition().x + Hole.HoleWidth) {
                hole.reposition(hole.getPosition().x + ((holeSpace + Hole.HoleWidth) * 3));
            }
        }
        cam.update();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth / 2), 0);
        player.render(sb);
        for (Hole hole : holes) {
            hole.render(sb);
        }
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
