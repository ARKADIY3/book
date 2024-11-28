import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


class Main {
    public static void main(String[] args) {


        Book book1 = new Book("Автор :", "Название книги :", "Издатель :", "Год :", "Страна :","Раздел библеотеки :");

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();



        Scanner input = new Scanner(System.in);

        System.out.println("создать txt или ввести существуемый");
        String str = input.nextLine();

        if(a == 1){
            try {
                File newFile = new File(str + ".txt");
                if (newFile.createNewFile()) {
                    System.out.println("Вы успешно создали свою личную библиотеку, время заполнить её книгами!");
                } else {
                    System.out.println("У вас уже есть своя личная библиотека.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (a==2) {
            try {

                Scanner input1 = new Scanner(System.in);

                System.out.println("Укажите имя автора");
                String Avtor = input1.nextLine();

                System.out.println("Укажите название книги");
                String Title = input1.nextLine();

                System.out.println("Укажите издателя");
                String Publisher = input1.nextLine();

                System.out.println("Укажите год выпуска");
                String Year = input1.nextLine();

                System.out.println("Укажите строну");
                String Country = input1.nextLine();

                System.out.println("Укажите раздел библиотеки");
                String lilibrarySection = input1.nextLine();

                FileWriter writer = new FileWriter(str + ".txt");
                writer.write(book1.getAuthor() + " " + Avtor + "\n\r");
                writer.write(book1.getTitle() + " " + Title + "\n\r");
                writer.write(book1.getPublisher() + " " + Publisher + "\n\r");
                writer.write(book1.getYear() + " " + Year + "\n\r");
                writer.write(book1.getCountry() + " " + Country + "\n\r");
                writer.write(book1.getLibrarySection() + " " +  lilibrarySection+ "\n\r");
                writer.close();
                System.out.println("Запись данных в файл прошла успешно");
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл");
                e.printStackTrace();
            }
        } else if (a==3) {
            try (FileReader reader = new FileReader(str + ".txt")) {
                int c;
                while ((c = reader.read()) != -1) {
                    System.out.print((char) c);
                }
            } catch (IOException e) {
                System.out.println("Считать файл не получилось");
                e.printStackTrace();
            }
        } else if (a == 4) {
            File file = new File(str + ".txt");

            if (file.delete()) {
                System.out.println("Файл успешно удален.");
            } else {
                System.out.println("Не удалось удалить файл.");
            }
        }else {
            System.out.println("такое значения в меню нет ");
        }
    }
}