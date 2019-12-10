package lang.methodref;

public class ObjectMethodReference {
    public ObjectSrc src;

    public FunctionalConverter<ObjectSrc> getConverter() {
        ObjectSrcConverter objectSrcConverter = new ObjectSrcConverter(src);
        FunctionalConverter<ObjectSrc> result = objectSrcConverter.transform();
        return result;
        //ObjectTarget result  = objectSrcConverter.transform().apply(ObjectSrcConvertUtils::toObjectTarget);
    }
}
