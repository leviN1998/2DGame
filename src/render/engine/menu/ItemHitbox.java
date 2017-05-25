package render.engine.menu;

import org.lwjgl.util.vector.Vector2f;
import tools.toolbox.Maths;

/**
 * Created by levin on 18.05.2017.
 */
public class ItemHitbox {

    private Vector2f v1;
    private Vector2f v3;

    private Vector2f middle;

    private Vector2f scale;

    public ItemHitbox(Vector2f v1, Vector2f v3){
        this.v1 = v1;
        this.v3 = v3;
        System.out.println(v1.getX() + "   " + v1.getX());
        scale = new Vector2f(1,1);
        calcScale();
        middle = new Vector2f(v1.x + (v3.x / 2), v1.y + (v3.y / 2) );
    }

    public boolean checkCollision(Vector2f object){
        if(object.x >= v1.x && object.x <= v3.x){
            if(object.y >= v1.y && object.y <= v3.y){
                return true;
            }
        }
        return false;
    }

    public void calcScale(){
        Vector2f one = Maths.getNormalizedDeviceCoords(v1);
        Vector2f three = Maths.getNormalizedDeviceCoords(v3);

        float x = (three.x - one.x) / 2;
        float y = (three.y - one.y) / 2;

        scale = new Vector2f(x,y);
    }

    public Vector2f getV1() {
        return v1;
    }

    public Vector2f getV3() {
        return v3;
    }

    public Vector2f getScale(){
        return scale;
    }

    public Vector2f getMiddle(){
        return middle;
    }
}
