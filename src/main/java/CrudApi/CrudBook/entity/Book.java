package CrudApi.CrudBook.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotEmpty(message = "Không để trống")
    @Size(max = 50, min= 1 , message = "Không quá 50 kí tự")
    private String title;
    @Column(name = "Author")
    @NotEmpty(message = "Không để trống")
    @Size(max = 50, min= 1 , message = "Không quá 50 kí tự")
    private String author;
    @Column(name= "Image")
    private String image;

    @Column(name = "Price")
    @NotNull(message = "Không để trống")
    private Double price;


}
