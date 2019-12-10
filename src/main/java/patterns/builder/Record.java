package patterns.builder;

public class Record {
    private int objectId;
    private String source;
    private String value;
    private String path;

    public int getObjectId() {
        return objectId;
    }

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }

    public String getPath() {
        return path;
    }

    private void typeValue(String type) {
        value = "<type=" + type + ">" + value;
    }

    static class Builder {
        private int objectId;
        private String type;
        private String source;
        //
        private String value;
        private String path;

        public Builder(int objectId) {
            this.objectId = objectId;
        }

        public Record get() {
            Record result = new Record();
            result.objectId = this.objectId;
            result.path = this.path;
            result.source = this.source;
            result.path = this.path;
            result.value = this.value;

            if (this.type != null) {
                result.typeValue(this.type);
            }

            return result;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setSource(String source) {
            this.source = source;
            return this;
        }

        public Builder setValue(String value) {
            this.value = value;
            return this;
        }

        public Builder setPath(String path) {
            this.path = path;
            return this;
        }
    }
}
