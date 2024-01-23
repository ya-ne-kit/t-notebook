package ru.testwork.notebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.testwork.notebook.models.Contact;


/**
 * Репозиторий с контактами.
 */
public interface ContactsRepository extends JpaRepository<Contact, Long> {

}
