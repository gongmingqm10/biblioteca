package com.twu.biblioteca;

import com.twu.biblioteca.dao.BookShelf;
import com.twu.biblioteca.model.Book;

import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    private static BookShelf bookShelf;

    public static void main(String[] args) {
        System.out.println("Hello, world!");
        bookShelf = new BookShelf("books.csv");
        BibliotecaApp app = new BibliotecaApp();
        app.showMenu();
        while(true) {
            System.out.print("select menu: ");
            Scanner in = new Scanner(System.in);
            switch (in.nextInt()) {
                case 1:
                    app.loadBookDetail(bookShelf.listBooks());
                    break;
                case 2:
                    app.checkout();
                    break;
                case 3:
                    app.returnBook();
                    break;
                case 4:
                    app.quit();
                    break;
                default:
                    app.invalidMenuOption();
                    break;
            }
        }

    }

    public void checkout() {
        System.out.print("Whick book you want to checkout: ");
        Scanner number = new Scanner(System.in);
        int targetPosition = number.nextInt();
        if (targetPosition <= 0 || targetPosition > bookShelf.listBooks().size()) {
            System.out.println("The book is not available");
        } else {
            bookShelf.checkoutBook(targetPosition - 1);
            System.out.println("Thank you! Enjoy the book");
        }
    }

    public void returnBook() {
        if (bookShelf.getCheckoutList() == null || bookShelf.getCheckoutList().size() == 0) {
            System.out.println("There is no book to return");
        } else {
            loadBookDetail(bookShelf.getCheckoutList());
            System.out.print("Choose the book you want to return: ");
            Scanner number = new Scanner(System.in);
            int targetPosition = number.nextInt();
            if (targetPosition <= 0 || targetPosition > bookShelf.getCheckoutList().size()) {
                System.out.println("That is not a valid book to return");
            } else {
                bookShelf.returnBook(targetPosition - 1);
                System.out.println("Thank you for returning the book");
            }
        }
    }

    public void quit() {
        System.out.println("App quit successfully.");
        System.exit(0);
    }

    public void invalidMenuOption() {
        System.out.println("Select a valid option!");
    }

    public void showMenu() {
        String[] menus = {"List Books[1]", "Checkout Book[2]", "Return Book[3]", "Quit[4]"};
        for (String menu : menus) {
            System.out.print(menu + "  ");
        }
        System.out.println();
    }
    public void loadBookDetail(List<Book> books) {
        int i = 1;
        for (Book book : books) {
            System.out.println( i++ + ". " +book.getName() + ", " + book.getAuthor() + ", " + book.getPublishYear());
        }
    }

}
