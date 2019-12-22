package lang.methodref;

public class ObjectMethodReference {
    public ObjectSrc src;

    public FunctionalConverter<ObjectSrc> getSrcConverter() {
        ObjectSrcConverter converter = new ObjectSrcConverter(src);
        FunctionalConverter<ObjectSrc> result = converter.transform();
        return result;
        //ObjectTarget result  = objectSrcConverter.transform().apply(ObjectSrcConvertUtils::toObjectTarget);
    }

    public <T> FunctionalConverter<T> getAnyConverter() {
        ObjectAnyConverter converter = new ObjectAnyConverter(src);
        FunctionalConverter<T> result = converter.transform();
        return result;
    }
}
