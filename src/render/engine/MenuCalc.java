package render.engine;

import org.lwjgl.util.vector.Vector2f;
import render.engine.menu.ItemHitbox;
import render.engine.menu.MenuItem;
import render.engine.models.TexturedModel;
import tools.Loader;
import tools.toolbox.Maths;

/**
 * Created by levin on 12.05.2017.
 */
public class MenuCalc {
    private MenuItem item;
    private int speed;
    private int counter;

    public MenuCalc(Loader loader){
        item = new MenuItem(loader, new Vector2f(0f,0f), new Vector2f(0.5f,0.5f));
        initModels();
        speed = 7;
    }

    private void initModels(){
        for(int i = 1; i<16;i++) {
            item.addModel("/buttons/playbutton_" + i);
        }
    }

    public void update(){
        counter++;
        if(counter == speed){
            counter = 0;
            item.update();
        }
    }

    public TexturedModel getRender(){
        return item.getRender();
    }

    public void cleanUp(){
        item.cleanUp();
    }

    public ItemHitbox getScaledItemHitbox(MenuItem item){

        Vector2f corner1percentage = new Vector2f(0.05f, 0.3f);
        Vector2f corner3percentage = new Vector2f(0.95f, 0.7f);


        Vector2f originalSize = item.getRender().getTexture().getOriginalSize();
        Vector2f scale = item.getScale();
        Vector2f position = item.getPosition();

        Vector2f displayPosition = Maths.getDisplayCoords(position);
        Vector2f size = new Vector2f(originalSize.x * scale.x, originalSize.y * scale.y);

        Vector2f corner1 = new Vector2f(displayPosition.x + (corner1percentage.x * size.x),
                displayPosition.y + (corner1percentage.y * size.y));
        Vector2f corner2 = new Vector2f(displayPosition.x + (corner3percentage.x * size.x),
                displayPosition.y + (corner3percentage.y * size.y));

        return new ItemHitbox(corner1, corner2);
    }

    public MenuItem getItem(){
        return item;
    }

}
