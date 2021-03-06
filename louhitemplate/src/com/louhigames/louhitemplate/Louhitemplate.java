package com.louhigames.louhitemplate;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;

public class Louhitemplate extends InputAdapter implements ApplicationListener {
	
	
	private OrthographicCamera camera;
	private CameraMover cameraMover;
	private GestureHandler gestureHandler;
	
	private SpriteBatch batch;
	private Texture texture;
	private Sprite sprite;
	
	
	@Override
	public void create() {		
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		texture = new Texture(Gdx.files.internal("data/libgdx.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		
		TextureRegion region = new TextureRegion(texture, 0, 0, 512, 275);
		
		sprite = new Sprite(region);
		sprite.setSize(0.9f, 0.9f * sprite.getHeight() / sprite.getWidth());
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		
		cameraMover = new CameraMover(camera);
		gestureHandler = new GestureHandler(camera);
		
		Gdx.input.setInputProcessor(new GestureDetector(gestureHandler));
	}

	@Override
	public void dispose() {
		batch.dispose();
		texture.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	@Override
	public boolean keyTyped(char character) {

		if (character == 'w') {
			camera.translate(0, -0.01f);
			camera.update();
		}
		
		if (character == 's') {
			camera.translate(0, 0.01f);
			camera.update();
		}
		
		if (character == '+') {
			camera.zoom -= 0.05f;
			camera.update();
		}
		
		if (character == '-') {
			camera.zoom += 0.05f;
			camera.update();
		}
		
		return super.keyTyped(character);
	}
	
}
