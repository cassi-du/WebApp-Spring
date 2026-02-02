package guru.springFramework.spring_6_webapp.bootstrap;

import guru.springFramework.spring_6_webapp.domain.Author;
import guru.springFramework.spring_6_webapp.domain.Book;
import guru.springFramework.spring_6_webapp.domain.Publisher;
import guru.springFramework.spring_6_webapp.repositories.AuthorRepository;
import guru.springFramework.spring_6_webapp.repositories.BookRepository;
import guru.springFramework.spring_6_webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author cassi = new Author();
        cassi.setFirstName("Cassiano");
        cassi.setLastName("Duarte");

        Book ddd = new Book();
        ddd.setTitle("Domain Drive Design");
        ddd.setIsbn("123456");

        Author cassiSaved = authorRepository.save(cassi);
        Book dddSaved = bookRepository.save(ddd);

        Author rod = new Author();
        rod.setFirstName("Rod");
        rod.setLastName("Johnson");

        Book noEJB = new Book();
        noEJB.setTitle("J2EE Development without EJB");
        noEJB.setIsbn("54757585");

        Author rodSaved = authorRepository.save(rod);
        Book noEJBSaved = bookRepository.save(noEJB);

        cassiSaved.getBooks().add(dddSaved);
        rodSaved.getBooks().add(noEJBSaved);
        dddSaved.getAuthors().add(cassiSaved);
        noEJBSaved.getAuthors().add(rodSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Cassio");
        publisher.setAddress("Rua sla");
        Publisher savedPublisher = publisherRepository.save(publisher);

        dddSaved.setPublisher(savedPublisher);
        noEJB.setPublisher(savedPublisher);

        authorRepository.save(cassiSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(dddSaved);
        bookRepository.save(noEJBSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());

        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
