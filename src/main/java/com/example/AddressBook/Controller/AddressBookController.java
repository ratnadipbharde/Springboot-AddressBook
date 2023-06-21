package com.example.AddressBook.Controller;

import com.example.AddressBook.Dto.ContactDto;

import com.example.AddressBook.Model.Contact;
import com.example.AddressBook.Service.AddressbookInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class AddressBookController {
    @Autowired
    AddressbookInterface addressbookInterface;

    @PostMapping("/addContact")
    public String addContact(@RequestBody ContactDto contactDto) {
        return addressbookInterface.addContact(contactDto);
    }

    @GetMapping("/getContactById")
    public Contact getContactById(@RequestParam int id){
        return addressbookInterface.getContactById(id);
    }

    @DeleteMapping("/deleteContactById")
    public String deleteContactById(@RequestParam int id){
        return addressbookInterface.deleteContactById(id);
    }

}
