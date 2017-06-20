package render.engine;


import de.levin.lib.engine.Loader;
import de.levin.lib.engine.graphics.rendering.*;
import de.levin.lib.engine.graphics.rendering.Renderer;
import de.levin.lib.engine.graphics.shaders.Shader;
import de.levin.lib.engine.toolbox.DisplayManager;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import render.engine.debug.game.BackGround;
import render.engine.models.TexturedModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by levin on 17.03.2017.
 */
public class Main implements Runnable{

    //Variablen

    private DisplayManager displayManager;
    private Loader loader;
    private de.levin.lib.engine.graphics.rendering.Renderer renderer;
    private Shader shader;
    private BackGround bg;
    private Player player;
    private List<TexturedModel> linien;


    @Override
    public void run() {
        DisplayManager.createDisplay();

        init();

        while(!Display.isCloseRequested()){
            renderer.prepare();

            update();

            render();

            DisplayManager.updateDisplay();
        }


        cleanUp();
        DisplayManager.closeDisplay();
    }

    public void init(){
        displayManager = new DisplayManager();
        loader = new Loader();
        shader = new Shader();
        renderer = new Renderer(shader);
        bg = new BackGround(loader, "res/package2/collegeblock.png", 4, new Vector2f(20,20), 0.8f);
        //player = new Player(loader);
        linien = new ArrayList<>();

        initModels();
    }

    public void cleanUp(){
        loader.cleanUp();
        renderer.cleanUp();
    }

    public void render(){
        //process
        bg.process(renderer);

        renderer.prepare();

        renderer.render();
    }

    public void update(){

        bg.update(3f);
        //player.update();


    }

    public void initModels(){  //Vorläufig
        //TexturedModel line   = new TexturedModel(loader.loadTexture("linie"  ), new Vector2f(0,-0.27f), new Vector2f(1,1));  //Für debug Zwecke

        //linien.add(line);
    }







    public static void main (String[] args) {

        new Main().run();

    }

}
