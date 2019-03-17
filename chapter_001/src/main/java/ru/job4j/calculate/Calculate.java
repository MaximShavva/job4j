package ru.job4j.calculate;

/**
* Класс Calculate - первая программа "Hello World"
* @author Шавва Максим
* @since 16.03.2019г.
* @version 1
*/
public class Calculate {

	/**
	* Метод выводит в консоль строку "Hello World!"
	* @param args принимает набор аргументов строкового
	* типа из строки запуска программы.
	*/	
	public static void main(String[] args) {
		System.out.println("Hello World!");
	}
	
	/**
     * Method echo.
     * @param name Ваше имя.
     * @return Эхо, эхо, эхо и ваше имя.
     */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
}
