package barcojuego.game.utils;

import barcojuego.engine.math.Vector2;

/**
 * Direction
 * License: 🅮 Public Domain
 *
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.1, 2024-05-24
 * @since 0.1, 2024-05-24
 **/
public enum Direction {
    LEFT(new Vector2(-1, 0)), RIGHT(new Vector2(1, 0)), UP(new Vector2(0, -1)), DOWN(new Vector2(0, 1));

    final Vector2 direction;
    Direction(Vector2 value) {
        this.direction = value;
    }

    public Vector2 getDirection() {
        return direction;
    }
}
