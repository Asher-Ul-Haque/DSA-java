package Exceptions;

public class SortingExceptions extends Exception{
    public SortingExceptions(String message){
        super(message);
    }

    public SortingExceptions(){

    }

    public void dataTypeNotComparable() throws SortingExceptions {
        throw new SortingExceptions("Given data type cannot be compared and doesnt implement Comparable and thus cannot be sorted");
    }

    public void wrongFormat() throws SortingExceptions {
        throw new SortingExceptions("Wrong time format. \n" +
                "Did you mean: \n" +
                "milliseconds\n" +
                "seconds\n" +
                "minutes\n" +
                "hours\n" +
                "days\n" +
                "years\n" +
                "decades ?");
    }

    protected void pushBadDataType(Class Correction) throws Exceptions {
        throw new Exceptions("Attempted to push wrong type of data, use dataype: " + Correction);
    }
}
