package CrudApi.CrudBook.repository;

import CrudApi.CrudBook.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Long> {
}
