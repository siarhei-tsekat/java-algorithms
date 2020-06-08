package fox;

import java.util.Optional;

class Man {
    Integer age;

    public Man(Integer age) {
        this.age = age;
    }
}

public class Optionalz {
    public static void main(String[] args) {
//        isPresent();
//        ofNull();
//        ofNullable();
//        ifPresent();
//        orElse();
//        orElseGetvsOrElse();
//        filter();
//            getInteger();

        System.out.println(isManInRange(new Man(25)));
        System.out.println(isManInRange(new Man(28)));
        System.out.println(isManInRange(null));
    }

    private static boolean isManInRange(Man man) {
        return Optional.ofNullable(man)
                .map(m -> m.age)
                .filter(age -> age > 10)
                .filter(age -> age < 26)
                .isPresent();
    }

    private static Optional<Integer> getInteger(String name) {
        return name == null ? Optional.empty() : Optional.of(Integer.parseInt(name));
    }

    private static void filter() {
        Integer year = 2016;

        Optional<Integer> yearOptional = Optional.of(year);

        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();

        System.out.println(is2016);
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        System.out.println(is2017);
    }

    private static void orElseGetvsOrElse() {
        String text = "Text present";

        String defaultText = Optional.ofNullable(text).orElseGet(() -> getMyDefault());
        System.out.println("or else get Default Value:" + defaultText);

        defaultText = Optional.ofNullable(text).orElse(getMyDefault());
        System.out.println("or else  Default Value:" + defaultText);
    }

    private static void orElse() {
        String nullName = "fox";
        String name = Optional.ofNullable(nullName).orElse("john");
        System.out.println(name);
    }

    private static void ifPresent() {
//        String nameFox = "fox";
        String nameFox = null;

//        if (nameFox != null) {
//            System.out.println(nameFox.length());
//        }

        Optional<String> opt = Optional.ofNullable(nameFox);
        opt.ifPresent(name -> System.out.println(name.length()));
    }

    private static void isPresent() {
        String name = "fox";
        Optional<String> opt = Optional.of(name);
        System.out.println(opt.isPresent());
    }

    private static void ofNull() {
        String name = null;
        System.out.println(Optional.of(name));
    }

    private static void ofNullable() {
        String name = "fox";
        Optional<String> opt = Optional.ofNullable(name);
        System.out.println(opt.isPresent());

        String nameNull = null;
        Optional<String> optNull = Optional.ofNullable(nameNull);
        System.out.println(optNull.isPresent());
    }

    public static String getMyDefault() {
        System.out.println("Getting Default Value");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        return "Default Value";
    }
}
