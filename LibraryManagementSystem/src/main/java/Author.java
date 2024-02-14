import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", columnDefinition = "serial") //columnDefinition id yi otomatik arttırır.
    private int id;

    @Column(name = "author_name", length = 100, nullable = false)
    //yazarın adı boş olamaz dedim nullable ı false yaparak
    private String authorName;

    @Temporal(TemporalType.DATE)//Burada date işlemi yapacağımızı belirttim
    @Column(name = "author_birthday")
    private LocalDate authorBirthday;

    @Column(name = "author_country")
    private String authorCountry;

    @OneToOne(mappedBy = "author", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//burada CascadeType.ALL kısmı neden kullanıldı öğreneceğim (kendime bir not bu kısım)
    private Book book;


    public Author() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDate getAuthorBirthday() {
        return authorBirthday;
    }

    public void setAuthorBirthday(LocalDate author_birthday) {
        this.authorBirthday = author_birthday;
    }

    public String getAuthorCountry() {
        return authorCountry;
    }

    public void setAuthorCountry(String author_country) {
        this.authorCountry = author_country;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", author_name='" + authorName + '\'' +
                ", author_birthday=" + authorBirthday +
                ", author_country='" + authorCountry + '\'' +
                '}';
    }
}
