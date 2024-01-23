package ru.testwork.notebook.services;

import ru.testwork.notebook.dto.ContactFullDto;
import ru.testwork.notebook.dto.ContactUpsertDto;
import ru.testwork.notebook.exceptions.NotFoundException;
import ru.testwork.notebook.exceptions.ValidationException;

import java.util.List;


/**
 * Сервис для работы с контактами.
 */
public interface AppService {

    /**
     * Получение списка всех контактов с пагинацией.
     *
     * @param from начальная страница
     * @param size размер страницы
     * @return список {@link ContactFullDto}
     */
    List<ContactFullDto> getAllContacts(int from, int size);

    /**
     * Создание нового контакта на основе переданных данных.
     *
     * @param dto объект {@link ContactUpsertDto}, содержащий данные для создания нового контакта
     * @return объект {@link ContactFullDto} представляющий новосозданный контакт
     */
    ContactFullDto createContact(ContactUpsertDto dto);

    /**
     * Обновление существующего контакта на основе переданных данных.
     *
     * @param dto объект {@link ContactUpsertDto}, содержащий данные для обновления контакта
     * @param id идентификатор контакта для обновления
     * @return объект {@link ContactFullDto}, представляющий обновленный контакт
     * @throws NotFoundException выбрасывается, если контакт не найден по заданному идентификатору
     */
    ContactFullDto updateContact(ContactUpsertDto dto, Long id);

    /**
     * Поиск контактов по заданным параметрам.
     *
     * @param name        имя контакта для поиска
     * @param email       email контакта для поиска
     * @param address     адрес контакта для поиска
     * @param phoneNumber номер телефона контакта для поиска
     * @param from        начальная страница
     * @param size        размер страницы
     * @return список {@link ContactFullDto}, удовлетворяющих указанным параметрам
     */
    List<ContactFullDto> findContactByParameters(String name, String email, String address, String phoneNumber, int from, int size);

    /**
     * Удаление контакта по заданному идентификатору.
     *
     * @param id идентификатор контакта для удаления
     * @throws NotFoundException выбрасывается, если контакт не найден по заданному идентификатору
     */
    void deleteContact(Long id);

    /**
     * Поиск контакта по заданному идентификатору.
     *
     * @param id идентификатор искомого контакта
     * @throws NotFoundException выбрасывается, если контакт не найден по заданному идентификатору
     */
    ContactFullDto getContact(Long id);
}
