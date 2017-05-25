package render.engine.debug.shader;

import org.lwjgl.util.vector.Matrix4f;
import tools.shaders.ShaderProgram;

/**
 * Created by levin on 18.05.2017.
 */
public class DebugShader extends ShaderProgram{

    private static final String VERTEX_FILE = "/render/engine/debug/shader/vertexShader.txt";
    private static final String FRAGMENT_FILE = "/render/engine/debug/shader/fragmentShader.txt";

    private int location_transformationMatrix;

    public DebugShader(){
        super(VERTEX_FILE,FRAGMENT_FILE);
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
