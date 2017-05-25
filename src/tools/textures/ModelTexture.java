package tools.textures;

import org.lwjgl.util.vector.Vector2f;

/**
 * Created by levin on 13.11.2016.
 */
public class ModelTexture {

    private int textureID;

    private float shineDamper = 1;
    private float reflectivity = 0;

    private Vector2f originalSize;

    public ModelTexture(int id){
        this.textureID = id;
    }

    public int getID(){
        return this.textureID;
    }

    public float getShineDamper() {
        return shineDamper;
    }

    public void setShineDamper(float shineDamper) {
        this.shineDamper = shineDamper;
    }

    public float getReflectivity() {
        return reflectivity;
    }

    public void setReflectivity(float reflectivity) {
        this.reflectivity = reflectivity;
    }

    public Vector2f getOriginalSize() {
        return originalSize;
    }

    public void setOriginalSize(Vector2f originalSize) {
        this.originalSize = originalSize;
    }
}
