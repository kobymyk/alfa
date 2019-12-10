package lang.wildcard;

import java.util.List;

public class AnyListModifier {

    public static void updateList(List<?> list) {
        //list.set(0, list.get(0));
        updateListHelper(list);
    }

    // Helper method created so that the wildcard can be captured
    // through type inference.
    private static <T> void updateListHelper(List<T> list) {
        list.set(0, list.get(0));
    }
}
