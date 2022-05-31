package itmo.collection.deserializers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import itmo.collection.MyTreeMap;
import itmo.spacemarine.SpaceMarine;
import itmo.utils.KVPair;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Helps to read from file
 */
public class MyTreeMapDeserializer { //помогает из класса читать

    /**
     * array of keys and values
     */
    private KVPair[] kvPairs;

    /**
     * variable keep the creation time
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm") // правильный вид времени
    private LocalDateTime creationDate;

    /**
     * set array of pairs
     */
    public void setKvPairs(KVPair[] kvPairs) {
        this.kvPairs = kvPairs;
    }

    /**
     * set time
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * a method that will return a key and value object
     */
    private MyTreeMap<Integer, SpaceMarine> toMyTreeMap() { //метод, который вернет объект типа MyTreeMap, под названием toMyTreeMap
        MyTreeMap<Integer, SpaceMarine> myTreeMap = new MyTreeMap<>();
        myTreeMap.setCreationDate(creationDate); // задаем время создания коллекции

        for (KVPair kvPair : kvPairs) { // проходимся по массиву и каждому значению присваиваем ключ значение
            myTreeMap.put(kvPair.getKey(), kvPair.getValue());
        }
        return myTreeMap;
    }

    /**
     * reads the file and converts it into a readable form
     */
    public MyTreeMap<Integer, SpaceMarine> deserialize(String filename) throws IOException { // читает файл и преобразовывает ее в понятный прогамме вид
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        MyTreeMapDeserializer deserializer = xmlMapper.readValue(new File(filename), this.getClass()); //класс объекта, который мы хотим считать
        return deserializer.toMyTreeMap();
    }
}
