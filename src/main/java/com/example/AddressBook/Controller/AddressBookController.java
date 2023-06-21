package com.example.AddressBook.Controller;

import com.example.AddressBook.Model.Contact;
import com.example.AddressBook.Service.AddressbookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AddressBookController {
    @Autowired
    AddressbookInterface addressbookInterface;
    @PostMapping("/addContact")
    public String addContact(@RequestBody Contact contact){
        return addressbookInterface.addContact(contact);
    }
}
