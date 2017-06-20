package render.engine;

import org.lwjgl.util.vector.Vector2f;
import render.engine.models.TexturedModel;
import tools.Loader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by levin on 20.03.2017.
 */
public class Player {

    private List<TexturedModel> characters;


    public Player(Loader loader){
        characters = new ArrayList<>();
        initModels(loader);
    }

    public void initModels(Loader loader){
        TexturedModel model1 = new TexturedModel(loader.loadTexture("Gewebe14"), new Vector2f(0.05f,0.075f), new Vector2f(0.25f,0.5f)); //0.75 / 1.5
        TexturedModel model2 = new TexturedModel(loader.loadTexture("Gewebe2"), new Vector2f(0,0), new Vector2f(0.1666667f,0.333333f)); // 0.5 / 1
        TexturedModel model3 = new TexturedModel(loader.loadTexture("Gewebe3"), new Vector2f(0,0), new Vector2f(0.1666667f,0.333333f));
        TexturedModel model4 = new TexturedModel(loader.loadTexture("Gewebe14"), new Vector2f(0.05f,0.075f), new Vector2f(0.25f,0.5f));
        TexturedModel model5 = new TexturedModel(loader.loadTexture("Gewebe5"), new Vector2f(0,0), new Vector2f(0.1666667f,0.333333f));
        TexturedModel model6 = new TexturedModel(loader.loadTexture("Gewebe6"), new Vector2f(0,0), new Vector2f(0.1666667f,0.333333f));


        characters.add(model1);
        characters.add(model2);
        characters.add(model3);
        characters.add(model4);
        characters.add(model5);
        characters.add(model6);
    }

    private int i = 0;
    private int bild = 0;
    public void update(){
        if(i++ == 12){
            i = 0;
            bild++;
            if(bild > 5){
                bild = 0;
            }

        }
    }

    public TexturedModel getRenderImage(){
        return characters.get(bild);
    }
}
