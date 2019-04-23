package ru.job4j.exchange;

import java.util.*;

/**
 * Реализован банкомат размена денег.
 * Автомат принимает бумажную купюру и обменивает на монеты.
 * Метод exchange возвращает список всех
 * возможных вариантов размена купюры.
 *
 * @author Шавва Максим (masyam@mail.ru)
 * @version 1
 * @since 23.04.2019г.
 */
public class CashMachine {

    /**
     * Массив номиналов монет для размена.
     */
    private final int[] values;

    /**
     * Храним монетки в отсортированном виде от большей к меньшей.
     */
    private NavigableSet<Integer> coins;

    public CashMachine(final int[] values) {
        this.values = values;
        coins = Util.sortCoin(values);
    }

    /**
     * @param note Значение денежной купюры для размена.
     * @return список из всех разменных "наборов".
     */
    public List<List<Integer>> exchange(int note) {
        return recChange(note, coins.pollFirst());
    }

    /**
     * Метод рекурсивно возвращает список из некоторого количества
     * самой большой монеты и остатков денег, разменяных меньшими монетами.
     *
     * @param residue остаток денег, который нужно разменять.
     * @param coin    старшая разменная монета.
     * @return список из всех разменных "наборов".
     */
    private List<List<Integer>> recChange(int residue, Integer coin) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tail;
        if (coin != null) {
            for (int i = residue / coin; i >= 0; i--) {
                tail = makeBale(i, coin);
                if (coin * i == residue) {
                    result.add(tail);
                } else {
                    for (List<Integer> list : recChange((residue - i * coin), coins.pollFirst())) {
                        result.add(Util.listUnion(tail, list));
                    }
                }
            }
            coins.add(coin);
        }
        return result;
    }

    /**
     * @param times сколько монеток будет в списке.
     * @param val   номинал монетки.
     * @return список монеток одного номинала.
     */
    private List<Integer> makeBale(int times, Integer val) {
        List<Integer> bale = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            bale.add(val);
        }
        return bale;
    }
}

class Util {

    /**
     * @param first перывй список для объединения.
     * @param last  второй список для объединения.
     * @return последовательно перывй список + второй список.
     */
    public static List<Integer> listUnion(List<Integer> first, List<Integer> last) {
        List<Integer> line = new ArrayList<>();
        line.addAll(first);
        line.addAll(last);
        return line;
    }

    /**
     * @param values Сортируем массив values.
     * @return Сет в порядке, обратном натуральному.
     */
    public static TreeSet<Integer> sortCoin(int[] values) {
        TreeSet<Integer> coins = new TreeSet<>(Comparator.reverseOrder());
        for (Integer coin : values) {
            coins.add(coin);
        }
        return coins;
    }
}