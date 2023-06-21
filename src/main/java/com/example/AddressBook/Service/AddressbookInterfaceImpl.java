package com.example.AddressBook.Service;

import com.example.AddressBook.Model.Contact;
import com.example.AddressBook.Repository.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressbookInterfaceImpl implements AddressbookInterface{
    @Autowired
    private ContactRepo contactRepo;

    @Override
    public String addContact(Contact contact) {
         contactRepo.save(contact);
        return "contact save...";
    }
}
