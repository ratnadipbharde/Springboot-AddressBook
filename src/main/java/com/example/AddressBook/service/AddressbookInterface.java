package com.example.AddressBook.service;

import com.example.AddressBook.dto.ContactDto;
import com.example.AddressBook.dto.ResponseDto;
import com.example.AddressBook.model.Contact;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface AddressbookInterface {
    ResponseDto addContact(ContactDto contactDto);

    ResponseDto getContactById(int id);

    ResponseDto deleteContactById(int id);

    ResponseDto updateContactById(int id, ContactDto contactDto);

    List<Contact> getAllContactFromDb();
}
