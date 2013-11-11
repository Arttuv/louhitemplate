package com.louhigames.louhitemplate.levels.loading;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;

public class MapFileReader {

		private final int BLOCK_WIDTH = 1;
		private final int BLOCK_HEIGHT = 1;
		
		private Pixmap mapPixmap;
		private Pixmap entityPixmap;
		
		public MapFileReader(String mapPath, String entityDataPath) {

			mapPixmap = new Pixmap(Gdx.files.internal(mapPath));
			entityPixmap = new Pixmap(Gdx.files.internal(entityDataPath));

		}

		private String getHex(int c) {
			return new Color(c).toString();
		}

		public WorldBuildInstructionObject getWorldInstructions() {
			
			WorldBuildInstructionObject instructions = new WorldBuildInstructionObject(getMapData(), getEntityData());
			
			return instructions;
		}
		
		public List<List<String>> getMapData() {

			int mapX = mapPixmap.getWidth();
			int mapY = mapPixmap.getHeight();

			List<List<String>> mapData = new ArrayList<List<String>>();

			for (int y = 0; y < mapY; y += BLOCK_HEIGHT) {

				List<String> mapRowData = new ArrayList<String>();
				for (int x = 0; x < mapX; x += BLOCK_WIDTH) {

					int pixel = mapPixmap.getPixel(x, y);
					String hexValue = getHex(pixel);

					mapRowData.add(hexValue);

				}

				mapData.add(mapRowData);
			}

			return mapData;
		}
		
		public List<List<String>> getEntityData() {

			int mapX = entityPixmap.getWidth();
			int mapY = entityPixmap.getHeight();

			List<List<String>> entityData = new ArrayList<List<String>>();

			for (int y = 0; y < mapY; y += BLOCK_HEIGHT) {

				List<String> entityRowData = new ArrayList<String>();
				for (int x = 0; x < mapX; x += BLOCK_WIDTH) {

					int pixel = entityPixmap.getPixel(x, y);
					String hexValue = getHex(pixel);

					entityRowData.add(hexValue);

				}

				entityData.add(entityRowData);
			}

			return entityData;
		}

	}

	