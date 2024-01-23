package ru.testwork.notebook.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.testwork.notebook.dto.ContactFullDto;
import ru.testwork.notebook.dto.ContactUpsertDto;
import ru.testwork.notebook.exceptions.NotFoundException;
import ru.testwork.notebook.exceptions.ValidationException;
import ru.testwork.notebook.mappers.ContactMapper;
import ru.testwork.notebook.models.Contact;
import ru.testwork.notebook.repositories.ContactsRepository;

import java.util.List;

/**
 * {@inheritDoc}
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AppServiceImpl implements AppService {

    private final ContactsRepository contactsRepository;

    @Override
    public List<ContactFullDto> getAllContacts(int from, int size) {
        return contactsRepository.findAll(PageRequest.of(from, size))
                .map(ContactMapper::toContactFullDto).toList();
    }

    @Override
    public ContactFullDto createContact(ContactUpsertDto dto) {
        return ContactMapper.toContactFullDto(contactsRepository.save(ContactMapper.toContact(dto)));
    }

    @Override
    public ContactFullDto updateContact(ContactUpsertDto dto, Long id) {
        Contact contact = contactsRepository.findById(id).orElseThrow(() -> {
            log.warn("Contact not found for id = {}", id);
            return new NotFoundException("Contact not found for id = " + id);
        });
        if (dto.getEmail() != null) contact.setEmail(dto.getEmail());
        if (dto.getPhoneNumber() != null) contact.setPhoneNumber(dto.getPhoneNumber());
        if (dto.getName() != null) contact.setName(dto.getName());
        if (dto.getAddress() != null) contact.setAddress(dto.getAddress());
        return ContactMapper.toContactFullDto(contactsRepository.save(contact));
    }

    @Override
    public List<ContactFullDto> findContactByParameters(String name, String email, String address, String phoneNumber, int from, int size) {
        if (name == null && email == null && address == null && phoneNumber == null) {
            log.warn("No search parameters were specified");
            throw new ValidationException("No search parameters were specified");
        }
        return contactsRepository.findContactByParameters(name, email, address, phoneNumber)
                .stream().map(ContactMapper::toContactFullDto).toList();
    }

    @Override
    public void deleteContact(Long id) {
        contactsRepository.delete(
                contactsRepository.findById(id).orElseThrow(() -> {
                    log.warn("Contact not found for id = {}", id);
                    return new NotFoundException("Contact not found for id = " + id);
                }));
    }

    @Override
    public ContactFullDto getContact(Long id) {
        Contact contact = contactsRepository.findById(id).orElseThrow(() -> {
            log.warn("Contact not found for id = {}", id);
            return new NotFoundException("Contact not found for id = " + id);
        });
        return ContactMapper.toContactFullDto(contact);
    }
}
