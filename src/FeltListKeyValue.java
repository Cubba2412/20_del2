

    public class FeltListKeyValue {
    private int key;
    private int value;
    private boolean giverEkstraTur;

    public FeltListKeyValue(int key, int value, boolean giverEkstraTur){
        this.key = key;
        this.value = value;
        this.giverEkstraTur = giverEkstraTur;
    }

    public FeltListKeyValue(int key, int value){
        this(key, value, false);
    }

    public int getKey() {
        return key;
    }

    public int getValue(){
        return value;
    }

    public boolean giverEkstraTur() {
        return giverEkstraTur;
    }
}
