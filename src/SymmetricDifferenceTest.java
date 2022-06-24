import java.util.HashSet;
import java.util.Set;

public class SymmetricDifferenceTest {

    private final Set<Integer> integerSet1 = new HashSet<>();
    private final Set<Integer> integerSet2 = new HashSet<>();
    private final Set<String> stringSet1 = new HashSet<>();
    private final Set<String> stringSet2 = new HashSet<>();

    public SymmetricDifferenceTest() {

        integerSet1.add(1);
        integerSet1.add(2);
        integerSet1.add(3);
        integerSet1.add(4);

        integerSet2.add(3);
        integerSet2.add(4);
        integerSet2.add(5);
        integerSet2.add(6);

        stringSet1.add("one");
        stringSet1.add("two");
        stringSet1.add("three");
        stringSet1.add("four");


        stringSet2.add("three");
        stringSet2.add("four");
        stringSet2.add("five");
        stringSet2.add("six");
    }

    private <T> void testAll(Set<T> set1, Set<T> set2) {

        Set<T> result = SymmetricDifference.symmetricDifference_v1(set1, set2);
        System.out.println( "result for v1:  " + result );

        result = SymmetricDifference.symmetricDifference_v2(set1, set2);
        System.out.println( "result for v2:  " + result );

        result = SymmetricDifference.symmetricDifference_v3(set1, set2);
        System.out.println( "result for v3:  " + result );
    }

    public void testIntegers(){
        testAll(integerSet1, integerSet2);
    }

    public void testStrings(){
        testAll(stringSet1, stringSet2);
    }

    private <T> void benchmarkAll(Set<T> set1, Set<T> set2, int iterations) {
        if(iterations <= 0) {
            return;
        }

        long startTime =  System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            SymmetricDifference.symmetricDifference_v1(set1, set2);
        }
        long stopTime =  System.nanoTime();
        System.out.println( "work time for v1:  " + (stopTime-startTime) );

        startTime =  System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            SymmetricDifference.symmetricDifference_v2(set1, set2);
        }
        stopTime =  System.nanoTime();
        System.out.println( "work time for v2:  " + (stopTime-startTime) );

        startTime =  System.nanoTime();
        for (int i = 0; i < iterations; i++) {
            SymmetricDifference.symmetricDifference_v3(set1, set2);
        }
        stopTime =  System.nanoTime();
        System.out.println( "work time for v3:  " + (stopTime-startTime) );
    }

    public void benchmarkIntegers(int iterations) {
        benchmarkAll(integerSet1, integerSet2, iterations);
    }
}
