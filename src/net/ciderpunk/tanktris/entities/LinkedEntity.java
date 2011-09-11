package net.ciderpunk.tanktris.entities;

public class LinkedEntity {

	protected LinkedEntity oNext;
	protected LinkedEntity oPrev;
	
	public void remove(){
		if (oNext != null){
			oNext.oPrev = oPrev;
		}
		oPrev.oNext = oNext;
		oNext = null;
		oPrev = null;
	}
	
	public void insert(LinkedEntity e){
		if (oNext != null){
			oNext.oPrev = e;
		}
		e.oNext = oNext;
		e.oPrev = this;
		oNext = e;
	}
	
	public LinkedEntity getNext(){
		return oNext;
	}
	
	
}
