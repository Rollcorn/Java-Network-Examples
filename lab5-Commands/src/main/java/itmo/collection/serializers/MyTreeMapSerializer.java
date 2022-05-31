package itmo.collection.serializers;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import itmo.collection.MyTreeMap;
import itmo.spacemarine.SpaceMarine;
import itmo.utils.KVPair;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

/** class helps to write to file*/
public class MyTreeMapSerializer { // записывает в файл
    /** array of keys and values*/
    private KVPair[] kvPairs;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm") // правильный вид времени
    /** variable keep the creation time*/
    private LocalDateTime creationDate;

    /** method that will return a key and value object*/
    public MyTreeMapSerializer(MyTreeMap<Integer, SpaceMarine> myTreeMap) { // определили конструктор, ктороый принет
        // объект класса mytreemap, с параметрами

        this.setCreationDate(myTreeMap.getCreationDate());

        // вызываю сеттер, который присваивает п
        // вызываю сеттер, который присваивает то, что мы ему передаем
        // просим myTreeMap вернуть свою дату инациализации
        // this.creationDate = myTreeMap.getCreationDate();
        kvPairs = new KVPair[myTreeMap.size()]; //массив размера количества элементов myTreeMap

        //myTreeMap.keySet(); просто проверили, существует ли метод
        Integer[] keys = myTreeMap.keySet().toArray(new Integer[0]); // вытащила множество ключей и преобразовала их в массив
        for (int i = 0; i < myTreeMap.size(); i++) {
            kvPairs[i] = new KVPair(keys[i], myTreeMap.get(keys[i])); // определенному элементу с ключом присваиваем значение из myTreeMap по ключу
        }
        // все элементы перенести в массив, пройтись по всем ключам, метод гет вытащит значения, пара ключ значения
    }

    /** get array of kvPairs*/
    public KVPair[] getKvPairs() {
        return kvPairs;
    }

    /** set array of kvPairs*/
    public void setKvPairs(KVPair[] kvPairs) {
        this.kvPairs = kvPairs;
    }

    /** method to get the current time*/
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /** set time*/
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /** method writes xml to file*/
    public void serialize(String filename) throws IOException {
        XmlMapper xmlMapper = new XmlMapper();  //создает объект, который помогает преобразовывать в xml
        xmlMapper.registerModule(new JavaTimeModule()); //запоминает время
        xmlMapper.enable(SerializationFeature.INDENT_OUTPUT); //записывает в файле по разным строчкам
        xmlMapper.writeValue(new File(filename), this); //записываем текущий объект в файл
    }
}
