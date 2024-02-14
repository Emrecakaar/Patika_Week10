import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", columnDefinition = "serial")
    private int id;


    @Column(name = "book_name", nullable = false, unique = true)
    private String bookName;


    @Column(name = "book_publication_year")
    private LocalDate publicationYear;

    @Column(name = "book_stock")
    private int bookStock;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "book_category_id", referencedColumnName = "category_id")
    private Category category;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "book_author_id", referencedColumnName = "author_id")
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_borrowing_id", referencedColumnName = "borrowing_id")
    private BookBorrowing bookBorrowing;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "book2publisher",
            joinColumns = {@JoinColumn(name = "book2publisher_book_id")},
            inverseJoinColumns = {@JoinColumn(name = "book2publisher_publisher_id")}
            //bu kısımda book ile publisher i ilişkilendirdim.
    )
    private List<Publisher> publisherList;

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int book_id) {
        this.id = book_id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String book_name) {
        this.bookName = book_name;
    }

    public LocalDate getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(LocalDate publication_year) {
        this.publicationYear = publication_year;
    }

    public int getBookStock() {
        return bookStock;
    }

    public void setBookStock(int book_stock) {
        this.bookStock = book_stock;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public BookBorrowing getBookBorrowing() {
        return bookBorrowing;
    }

    public void setBookBorrowing(BookBorrowing bookBorrowing) {
        this.bookBorrowing = bookBorrowing;
    }

    public List<Publisher> getPublisherList() {
        return publisherList;
    }

    public void setPublisherList(List<Publisher> publisherList) {
        this.publisherList = publisherList;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", publicationYear=" + publicationYear +
                ", bookStock=" + bookStock +
                ", category=" + category +
                ", author=" + author +
                ", bookBorrowing=" + bookBorrowing +
                ", publisherList=" + publisherList +
                '}';
    }
}
