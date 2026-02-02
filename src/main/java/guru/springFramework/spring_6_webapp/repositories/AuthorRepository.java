package guru.springFramework.spring_6_webapp.repositories;

import guru.springFramework.spring_6_webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository  extends CrudRepository<Author, Long> {
}
