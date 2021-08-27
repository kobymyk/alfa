package lang.methodref;

public class ObjectMethodReference {
    private ObjectSrc src;

    public FunctionalConverter<ObjectSrc> getSrcConverter() {
        ObjectSrcConverter converter = new ObjectSrcConverter(src);
        FunctionalConverter<ObjectSrc> result = converter.transform();
        return result;
        //ObjectTarget result  = objectSrcConverter.transform().apply(ObjectSrcConvertUtils::toObjectTarget);
    }

    public FunctionalConverter getAnyConverter() {
        //ObjectAnyConverter<T> converter = new ObjectAnyConverter(src);
        FunctionalConverter<ObjectSrc> result = new ObjectAnyConverter<>(src).transform();
        return result;
    }

    public ObjectSrc getSrc() {
        return src;
    }

    public void setSrc(ObjectSrc src) {
        this.src = src;
    }
}
