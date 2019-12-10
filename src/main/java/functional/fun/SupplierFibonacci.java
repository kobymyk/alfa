package functional.fun;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierFibonacci {
    private final int[] fibs = {0, 1};

    private Supplier<Integer> fibonacci = (() -> {
        int result = fibs[1];
        int fib3 = fibs[0] + fibs[1];
        fibs[0] = fibs[1];
        fibs[1] = fib3;

        return result;
    });

    List<Integer> supply(long size) {
        Stream<Integer> stream = Stream.generate(fibonacci);
        return stream.limit(size)
                .collect(Collectors.toList());
    }
}
