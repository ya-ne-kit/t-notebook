package ru.testwork.notebook.mappers;

import ru.testwork.notebook.dto.ContactFullDto;
import ru.testwork.notebook.dto.ContactUpsertDto;
import ru.testwork.notebook.models.Contact;

/**
 * Класс-маппер для преобразования объектов Contact и связанных DTO.
 */
public class ContactMapper {
    /**
     * Преобразует Contact в ContactFullDto.
     *
     * @param model модель типа {@link Contact}, которую необходимо преобразовать
     * @return объект типа {@link ContactFullDto}, полученный в результате преобразования
     */
    public static ContactFullDto toContactFullDto(Contact model) {
        return ContactFullDto.builder().id(model.getId())
                .address(model.getAddress())
                .name(model.getName())
                .email(model.getEmail())
                .phoneNumber(model.getPhoneNumber())
                .build();
    }

    /**
     * Преобразует ContactUpsertDto в Contact.
     *
     * @param dto объект типа {@link ContactUpsertDto}, который необходимо преобразовать
     * @return модель типа {@link Contact}, полученная в результате преобразования
     */
    public static Contact toContact(ContactUpsertDto dto) {
        return Contact.builder()
                .address(dto.getAddress())
                .name(dto.getName())
                .email(dto.getEmail())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }
}
