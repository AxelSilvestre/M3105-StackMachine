package fr.iutvalence.info.m3105.stackmachine;

public abstract class AbstractCPU<WordSize> implements CPU<WordSize>{

	protected Memory programMemory;
	protected Stack expStack;
	protected Stack callStack;
	protected InputOutput ioSystem;
	protected WordSize programCounter;
	
	public abstract void run();

	public final void wireToProgramMemory(Memory programMemory) {
		this.programMemory = programMemory;
		
	}

	public final void wireToExpStack(Stack expStack) {
		this.expStack = expStack;
		
	}

	public final void wireToCallStack(Stack callStack) {
		this.callStack = callStack;
		
	}

	public final void wireToIoSubsystem(InputOutput ioSystem) {
		this.ioSystem = ioSystem;
		
	}

	public final void clearStacks() {
		callStack.clear();
		expStack.clear();
		
	}

	public final void setPC(WordSize address) {
		programCounter = address;
		
	}

}
