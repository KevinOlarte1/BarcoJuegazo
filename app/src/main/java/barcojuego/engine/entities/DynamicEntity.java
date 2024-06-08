package barcojuego.engine.entities;

import barcojuego.engine.math.Vector2;

import java.awt.image.BufferedImage;

/**
 * DynamicEntity
 * License: 🅮 Public Domain
 *
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.1, 2024-05-22
 * @since 0.1, 2024-05-22
 **/
public abstract class DynamicEntity extends Entity {
    private Vector2 velocity;
    private float linearVelocity;
    private float acceleration;

    public DynamicEntity(float x, float y, float width, float height, float hp, float damage,
                          float colliderXLeft, float colliderXRight, float colliderYUp, float colliderYDown, int colliderMask,
                          BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration ) {
        super(x, y, width, height, hp, damage, colliderXLeft, colliderXRight, colliderYUp, colliderYDown, colliderMask, sprite);
        initDynamicEntity(velocityX, velocityY, linearVelocity, acceleration);
    }

    private void initDynamicEntity( float velocityX, float velocityY, float linearVelocity, float acceleration) {
        this.velocity = new Vector2(velocityX, velocityY);
        this.linearVelocity = linearVelocity;
        this.acceleration = acceleration;
    }

    public DynamicEntity(float x, float y, float width, float height, float hp, float damage,
                          float colliderOffset, int colliderMask, BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration) {
        this(x, y, width, height, hp, damage, colliderOffset, colliderOffset, colliderOffset, colliderOffset, colliderMask, sprite, velocityX, velocityY, linearVelocity, acceleration);
    }

    public DynamicEntity(float x, float y, float width, float height, float hp, float damage,
                          float colliderOffsetX, float colliderOffsetY, int colliderMask, BufferedImage sprite, float velocityX, float velocityY, float linearVelocity, float acceleration) {
        this(x, y, width, height, hp, damage, colliderOffsetX, colliderOffsetX, colliderOffsetY, colliderOffsetY, colliderMask, sprite, velocityX, velocityY, linearVelocity, acceleration);
    }

    public DynamicEntity(float x, float y, float width, float height, float hp, float damage, BufferedImage sprite,  float velocityX, float velocityY, float linearVelocity, float acceleration) {
        super(x, y, width, height, hp, damage, sprite);
        initDynamicEntity(velocityX, velocityY, linearVelocity, acceleration);
    }

    @Override
    public void update(double deltaTime) {
        linearVelocity += (float) (acceleration * deltaTime);
        velocity.normalize().mul(linearVelocity);
        getPosition().mulAdd(velocity, (float) deltaTime);
    }

    public void setVelocity(float x, float y) {
        this.velocity.setX(x);
        this.velocity.setY(y);
    }

    @Override
    public abstract void lastUpdate(double deltaTime);


    @Override
    public abstract void postUpdate(double deltaTime);

}
