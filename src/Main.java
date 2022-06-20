import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args){

        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        Set<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);

        Set<Integer> result = symmetricDifference_v1(set1, set2);
        System.out.println( "result for v1:  " + result );

        result = symmetricDifference_v2(set1, set2);
        System.out.println( "result for v2:  " + result );

        result = symmetricDifference_v3(set1, set2);
        System.out.println( "result for v3:  " + result );
    }

    public static <T> Set<T> symmetricDifference_v1(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> result = new LinkedHashSet<>();

        for (T el:set1
             ) {
            if(! set2.contains(el)) {
                result.add(el);
            }
        }

        for (T el:set2
        ) {
            if(! set1.contains(el)) {
                result.add(el);
            }
        }


        return result;
    }




    public static <T> Set<T> symmetricDifference_v2(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> result = new HashSet<>();

        Iterator<? extends T> iterator = set1.iterator();


        while (iterator.hasNext()) {
            if(! set2.contains(iterator.next())) {
                result.add(iterator.next());
            }
        }

        iterator = set2.iterator();
        while (iterator.hasNext()) {
            if(! set1.contains(iterator.next())) {
                result.add(iterator.next());
            }
        }

        return result;
    }

    public static <T> Set<T> symmetricDifference_v3(Set<? extends T> set1, Set<? extends T> set2) {

        Set<T> set1_copy = new HashSet<>(set1);
        Set<T> set2_copy = new HashSet<>(set2);
        Set<T> intersection = new HashSet<>(set1);

        intersection.retainAll(set2_copy);
        set1_copy.addAll(set2_copy);
        set1_copy.removeAll(intersection);

        return set1_copy;
    }
}
