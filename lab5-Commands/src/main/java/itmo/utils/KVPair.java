package itmo.utils;

import itmo.spacemarine.SpaceMarine;

/**
 * key value array
 */
public class KVPair {
    private Integer key;
    private SpaceMarine value;

    public KVPair() {
    }

    public KVPair(Integer key, SpaceMarine value) {
        this.setKey(key);
        this.setValue(value);
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public SpaceMarine getValue() {
        return value;
    }

    public void setValue(SpaceMarine value) {
        this.value = value;
    }


}
