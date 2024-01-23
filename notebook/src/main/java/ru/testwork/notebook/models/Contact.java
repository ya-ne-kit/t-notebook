package ru.testwork.notebook.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * Контакт - основной объект, использующийся в приложении.
 */
@Entity
@Table(name = "contacts")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Contact {
    /**
     * Уникальный идентификатор контакта.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * имя контакта.
     */
    @Column
    private String name;

    /**
     * Адрес электронной почты контакта.
     */
    @Column
    private String email;

    /**
     * Адрес контакта.
     */
    @Column
    private String address;

    /**
     * Номер телефона контакта.
     */
    @Column(name = "phone_number")
    private Long phoneNumber;
}
