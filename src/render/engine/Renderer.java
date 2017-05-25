package render.engine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.util.vector.Matrix4f;
import org.w3c.dom.stylesheets.LinkStyle;
import render.engine.models.RawModel;
import render.engine.models.TexturedModel;
import render.engine.shader.Shader;
import tools.Loader;
import tools.toolbox.Maths;

import java.util.List;


/**
 * Created by levin on 17.03.2017.
 */
public class Renderer {

    private RawModel quad;
    private Shader shader;
    private Loader loader;

    public Renderer(Loader loader){
        float[] positions = { -1, 1, -1, -1, 1, 1, 1, -1};
        quad = loader.loadToVAO(positions);
        shader = new Shader();
        this.loader = loader;
    }

    public void prepare(){
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        GL11.glClearColor(1,1f,1,1);
    }

    public void render(List<TexturedModel> models){ //Muss noch überarbeitet werden (ich brauch nur die matrix und die textur)
        shader.start();
        GL30.glBindVertexArray(quad.getVaoID());
        GL20.glEnableVertexAttribArray(0);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        for(TexturedModel model : models){
            GL13.glActiveTexture(GL13.GL_TEXTURE0);
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, model.getTexture().getID());
            Matrix4f matrix = Maths.createTransformationMatrix(model.getPosition(), model.getScale());
            shader.loadTransformation(matrix);
            GL11.glDrawArrays(GL11.GL_TRIANGLE_STRIP, 0, quad.getVertexCount());
        }
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDisable(GL11.GL_BLEND);
        GL20.glDisableVertexAttribArray(0);
        GL30.glBindVertexArray(0);
        shader.stop();
    }

    public void cleanUp(){
        shader.cleanUp();
        loader.cleanUp();
    }


}
