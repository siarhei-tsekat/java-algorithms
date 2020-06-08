package fox;

import java.util.ArrayList;

public class Person<T1, T2, T3> {

    private final T1 id;
    private final T2 money;
    private final T3 name;

    public Person(T1 id, T2 money, T3 name) {
        this.id = id;
        this.money = money;
        this.name = name;
    }

    public T1 getId() {
        return id;
    }

    public T2 getMoney() {
        return money;
    }

    public T3 getName() {
        return name;
    }
}


class Runer {
    public static void main(String[] args) {
        Person<Integer,Double,String> pairString = new Person<Integer,Double,String>(10,12.0,"Mike");

        ArrayList<Person<Integer,Double,String>> list = new ArrayList<Person<Integer,Double,String>>();
        list.add(pairString);
    }
}
