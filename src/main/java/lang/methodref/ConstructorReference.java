package lang.methodref;

public class ConstructorReference {
    public static Messageable getReference() {
        Messageable result = Message::new;
        return result;
    }
}
