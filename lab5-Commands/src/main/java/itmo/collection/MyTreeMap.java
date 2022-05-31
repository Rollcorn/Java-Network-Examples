package itmo.collection;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * MyTreeMap is main collection
 */
public class MyTreeMap<K, V> extends TreeMap<K, V> { // k v может хранить любое ключ-значение
    /**
     * creationDate variable with the value of file creation time
     */
    private LocalDateTime creationDate;

    /**
     * method for creating the current time
     */
    public MyTreeMap() {
        creationDate = LocalDateTime.now();
    }

    /**
     * method to get the current time
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * method to set the current time
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     *
     */
    public List<V> getValueList() {
        List<V> valueList = new ArrayList<>(); //создаем и инициализируем новый лист с будущими значениями
        this.keySet().forEach(key -> valueList.add(this.get(key))); // keySet - возвращает множестов ключей, для каждого из которых мы записываем в valueList значение по этому ключу.
        return valueList;
    }
}
