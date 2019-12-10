package lang.wildcard;

import java.util.ArrayList;
import java.util.List;

class Zoo<T> {
    Class<T> clazz;
    List<T> animals = new ArrayList<T>();

    Zoo(Class<T> clazz) {
        this.clazz = clazz;
    }

    public T createNewAnimal() throws IllegalAccessException, InstantiationException {
        T animal = clazz.newInstance();
        animals.add(animal);
        return animal;
    }
}
