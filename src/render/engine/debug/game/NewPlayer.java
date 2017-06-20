package render.engine.debug.game;

import de.levin.lib.engine.Loader;
import de.levin.lib.engine.entity.BasicTextureObject;
import org.lwjgl.util.vector.Vector2f;

import java.util.List;

/**
 * Created by levin on 20.06.2017.
 */
public class NewPlayer {

    private List<BasicTextureObject> characters;

    public NewPlayer(Loader loader){
        Vector2f pos = new Vector2f(0,0);
        Vector2f scale = new Vector2f(1,1);
        for(int i = 0; i<8; i++){
            characters.add(new BasicTextureObject(pos, scale, "res/TheFinalWalk/"+ (i+1), loader));
        }
    }

}
