package ru.testwork.notebook.dto;

import lombok.*;

/**
 * DTO с полными данными о контакте.
 * исользуется в запросах, возвращающих информацию о контакте.
 */
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter
@Setter
public class ContactFullDto {

    /**
     * Уникальный идентификатор контакта.
     */
    private Long id;

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
