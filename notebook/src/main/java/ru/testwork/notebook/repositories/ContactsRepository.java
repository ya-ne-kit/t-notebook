package ru.testwork.notebook.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.testwork.notebook.models.Contact;

import java.util.List;

/**
 * Репозиторий с контактами.
 */
public interface ContactsRepository extends JpaRepository<Contact, Long> {
    /**
     * Запрос из БД списка контактов, удовлетворяющих поисковому запросу по одному или нескольким критериям (параметрам) поиска.
     *
     * @param name        имя контакта
     * @param email       электронный адрес контакта
     * @param address     адрес контакта
     * @param phoneNumber номер телефона контакта
     * @return список {@link Contact}, удовлетворяющих указанным параметрам
     */
    @Query("SELECT c FROM Contact c WHERE " +
            "(:name IS NULL OR c.name LIKE %:name%) AND " +
            "(:email IS NULL OR c.email LIKE %:email%) AND " +
            "(:address IS NULL OR c.address LIKE %:address%) AND " +
            "(:phoneNumber IS NULL OR c.phoneNumber = :phoneNumber)")
    List<Contact> findContactByParameters(@Param("name") String name,
                                          @Param("email") String email,
                                          @Param("address") String address,
                                          @Param("phoneNumber") String phoneNumber);
}
