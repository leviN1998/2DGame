package render.engine;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.vector.Vector2f;
import render.engine.models.TexturedModel;
import tools.Loader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by levin on 20.03.2017.
 */
public class Level {

    private TexturedModel hintergrund;
    private TexturedModel hintergrund2;
    private float speed;
    List<TexturedModel> toRender;

    private boolean running;
    private int counter;

    public Level(Loader loader){
        speed = 0.005f;
        toRender = new ArrayList<>();
        hintergrund = new TexturedModel(loader.loadTexture("Collegeblock"), new Vector2f(0,-0.4f), new Vector2f(1f,1.4f));
        hintergrund2 = new TexturedModel(hintergrund.getTexture(), new Vector2f(hintergrund.getPosition().x+2, hintergrund.getPosition().y), new Vector2f(1f,1.4f));
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
            hintergrund.setPosition(new Vector2f(hintergrund.getPosition().x - speed, hintergrund.getPosition().y));
            hintergrund2.setPosition(new Vector2f(hintergrund2.getPosition().x - speed, hintergrund2.getPosition().y));

            if (hintergrund.getPosition().x <= -2) {
                float delta = (-2f) - hintergrund.getPosition().x;
                hintergrund.setPosition(new Vector2f(2-delta, -0.4f));
            }
            if (hintergrund2.getPosition().x <= -2) {
                float delta = (-2f) - hintergrund2.getPosition().x;
                hintergrund2.setPosition(new Vector2f(2-delta, -0.4f));
            }
        }

        toRender.add(hintergrund);
        toRender.add(hintergrund2);
    }


}
