package render.engine.debug.game;

import de.levin.lib.engine.Loader;
import de.levin.lib.engine.entity.BasicTextureObject;
import de.levin.lib.engine.graphics.rendering.Renderer;
import org.lwjgl.util.vector.Vector2f;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by levin on 20.06.2017.
 */
public class NewPlayer {

    private List<BasicTextureObject> characters;
    private Vector2f position;

    public NewPlayer(Loader loader, Vector2f startPos){
        this.position = startPos;
        Vector2f scale = new Vector2f(3,3);
        characters = new ArrayList<>();
        for(int i = 0; i<8; i++){
            characters.add(new BasicTextureObject(position, scale, "res/TheFinalWalk/"+ (i+1) + ".png", loader));
            characters.get(i).rotate(-5);
        }
    }

    private int i = 0;
    private int bild = 0;
    public void update(){
        if (i++ == 10){
            i = 0;
            if(bild++ >= 7){
                bild = 0;
            }
        }
    }

    public void process(Renderer renderer){
        renderer.process(characters.get(bild));
    }

}
