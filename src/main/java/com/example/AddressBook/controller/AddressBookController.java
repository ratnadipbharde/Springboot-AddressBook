package com.example.AddressBook.controller;

import com.example.AddressBook.dto.ContactDto;

import com.example.AddressBook.dto.ResponseDto;
import com.example.AddressBook.model.Contact;
import com.example.AddressBook.service.AddressbookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class AddressBookController {
    @Autowired
    AddressbookInterface addressbookInterface;

    @GetMapping("/getAllContact")
    List<Contact> getAllContact(){
        return addressbookInterface.getAllContactFromDb();
    }

    @PostMapping("/addContact")
    public ResponseDto addContact(@RequestBody ContactDto contactDto) {
        return addressbookInterface.addContact(contactDto);
    }

    @GetMapping("/getContactById")
    public ResponseDto getContactById(@RequestParam int id) {
        return addressbookInterface.getContactById(id);
    }

    @DeleteMapping("/deleteContactById")
    public ResponseDto deleteContactById(@RequestParam int id) {
        return addressbookInterface.deleteContactById(id);
    }

    @PutMapping("/updateContactById")
    public ResponseDto updateContactById(@RequestParam int id, @RequestBody ContactDto contactDto) {
        return addressbookInterface.updateContactById(id, contactDto);
    }
}