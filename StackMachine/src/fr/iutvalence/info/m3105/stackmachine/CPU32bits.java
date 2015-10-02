package fr.iutvalence.info.m3105.stackmachine;

import java.io.IOException;

public class CPU32bits extends AbstractCPU<Integer>
{

	public final static int HALT 	= 0x00;
	public final static int PUSH  	= 0x01;
	public final static int ADD 	= 0x02;
	public final static int SUB 	= 0x03;
	public final static int MUL 	= 0x04;
	public final static int DIV 	= 0x05;
	public final static int MOD 	= 0x06;
	public final static int NEG 	= 0x07;
	public final static int LT 		= 0x08;
	public final static int LE 		= 0x09;
	public final static int GT 		= 0x0A;
	public final static int GE 		= 0x0B;
	public final static int EQ 		= 0x0C;
	public final static int NE 		= 0x0D;
	public final static int IN 		= 0x0E;
	public final static int OUT 	= 0x0F;
	public final static int CALL 	= 0x10;
	public final static int RET		= 0x11;
	public final static int JP		= 0x12;
	public final static int JZ		= 0x13;
	public final static int DUP		= 0x14;
	public final static int POP		= 0x15;
	

	public void run()
	{	
		try
		{
			int opCode;
			
			while (true)
			{				
				
				// TODO Methode pour faire sortir le switch
				
				opCode = programMemory.read(programCounter);
				programCounter++;				
				
				ioSystem.displayRuntimeError("@" + (programCounter-1) + ": ");
				switch (opCode)
				{
					case HALT:
					{
						this.ioSystem.displayProgramTermination();
						return;
					}
					case PUSH:
					{
						expStack.push(programMemory.read(programCounter));
						programCounter++;
						break;
					}
					
					case ADD:
					{
						int a = (int) expStack.pop();
						int b = (int) expStack.pop();
						expStack.push(a+b);
						break;
					}
					case SUB:
					{
						int a = (int) expStack.pop();
						int b = (int) expStack.pop();
						expStack.push(a-b);
						break;
					}
					case MUL:
					{
						int a = (int) expStack.pop();
						int b = (int) expStack.pop();
						expStack.push(a*b);
						break;
					}
					case DIV:
					{
						int a = (int) expStack.pop();
						int b = (int) expStack.pop();
						expStack.push(a/b);
						break;
					}
					case MOD:
					{
						int a = (int) expStack.pop();
						int b = (int) expStack.pop();
						expStack.push(a%b);
						break;
					}
					case NEG:
					{
						int a = (int) expStack.pop();
						expStack.push(-a);
						break;
					}
					case LT:
					{
						int a = (int) expStack.pop();
						int b = (int) expStack.pop();
						expStack.push(b < a ? 0 : 1);
						break;
					}
					case LE:
					{
						int a = (int) expStack.pop();
						int b = (int) expStack.pop();
						expStack.push(b <= a ? 0 : 1);
						break;
					}
					case GT:
					{
						int a = (int) expStack.pop();
						int b = (int) expStack.pop();
						expStack.push(b > a ? 0 : 1);
						break;
					}
					case GE:
					{
						int a = (int) expStack.pop();
						int b = (int) expStack.pop();
						expStack.push(b >= a ? 0 : 1);
						break;
					}
					case EQ:
					{
						int a = (int) expStack.pop();
						int b = (int) expStack.pop();
						expStack.push(b == a ? 0 : 1);
						break;
					}
					case NE:
					{
						int a = (int) expStack.pop();
						int b = (int) expStack.pop();
						expStack.push(b != a ? 0 : 1);
						break;
					}
					case IN:
					{
						int a = ioSystem.read();
						expStack.push(a);
						break;
					}
					case OUT:
					{
						ioSystem.write((int) expStack.pop());
						break;
					}
					case CALL:
					{
						callStack.push(programCounter);
						break;
					}
					case RET:
					{
						programCounter = (int) callStack.pop();
						break;
					}
					case JP:
					{
						programCounter = programMemory.read(programCounter);
						break;
					}
					case JZ:
					{
						int a = (int) expStack.pop();
						if(a == 0)
							programCounter = a;
						break;
					}
					case DUP:
					{
						expStack.dup();
						break;
					}
					case POP:
					{
						expStack.pop();
						break;
					}
					default:
					{
						ioSystem.displayRuntimeError("Bad instruction");
						return;
					}
					
				}
			}
		}
		catch (AddressOutOfBoundsException e)
		{
			ioSystem.displayRuntimeError("Adress out of bounds.");
		}
		catch (IOException e)
		{
			ioSystem.displayRuntimeError("Error with IO system.");
		}
		catch (StackOverflowException e)
		{
			ioSystem.displayRuntimeError("Stack overflow.");
		}
		catch (StackUnderflowException e)
		{
			ioSystem.displayRuntimeError("Stack underflow.");
		}		
	}



}
