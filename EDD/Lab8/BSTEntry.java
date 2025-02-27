public class BSTEntry {
    private Object data;
    private int key;
    
    public BSTEntry(Object data, int key) {
        this.data = data;
        this.key = key;
    }
    
    public Object getData() {
        return data;
    }
    
    public int getKey() {
        return key;
    }
    
    public void setData(Object data) {
        this.data = data;
    }
    
    public void setKey(int key) {
        this.key = key;
    }
}

