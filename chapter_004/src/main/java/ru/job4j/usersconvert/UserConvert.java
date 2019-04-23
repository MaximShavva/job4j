package ru.job4j.usersconvert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * В классе показывается, как вызывать конструктор поссылке.
 * <p>
 * Интерфейс Function в данном примере может послужить нам
 * в качестве конструктора.
 */
public class UserConvert {
    public static class User {
        private final String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{"
                    + "name='" + name + '\''
                    + '}';
        }
    }

    /**
     * @param names Принимает список имён, из которых сделаем спасок объектов.
     * @param op    Функциональный интерфейс, куда подставим конструктор.
     * @return Список объектов User.
     */
    public List<User> convert(List<String> names, Function<String, User> op) {
        List<User> users = new ArrayList<>();
        names.forEach(n -> users.add(op.apply(n))
        );
        return users;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Petr", "Nick", "Ban");
        UserConvert users = new UserConvert();
        List<User> data = users.convert(names, User::new);
        data.forEach(System.out::println);
    }
}