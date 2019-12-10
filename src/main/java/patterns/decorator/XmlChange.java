package patterns.decorator;

public class XmlChange {
    String xpath;
    String value;
    String logInfo;

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo;
    }

    public XmlChange(String xpath, String value) {
        this.xpath = xpath;
        this.value = value;
    }
}
