package functional.fun;

import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryReplace {
    static void replace(List<String> list) {
        UnaryOperator<String> fun = s -> s.toUpperCase(); //String::toUpperCase
        list.replaceAll(fun);
    }
}
