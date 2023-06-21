package com.example.AddressBook.Service;

import com.example.AddressBook.Model.Contact;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface AddressbookInterface {
    String addContact(Contact contact);
}
