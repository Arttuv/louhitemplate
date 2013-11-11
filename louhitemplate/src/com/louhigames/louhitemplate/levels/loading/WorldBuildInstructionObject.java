package com.louhigames.louhitemplate.levels.loading;

import java.util.List;

public class WorldBuildInstructionObject {
	
	private List<List<String>> mapData;
	
	public WorldBuildInstructionObject(List<List<String>> mapData) {
		this.mapData = mapData;
	}
	
	public List<List<String>> getMapData() {
		return this.mapData;
	}
	
	
}