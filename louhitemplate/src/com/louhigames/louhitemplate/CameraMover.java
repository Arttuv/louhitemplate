package com.louhigames.louhitemplate;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class CameraMover extends InputAdapter {

	private Vector2 lastTouchPosition;
	private Vector2 touchNow;
	
	private OrthographicCamera camera;
	
	public CameraMover(OrthographicCamera camera) {
		lastTouchPosition = new Vector2(0, 0);
		touchNow = new Vector2(0, 0);
		this.camera = camera;
		
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		
		if(pointer == 0) {
			lastTouchPosition.set(screenX, screenY);	
		}
		
		return super.touchDown(screenX, screenY, pointer, button);
	}
	
	@Override
	public boolean scrolled(int amount) {
		
		
		camera.zoom = (float)(camera.zoom + (0.1 * amount));
		camera.update();
		
		return super.scrolled(amount);
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		
		if(pointer == 0 && camera != null) {
			
			touchNow.set(screenX, screenY);
			touchNow.sub(lastTouchPosition);

			camera.translate(-touchNow.x / 1000.0f, touchNow.y / 1000.0f);
			camera.update();
			lastTouchPosition.set(screenX, screenY);
			
		}
		
		return super.touchDragged(screenX, screenY, pointer);
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		
		if(pointer == 0) {
			lastTouchPosition.set(0, 0);
		}
		
		return super.touchUp(screenX, screenY, pointer, button);
	}
	
	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		
		
		
		return super.mouseMoved(screenX, screenY);
	}
	
}
