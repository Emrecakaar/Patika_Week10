import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("library");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
/*
        Category category = new Category();
        category.setName("Books");
        entityManager.persist(category);


        Author author = new Author();
        author.setAuthorName("Emre Cakar");
        author.setAuthorCountry("Turkey");
        author.setAuthorBirthday(LocalDate.of(2000, 1, 28));
        entityManager.persist(author);



        BookBorrowing bookBorrowing = new BookBorrowing();
        bookBorrowing.setBorrowerName("Cemal ekmekçi");
        bookBorrowing.setBorrowingDate(LocalDate.now());
        entityManager.persist(bookBorrowing);

        Book book = new Book();
        book.setBookName("birds fly");
        book.setAuthor(author);
        book.setBookBorrowing(bookBorrowing);
        book.setCategory(category);
        book.setPublicationYear(LocalDate.of(2007, 3, 15));
        book.setBookStock(15);
        entityManager.persist(book);
        */
        Publisher publisher = new Publisher();
        publisher.setPublisherName("Gaziantep");
        publisher.setAddress("cadde sokak mahalle");
        publisher.setEstablishmentYear(LocalDate.of(2004, 2, 27));
        entityManager.persist(publisher);

        Book book = entityManager.find(Book.class, 1);
        List<Publisher> publisherList = book.getPublisherList();
        publisherList.add(publisher);


        transaction.commit();
    }
}
