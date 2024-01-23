package ru.testwork.notebook.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.testwork.notebook.dto.ContactFullDto;
import ru.testwork.notebook.dto.ContactUpsertDto;
import ru.testwork.notebook.services.AppService;

import java.util.List;

/**
 * Контроллер для управления контактами через API.
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class AppController {

    private final AppService appService;

    /**
     * Получение списка всех контактов с пагинацией.
     *
     * @param from начальная страница
     * @param size размер страницы
     * @return список {@link ContactFullDto}
     */
    @GetMapping("/all-contacts")
    public List<ContactFullDto> getAllContacts(@RequestParam(defaultValue = "0") Integer from,
                                               @RequestParam(defaultValue = "10") Integer size) {
        log.info("GET all contacts request received to endpoint [/api/all-contacts]");
        return appService.getAllContacts(from, size);
    }

    /**
     * Создание нового контакта.
     *
     * @param dto объект {@link ContactUpsertDto}, содержащий данные для создания нового контакта
     * @return объект {@link ContactFullDto} представляющий новосозданный контакт
     */
    @PostMapping("/new-contact")
    public ContactFullDto createContact(@RequestBody ContactUpsertDto dto) {
        log.info("POST new contact request received to endpoint [/api/new-contact]");
        return appService.createContact(dto);
    }

    /**
     * Обновление существующего контакта.
     *
     * @param id идентификатор контакта для обновления
     * @return объект {@link ContactFullDto} представляющий обновленный контакт
     */
    @GetMapping("/contact")
    public ContactFullDto findContact(@RequestParam Long id) {
        log.info("GET contact by id request received to endpoint [/api/contact]");
        return appService.getContact(id);
    }

    /**
     * Обновление существующего контакта.
     *
     * @param dto объект {@link ContactUpsertDto}, содержащий данные для обновления контакта
     * @param id  идентификатор контакта для обновления
     * @return объект {@link ContactFullDto} представляющий обновленный контакт
     */
    @PatchMapping("/update-contact")
    public ContactFullDto updateContact(@RequestBody ContactUpsertDto dto, @RequestParam Long id) {
        log.info("PATCH contact request received to endpoint [/api/update-contact]");
        return appService.updateContact(dto, id);
    }

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
    @GetMapping("/contacts")
    public List<ContactFullDto> findContactByParameters(@RequestParam(required = false) String name,
                                                        @RequestParam(required = false) String email,
                                                        @RequestParam(required = false) String address,
                                                        @RequestParam(required = false) String phoneNumber,
                                                        @RequestParam(defaultValue = "0") Integer from,
                                                        @RequestParam(defaultValue = "10") Integer size) {
        log.info("GET contacts by params request received to endpoint [/api/contacts]");
        return appService.findContactByParameters(name, email, address, phoneNumber, from, size);
    }

    /**
     * Удаление контакта по заданному идентификатору.
     *
     * @param id идентификатор контакта для удаления
     */
    @DeleteMapping("/contact")
    public void deleteContact(@RequestParam Long id) {
        log.info("DELETE contact by id request received to endpoint [/api/contact]");
        appService.deleteContact(id);
    }
}
