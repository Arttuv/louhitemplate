package com.louhigames.louhitemplate.levels.loading;

import java.util.List;

public class WorldBuildInstructionObject {
	
	private List<List<String>> mapData;
	private List<List<String>> entityData;
	
	public WorldBuildInstructionObject(List<List<String>> mapData, List<List<String>> entityData) {
		this.mapData = mapData;
		this.entityData = entityData;
	}
	
	public List<List<String>> getMapData() {
		return this.mapData;
	}
	
	public List<List<String>> getEntityData() {
		return this.entityData;
	}
	
}