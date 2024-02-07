package Exceptions;

public class SearchExceptions extends Exception{
    public SearchExceptions(String message){
        super(message);
    }
    public SearchExceptions(){}
    public void dataTypeNotComparable() throws SearchExceptions {
        throw new SearchExceptions("Given data type cannot be compared and doesnt implement Comparable and thus cannot be sorted");
    }
    public void wrongFormat() throws SearchExceptions {
        throw new SearchExceptions("Wrong time format. \n" +
                "Did you mean: \n" +
                "milliseconds\n" +
                "seconds\n" +
                "minutes\n" +
                "hours\n" +
                "days\n" +
                "years\n" +
                "decades ?");
    }
    public void notSorted() throws SearchExceptions{
        throw new SearchExceptions("The given array is not sorted. Cannot do binary search. \nSort the array first");
    }


}
