package duster.ramson.entity;

import javax.persistence.*;

@Entity
public class BookMany{
    private int id;
    private String name;
    private BookCategory bookCategory;

    public BookMany() {

    }

    public BookMany(String name) {
        this.name = name;
    }

    public BookMany(String name, BookCategory bookCategory) {
        this.name = name;
        this.bookCategory = bookCategory;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "book_category_id")
    public BookCategory getBookCategory() {
    	System.out.println("test");
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
}