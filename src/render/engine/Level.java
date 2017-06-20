package render.engine;

import de.levin.lib.engine.Loader;
import de.levin.lib.engine.entity.BasicTextureObject;
import de.levin.lib.engine.graphics.rendering.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;
import render.engine.models.TexturedModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by levin on 20.03.2017.
 */
public class Level {

    private BasicTextureObject hintergrund1;
    private BasicTextureObject hintergrund2;
    private float speed;
    List<TexturedModel> toRender;

    private boolean running;
    private int counter;

    public Level(Loader loader){
        speed = 0.05f;
        toRender = new ArrayList<>();
        hintergrund1 = new BasicTextureObject(new Vector2f(0,0), new Vector2f(20,20), "res/package2/collegeblock.png", loader);
        Vector2f pos = new Vector2f(hintergrund1.getPosition().x + hintergrund1.getWidth() - 1.2f, hintergrund1.getPosition().y);
        hintergrund2 = new BasicTextureObject(pos, new Vector2f(20,20), "res/package2/collegeblock.png", loader);

        running = true;
    }

    public void update(){
        if(counter < 200){
            counter++;
        }
        if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
            if(counter > 150){
                if(!running){
                    running = true;
                }else {
                    running = false;
                }
                counter = 0;
            }

        }
        speed += 0.000000001f;
        toRender = new ArrayList<>();
        updateHintergrund();
    }

    public List<TexturedModel> getToRender(){
        return toRender;
    }

    public void updateHintergrund(){
        if(running) {
            hintergrund1.move(-speed, 0);
            hintergrund2.move(-speed, 0);



            if (hintergrund1.getPosition().x <= -19) {
                //float delta = (-2f) - hintergrund2.getPosition().x;
                Vector2f pos = new Vector2f(hintergrund2.getPosition().x + hintergrund2.getWidth() - 1.2f, hintergrund2.getPosition().y);
                hintergrund1.setPosition(pos);
            }
            if(hintergrund2.getPosition().x <= -19) {
                Vector2f pos = new Vector2f(hintergrund1.getPosition().x + hintergrund1.getWidth() - 1.2f, hintergrund1.getPosition().y);
                hintergrund2.setPosition(pos);
            }
        }

    }

    public void process(de.levin.lib.engine.graphics.rendering.Renderer renderer){
        renderer.process(hintergrund1);
        renderer.process(hintergrund2);
    }


}
