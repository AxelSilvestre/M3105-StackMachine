package fr.iutvalence.info.m3105.stackmachine;

public interface CPU<WordSize> {
	
	public abstract void run();
	
	public abstract void wireToProgramMemory(Memory programMemory);

	public abstract void wireToExpStack(Stack expStack);

	public abstract void wireToCallStack(Stack callStack);

	public abstract void wireToIoSubsystem(InputOutput ioSystem);

	public abstract void clearStacks();

	public abstract void setPC(WordSize address);
	
}
