import com.sun.jdi.request.ExceptionRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        while (true) {
            System.out.println("Выберите одну из операций: 1. Добавить; 2. Показать; 3. Удалить; 4. Поиск; 5. Завершить работу");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch(choice) {
                case 1: {
                    System.out.println("Какую покупку хотите добавить?");
                    String product = scanner.next();
                    list.add(product);
                    System.out.println("Итого в списке покупок: " + list.size());
                    break;
                }
                case 2: {
                    printList(list);
                    break;
                }
                case 3 : {
                    printList(list);
                    System.out.println("Какую хотите удалить? Введите номер или название:");
                    String productToDelete = scanner.next();
                    String productName = productToDelete;
                    try {
                        int productNumber = Integer.parseInt(productToDelete);
                        productName = list.get(productNumber - 1);
                        list.remove(productNumber - 1);
                    } catch(Exception e) {
                        list.remove(productToDelete);
                    }
                    System.out.println("Покупка " + productName + " удалена,");
                    break;
                }
                case 4 : {
                    String productSearch = scanner.next();
                    System.out.println ("Найдено: ");
                    for (String product : list) {
                        if (product.toLowerCase().contains (productSearch.toLowerCase())) {
                            System.out.println ((list.indexOf(product) +1) + " " + product);
                        }

                    }
                    break;
                }
                case 5 : {
                    System.exit(0);
                }
            }
        }

    }

    private static void printList(List<String> list) {
        System.out.println("Список покупок:");
        for (int i = 0; i< list.size(); i++) {
            System.out.println((i+1) + ". " + list.get(i));
        }
    }
}