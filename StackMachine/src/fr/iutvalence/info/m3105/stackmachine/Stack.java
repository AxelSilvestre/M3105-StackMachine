package fr.iutvalence.info.m3105.stackmachine;

public class Stack{
	
	private final int size;
	private final int word_size;
	private final int values[];
	
	// TODO Finish STACK
	
	public Stack(int size) throws InvalidParametersException{
		super();
		this.size = size;
		this.word_size = 32;
		values = new int[size];
	}
	
	public int getSize() {
		return size;
	}
	
	public int getWord_size() {
		return word_size;
	}

	public void clear() {
				
	}
	

}
