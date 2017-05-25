package render.engine.menu;

import org.lwjgl.util.vector.Vector2f;
import render.engine.models.TexturedModel;
import tools.Loader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by levin on 12.05.2017.
 */
public class MenuItem {

    private List<TexturedModel> models;
    private int renderId;
    private Loader loader;
    private Vector2f position;
    private Vector2f scale;

    private ItemHitbox hitbox;

    public MenuItem(Loader loader, Vector2f position, Vector2f scale){
        models = new ArrayList<>();
        renderId = 0;
        this.loader = loader;
        this.position = position;
        this.scale = scale;
    }

    public void addModel(String location){
        models.add(new TexturedModel(loader.loadTexture(location), position, scale));
    }

    public void update(){
        renderId++;
        if(renderId == models.size()){
            renderId = 0;
        }
    }

    public TexturedModel getRender(){
        if(models.size() != 0){
            return models.get(renderId);
        }
        else return null;
    }

    public void cleanUp(){
        loader.cleanUp();
    }

    public Vector2f getScale() {
        return scale;
    }

    public Vector2f getPosition() {
        return position;
    }

    public ItemHitbox getHitbox() {
        return hitbox;
    }
}
