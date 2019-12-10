package patterns.decorator;

public class TypedXmlChange {
    private XmlChange xmlChange;
    private String type;

    public TypedXmlChange() {
    }

    public TypedXmlChange(XmlChange xmlChange, String type) {
        this.xmlChange = xmlChange;
        //this.type
    }
}
