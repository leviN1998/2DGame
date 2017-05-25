package render.engine.models;

import org.lwjgl.util.vector.Vector2f;
import tools.textures.ModelTexture;

/**
 * Created by levin on 17.03.2017.
 */
public class TexturedModel {

    private ModelTexture texture;

    private Vector2f position;
    private Vector2f scale;

    public TexturedModel(ModelTexture texture, Vector2f position, Vector2f scale) {
        this.texture = texture;
        this.position = position;
        this.scale = scale;
    }

    public ModelTexture getTexture() {
        return texture;
    }

    public Vector2f getPosition() {
        return position;
    }

    public Vector2f getScale() {
        return scale;
    }

    public void setTexture(ModelTexture texture) {
        this.texture = texture;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public void setScale(Vector2f scale) {
        this.scale = scale;
    }
}
