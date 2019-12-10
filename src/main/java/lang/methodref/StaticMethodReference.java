package lang.methodref;

public class StaticMethodReference {
    public static String convertToString(String source) {
        return "staticFun.source=" + source;
    }

    StringConverter getStringConverterRef() {
        // () -> String
        StringConverter result = StaticMethodReference::convertToString;
        return result;
    }
}
