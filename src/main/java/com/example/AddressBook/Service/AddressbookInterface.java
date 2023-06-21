package com.example.AddressBook.Service;

import com.example.AddressBook.Dto.ContactDto;
import com.example.AddressBook.Model.Contact;
import org.springframework.stereotype.Service;


@Service
public interface AddressbookInterface {
    String addContact(ContactDto contactDto);

    Contact getContactById(int id);

    String deleteContactById(int id);

    String updateContactById(int id, ContactDto contactDto);
}
