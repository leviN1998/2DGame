package render.engine.shader;

import org.lwjgl.util.vector.Matrix4f;
import tools.shaders.ShaderProgram;

/**
 * Created by levin on 17.03.2017.
 */
public class Shader extends ShaderProgram{
    private static final String VERTEX_FILE = "/render/engine/shader/vertexShader.txt";
    private static final String FRAGMENT_FILE = "/render/engine/shader/fragmentShader.txt";

    private int location_transformationMatrix;

    public Shader(){
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    public void loadTransformation(Matrix4f matrix){
        super.loadMatrix(location_transformationMatrix, matrix);
    }

    @Override
    protected void getAllUniformLocations() {
        location_transformationMatrix = super.getUniformLocation("transformationMatrix");
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }
}
