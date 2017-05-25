package render.engine;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import render.engine.models.TexturedModel;
import tools.DisplayManager;
import tools.Loader;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by levin on 17.03.2017.
 */
public class Main implements Runnable{

    //Variablen

    private DisplayManager displayManager;
    private Loader loader;
    private Renderer renderer;
    private Level level;
    private Player player;
    private List<TexturedModel> linien;
    private List<TexturedModel> toRender;


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
        renderer = new Renderer(loader);
        level = new Level(loader);
        player = new Player(loader);
        linien = new ArrayList<>();
        toRender = new ArrayList<>();

        initModels();
    }

    public void cleanUp(){
        loader.cleanUp();
        renderer.cleanUp();
    }

    public void render(){

        renderer.render(toRender);
    }

    public void update(){
        toRender = new ArrayList<>();

        level.update();
        player.update();

        for(TexturedModel model : level.getToRender()){
            toRender.add(model);
        }

        toRender.add(player.getRenderImage());
    }

    public void initModels(){  //Vorläufig
        TexturedModel line   = new TexturedModel(loader.loadTexture("linie"  ), new Vector2f(0,-0.27f), new Vector2f(1,1));  //Für debug Zwecke

        linien.add(line);
    }







    public static void main (String[] args) {

        new Main().run();

    }

}
