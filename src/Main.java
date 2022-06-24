
public class Main {

    public static void main(String[] args){

        SymmetricDifferenceTest test = new SymmetricDifferenceTest();
        //test.testIntegers();
        //test.testStrings();

        test.benchmarkIntegers(100000);
    }
}
