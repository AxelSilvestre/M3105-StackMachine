package fr.iutvalence.info.m3105.stackmachine;

import java.io.IOException;

public interface InputOutput {

	public void displayRuntimeError(String string);
	
	public void displayProgramTermination();

	public int read() throws IOException;

	public void write(int op);

}
