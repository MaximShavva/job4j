package ru.job4j.address;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Класс для тестирования Profiles.collect().
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 25.04.2019г.
 */
public class ProfilesTest {

    /**
     * Тест выбора адресов с помощью Stream.map()
     */
    @Test
    public void whenProfilesThenAddresses() {
        List<Profile> profiles = List.of(
                new Profile("Arkadij Babchenko",
                        new Address("Moscow", "Lenin st.", 25, 38)),
                new Profile("Svetlana Babchenko",
                        new Address("Moscow", "Lenin st.", 25, 38)),
                new Profile("Phedor Tutchev",
                        new Address("Lenongrad", "Sennoi av.", 2, 228))
        );
        List<Address> addresses = new Profiles().collect(profiles);
        assertThat(addresses.toString(), is(List.of(
                new Address("Lenongrad", "Sennoi av.", 2, 228),
                new Address("Moscow", "Lenin st.", 25, 38)
        ).toString()));
    }
}