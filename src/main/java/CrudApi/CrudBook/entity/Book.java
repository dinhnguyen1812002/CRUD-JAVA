package CrudApi.CrudBook.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Book")
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Author")
    private String author;
    @Column(name= "Image")
    private String image;
    @Column(name = "Price")
    private Double price;

}
