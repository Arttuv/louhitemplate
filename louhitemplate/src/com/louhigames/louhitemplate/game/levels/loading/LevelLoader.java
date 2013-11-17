package com.louhigames.louhitemplate.game.levels.loading;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;
import com.louhigames.louhitemplate.game.levels.Level;
import com.louhigames.louhitemplate.game.objects.AbstractGameObject;
import com.louhigames.louhitemplate.game.objects.Rock;

public class LevelLoader {

		private final int BLOCK_WIDTH = 1;
		private final int BLOCK_HEIGHT = 1;
		
		public enum BLOCK_TYPE {
			EMPTY(0, 0, 0), // black
			ROCK(0, 255, 0); // green

			private int color;

			private BLOCK_TYPE (int r, int g, int b) {
				color = r << 24 | g << 16 | b << 8 | 0xff;
			}

			public boolean matchingColor(int color) {
				return this.color == color;
			}

			public int getColor () {
				return color;
			}
		}
		
		private String levelDataPath;
		
		public LevelLoader(String levelDataPath) {

			this.levelDataPath = levelDataPath;

		}

		public Level load() {
			
			Pixmap levelPixmap = new Pixmap(Gdx.files.internal(levelDataPath));
			
			int mapX = levelPixmap.getWidth();
			int mapY = levelPixmap.getHeight();

			Level level = new Level();

			for (int y = 0; y < mapY; y += BLOCK_HEIGHT) {

				for (int x = 0; x < mapX; x += BLOCK_WIDTH) {

					int pixel = levelPixmap.getPixel(x, y);
					
					AbstractGameObject gameObject = null;
					
					if (BLOCK_TYPE.EMPTY.matchingColor(pixel)) {
						// ... no need to do anything
					}
					else if (BLOCK_TYPE.ROCK.matchingColor(pixel)) {
						gameObject = new Rock();
						// set position, etc
					}
					// ... add more types when needed
					
					// add object to level
					if (gameObject != null) {
						level.addGameObject(gameObject);
					}
					
				}
				
			}

			levelPixmap.dispose();

			return level;
		}


	}

	