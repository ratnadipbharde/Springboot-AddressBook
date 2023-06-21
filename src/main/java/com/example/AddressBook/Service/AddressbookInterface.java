package com.example.AddressBook.Service;

import com.example.AddressBook.Dto.ContactDto;
import org.springframework.stereotype.Service;


@Service
public interface AddressbookInterface {
    String addContact(ContactDto contactDto);
}
