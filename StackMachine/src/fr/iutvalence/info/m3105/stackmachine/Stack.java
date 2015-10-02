package fr.iutvalence.info.m3105.stackmachine;

public interface Stack<WordSize> {
	
	public abstract void push(WordSize value) throws StackOverflowException;
	
	public abstract WordSize pop() throws StackUnderflowException;
	
	public abstract boolean isEmpty();
		
	public abstract int getNbValues();
	
	public abstract WordSize peek();
	
	public abstract void clear();
	
	public abstract void dup() throws StackOverflowException;

}
