package libs.jackson;

public class DataViews {
    public static final Class<Info> INFO_CLASS = Info.class;
    public static final Class<Debug> DEBUG_CLASS = Debug.class;

    public static class Info {}

    public static class Warn extends Info {}

    public static class Debug extends Warn {}

}
