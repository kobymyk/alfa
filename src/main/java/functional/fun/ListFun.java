package functional.fun;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class ListFun {
    static void replace(List<String> list) {
        UnaryOperator<String> fun = String::toUpperCase; //s -> s.toUpperCase(); //
        list.replaceAll(fun);
    }

    static Consumer<Record> mapRecord = (r) -> {
        r.id = "id[]";
        r.name = "name[]";
    };

    static void listForEach(List<Record> list) {
        // covariant
        list.forEach(r -> {
            r.id = "id[]";
            r.name = "name[]";
        });
    }

    static void streamForEach(List<Record> list) {
        // gonna be immutable
        list.stream().forEach(r -> {
            r.id = "id[]";
            r.name = "name[]";
        });
    }
}
