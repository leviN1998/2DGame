package render.engine;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector2f;
import render.engine.debug.DebugRenderer;
import render.engine.menu.ItemHitbox;
import render.engine.models.TexturedModel;
import tools.DisplayManager;
import tools.Loader;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by levin on 12.05.2017.
 */
public class Menu implements Runnable{

    public static void main(String[] args){
        new Menu().run();
    }

    private Renderer renderer;
    private Loader loader;
    private List<TexturedModel> toRender;
    private MenuCalc menu;

    private ItemHitbox hitbox;
    private DebugRenderer debugRenderer;


    @Override
    public void run() {
        DisplayManager.createDisplay();

        init();

        while(!Display.isCloseRequested()){
            renderer.prepare();

            update();

            render();

            debugRenderer.render(hitbox);

            DisplayManager.updateDisplay();
        }


        cleanUp();
        DisplayManager.closeDisplay();
    }

    public void init(){
        loader = new Loader();
        renderer  = new Renderer(loader);
        menu = new MenuCalc(loader);

        hitbox = menu.getScaledItemHitbox(menu.getItem());
        debugRenderer = new DebugRenderer(loader);
    }

    public void update(){
        if(hitbox.checkCollision(new Vector2f(Mouse.getX(), Mouse.getY()))){
            System.out.println("Collision");
        }

        toRender = new ArrayList<>();
        menu.update();
    }

    public void render(){
        toRender.add(menu.getRender());
        renderer.render(toRender);
    }

    public void cleanUp(){
        loader.cleanUp();
        renderer.cleanUp();
        menu.cleanUp();

        debugRenderer.cleanUp();
    }
}
