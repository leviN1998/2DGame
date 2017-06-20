package render.engine.debug.game;


import de.levin.lib.engine.Loader;
import de.levin.lib.engine.entity.BasicTextureObject;
import de.levin.lib.engine.graphics.rendering.Renderer;
import org.lwjgl.util.vector.Vector2f;

/**
 * Created by levin on 12.06.2017.
 */
public class BackGround {

    private BasicTextureObject[] objects;
    private String path = "res/bg.jpeg";
    private Vector2f scale;
    private float offset;


    private float speed;

    public BackGround(Loader loader, String file, int objCount, Vector2f scale, float offset){
        path = file;
        this.scale = scale;
        this.offset = offset;
        objects = new BasicTextureObject[objCount];
        init(loader);
    }

    @Deprecated
    public BackGround(Loader loader){
        scale = new Vector2f(12,12);
        offset = 0.2f;
        objects = new BasicTextureObject[5];
        init(loader);
        //System.out.println(5 * objects[0].getWidth());
        //33.28125
    }

    private void init(Loader loader){
        for (int i = 0; i<objects.length;i++){
            if(i == 0){
                objects[i] = new BasicTextureObject(new Vector2f(-7,0), scale, path, loader);
            }else {
                Vector2f pos = new Vector2f(objects[i-1].getPosition().x + objects[i-1].getWidth() - offset, objects[i-1].getPosition().y);
                objects[i] = new BasicTextureObject(pos,scale, path, loader);
            }
        }

        speed = 0.04f;
    }

    public void update(float delta){
        speed = 0.01f * delta;
        for (int i = 0;i<objects.length;i++) {
            moveObject(objects[i],i);
        }
    }

    public void increaseSpeed(float inc){
        this.speed += inc;
    }

    public void moveObject(BasicTextureObject o, int index){
        o.move(-speed,0);
        if(o.getPosition().x < -10-(o.getWidth()/2)){
            Vector2f last = getLastObject().getPosition();
            float width = getLastObject().getWidth();
            o.setPosition(new Vector2f(last.x + width - offset, last.y));
            if(index == 0){
                o.move(-speed,0);
            }
        }
    }

    public BasicTextureObject getLastObject(){
        float[] positions = new float[objects.length];
        for (int i = 0; i<objects.length;i++){
            positions[i] = objects[i].getPosition().x;
        }
        float highest = positions[0];
        int counter = 0;
        for (int i = 0;i<positions.length;i++){
            if(positions[i] >= highest){
                highest = positions[i];
                counter = i;
            }
        }
        return objects[counter];
    }

    public void process(Renderer renderer){
        for (int i = 0; i<objects.length;i++){
            renderer.process(objects[i]);
        }
    }

}
