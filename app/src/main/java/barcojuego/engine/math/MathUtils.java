package barcojuego.engine.math;

public class MathUtils {
    public static int clamp(int value, int min, int max) {
        if (value < min)
            return min;
        if (value > max)
            return max;
        return value;
    }

    public static int clamp(int value, int min) {
        if (value < min)
            return min;
        return value;
    }

    public static float clamp(float value, float min, float max) {
        if (value < min)
            return min;
        if (value > max)
            return max;
        return value;
    }

    public static float clamp(float value, float min) {
        if (value < min)
            return min;
        return value;
    }
}
