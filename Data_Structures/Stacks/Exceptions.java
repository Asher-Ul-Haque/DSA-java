package Data_Structures.Stacks;

public class Exceptions extends Exception{
    public Exceptions(String message){
        super(message);
    }

    public Exceptions(){
    }

    protected void popFromEmptyStack() throws Exceptions {
        throw new Exceptions("Attempted to pop from empty stack. Push something to be able to pop");
    }

    protected void popMultipleFromEmptyStack() throws Exceptions {
        throw new Exceptions("Attempted to pop from empty stack. Push something to be able to pop");
    }
}
