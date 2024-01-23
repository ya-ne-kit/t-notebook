package ru.testwork.notebook.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * DTO с параметрами контакта, получаемого от пользователя.
 * используется в запросах для добавления и изменения (обновления) контакта.
 */
@RequiredArgsConstructor
@Getter
@Setter
public class ContactUpsertDto {
    /**
     * имя контакта.
     */
    private String name;

    /**
     * Адрес электронной почты контакта.
     */
    private String email;

    /**
     * Адрес контакта.
     */
    private String address;

    /**
     * Номер телефона контакта.
     */
    private Long phoneNumber;
}
