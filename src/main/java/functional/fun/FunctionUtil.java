package functional.fun;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Consumer;
import java.util.function.Function;

public class FunctionUtil {
    public static ShortToByteFunction toByte = s -> (byte) (s * 2);

    public static <T> void setIfNotEmpty(String newValue, Function<String, T> converter, Consumer<T> setter) {
        if (StringUtils.isNotEmpty(newValue)) {
            setter.accept(converter.apply(newValue));
        }
    }
}
