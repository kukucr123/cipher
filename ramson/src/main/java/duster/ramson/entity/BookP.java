package duster.ramson.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class BookP{
    private int id;
    private String name;
    private Set<Publisher> publishers;

    public BookP() {

    }

    public BookP(String name) {
        this.name = name;
    }

    public BookP(String name, Set<Publisher> publishers){
        this.name = name;
        this.publishers = publishers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
    	System.out.println("test");
        return id;
    }

    public void setId(int id) {
    	System.out.println("test");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "book_publisher", joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "publisher_id", referencedColumnName = "id"))
    public Set<Publisher> getPublishers() {
        return publishers;
    }

    public void setPublishers(Set<Publisher> publishers) {
        this.publishers = publishers;
    }

    @Override
    public String toString() {
        String result = String.format(
                "Book [id=%d, name='%s']%n",
                id, name);
        if (publishers != null) {
            for(Publisher publisher : publishers) {
                result += String.format(
                        "Publisher[id=%d, name='%s']%n",
                        publisher.getId(), publisher.getName());
            }
        }

        return result;
    }
}