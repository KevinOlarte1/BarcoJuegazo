package barcojuego.engine.core;

/**
 * Updatable
 * License: 🅮 Public Domain
 *
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.1, 2024-05-14
 * @since 0.1, 2024-05-14
 **/
public interface Updatable {
    void update(double deltaTime);
    void lastUpdate(double deltaTime);
    void postUpdate(double deltaTime);
}
