public class Library {
    public static void main(String[] args) {
        Book b1 = new Book("How to develop", "Muhammed Daniyel", 310);
        Book b2 = new Book("How to not develop", "Daniyel Muhammed", 328);
        Textbook tb = new Textbook("Java Programming", "Bro Code", 500, "Computer Science", 3);

        b1.displayInfo();
        b1.borrowBook();
        b1.returnBook();

        System.out.println();

        b2.displayInfo();

        System.out.println();

        tb.displayInfo();
        tb.borrowBook();
    }
}
