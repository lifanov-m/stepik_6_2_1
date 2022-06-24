import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class SymmetricDifference {

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
            T el = iterator.next();
            if(! set2.contains(el)) {
                result.add(el);
            }
        }

        iterator = set2.iterator();
        while (iterator.hasNext()) {
            T el = iterator.next();
            if(! set1.contains(el)) {
                result.add(el);
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
