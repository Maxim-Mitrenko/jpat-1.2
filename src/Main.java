import java.util.*;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        int size = input("Введите размер списка");
        int max = input("Введите верхнюю границу для значений");
        logger.log("Создаём и наполняем список");
        Random random = new Random();
        List<Integer> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(max));
        }
        logger.log("Вот случайный список: " + list);
        logger.log("Просим пользователя ввести входные данные для фильтрации");
        int filterNumber = input("Введите порог для фильтра");
        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(filterNumber);
        List<Integer> result = filter.filterOut(list);
        logger.log("Выводим результат на экран");
        System.out.println(result);
        logger.log("Завершаем программу");
        scanner.close();
    }

    public static int input(String msg) {
        Logger logger = Logger.getInstance();
        System.out.println(msg);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException exception) {
            logger.log("Пользователь ввёл не число! Повторно просим ввести");
            scanner.nextLine();
            return input("Повторно " + msg);
        }
    }
}
