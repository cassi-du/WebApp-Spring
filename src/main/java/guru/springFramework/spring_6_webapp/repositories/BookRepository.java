package guru.springFramework.spring_6_webapp.repositories;

import guru.springFramework.spring_6_webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
