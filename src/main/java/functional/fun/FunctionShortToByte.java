package functional.fun;

public class FunctionShortToByte {
    static byte[] transformArray(short[] array, ShortToByteFunction function) {
        byte[] result = new byte[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = function.applyAsByte(array[i]);
        }
        return result;
    }
}
