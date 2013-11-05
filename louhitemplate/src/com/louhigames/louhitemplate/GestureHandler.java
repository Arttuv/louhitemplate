package com.louhigames.louhitemplate;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.input.GestureDetector.GestureAdapter;
import com.badlogic.gdx.math.Vector2;

public class GestureHandler extends GestureAdapter {

	private OrthographicCamera camera;
	
	public GestureHandler(OrthographicCamera camera) {
		this.camera = camera;
	}
	
	@Override
	public boolean zoom(float initialDistance, float distance) {

		float diff = initialDistance - distance;
		
		camera.zoom = camera.zoom + (diff / 10000.0f);
		
		camera.update();
		
		return super.zoom(initialDistance, distance);
	}
	
	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {

		camera.translate(new Vector2(-deltaX / 1000.0f, deltaY / 1000.0f));
		camera.update();
		
		return super.pan(x, y, deltaX, deltaY);
	}
	
	@Override
	public boolean tap(float x, float y, int count, int button) {

		return super.tap(x, y, count, button);
	}
	
}
