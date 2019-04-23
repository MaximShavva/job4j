package ru.job4j.codify;

import java.util.*;


/**
 * Тестовое задание: Создать структуру подразделений предприятия
 * возможностью их сортировки в по возрастанию названий и по убыванию названий.
 *
 * @author Шавва Максим.
 * @version 1.
 * @since 20.04.2019г.
 */
public class Departments {

    /**
     * Класс содержит подразделение с головным отделом и дочерним
     * подразделением в виде списка названий подразделений.
     */
    public static final class Org implements Comparable<Org> {
        /**
         * Подразделения в порядке их старшинства.
         */
        private final List<String> deps;

        public Org(List<String> deps) {
            this.deps = deps;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Org org = (Org) o;
            return Objects.equals(deps, org.deps);
        }

        @Override
        public int hashCode() {
            return Objects.hash(deps);
        }

        @Override
        public int compareTo(Org o) {
            int result = this.deps.get(0).compareTo(o.deps.get(0));
            if (result == 0) {
                if (this.deps.size() == 1 && o.deps.size() > 1) {
                    result = -1;
                }
                if (this.deps.size() > 1 && o.deps.size() == 1) {
                    result = 1;
                }
                if (this.deps.size() > 1 && o.deps.size() > 1) {
                    result = this.deps.get(1).compareTo(o.deps.get(1));
                }
            }
            if (result == 0) {
                if (this.deps.size() == 2 && o.deps.size() > 2) {
                    result = -1;
                }
                if (this.deps.size() > 2 && o.deps.size() == 2) {
                    result = 1;
                }
                if (this.deps.size() > 2 && o.deps.size() > 2) {
                    result = this.deps.get(2).compareTo(o.deps.get(2));
                }
            }
            return result;
        }

        @Override
        public String toString() {
            return deps.toString();
        }
    }

    /**
     * @param deps получаем список отделов с вложением подотделов (K2\SK1\SSK1)
     * @return список структурных подразделений.
     */
    public List<Org> convert(List<String> deps) {
        List<Org> orgs = new ArrayList<>();
        for (String rec : deps) {
            String[] path = rec.split("/");
            List<String> addition = new ArrayList<>();
            for (String segment : path) {
                addition.add(segment);
                Departments.Org org = new Departments.Org(new ArrayList<>(addition));
                if (!orgs.contains(org)) {
                    orgs.add(org);
                }
            }
        }
        return orgs;
    }

    /**
     * @param orgs Cписок несортированных структурных подразделений.
     * @return Cписок сортированных структурных подразделений по возрастанию:
     * “K1”
     * “K1\SK1”
     * “K1\SK1\SSK1”
     * “K1\SK1\SSK2”
     * “K1\SK2”
     * “K2”
     * “K2\SK1”
     * “K2\SK1\SSK1”
     * “K2\SK1\SSK2”.
     */
    public List<Org> sortAsc(List<Org> orgs) {
        orgs.sort(new Comparator<>() {
            @Override
            public int compare(Org o1, Org o2) {
                return o1.compareTo(o2);
            }
        });
        return orgs;
    }

    /**
     * @param orgs Cписок несортированных структурных подразделений.
     * @return Cписок сортированных структурных подразделений по убыванию:
     * “K2”
     * “K2\SK1”
     * “K2\SK1\SSK2”
     * “K2\SK1\SSK1”
     * “K1”
     * “K1\SK2”
     * “K1\SK1”
     * “K1\SK1\SSK2”
     * “K1\SK1\SSK1”
     */
    public List<Org> sortDesc(List<Org> orgs) {
        orgs.sort(new Comparator<Org>() {
            @Override
            public int compare(Org o2, Org o1) {
                return o1.deps.get(0).compareTo(o2.deps.get(0));
            }
        }.thenComparing(new Comparator<Org>() {
            @Override
            public int compare(Org o2, Org o1) {
                int result = 0;
                if (o1.deps.size() == 1 && o2.deps.size() > 1) {
                    result = 1;
                }
                if (o1.deps.size() > 1 && o2.deps.size() == 1) {
                    result = -1;
                }
                if (o1.deps.size() > 1 && o2.deps.size() > 1) {
                    result = o1.deps.get(1).compareTo(o2.deps.get(1));
                }
                return result;
            }
        }.thenComparing(new Comparator<>() {
            @Override
            public int compare(Org o2, Org o1) {
                int result = 0;
                if (o1.deps.size() == 2 && o2.deps.size() > 2) {
                    result = 1;
                }
                if (o1.deps.size() > 2 && o2.deps.size() == 2) {
                    result = -1;
                }
                if (o1.deps.size() > 2 && o2.deps.size() > 2) {
                    result = o1.deps.get(2).compareTo(o2.deps.get(2));
                }
                return result;
            }
        })));
        return orgs;
    }
}