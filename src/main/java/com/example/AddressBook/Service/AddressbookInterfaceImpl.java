package com.example.AddressBook.Service;

import com.example.AddressBook.Dto.ContactDto;
import com.example.AddressBook.Model.Contact;
import com.example.AddressBook.Repository.ContactRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressbookInterfaceImpl implements AddressbookInterface {
    @Autowired
    private ContactRepo contactRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String addContact(ContactDto contactDto) {
        contactRepo.save(modelMapper.map(contactDto, Contact.class));
        return "contact save...";
    }

    @Override
    public Contact getContactById(int id) {
        return contactRepo.findById(id).orElseThrow();
    }

    @Override
    public String deleteContactById(int id) {
        if (contactRepo.existsById(id)) {
            contactRepo.deleteById(id);
            return "delete...";
        } else {
            return "contact not exist";
        }
    }

    @Override
    public String updateContactById(int id, ContactDto contactDto) {
        if (contactRepo.existsById(id)) {
            Contact contact = modelMapper.map(contactDto, Contact.class);
            contact.setId(id);
            contactRepo.save(contact);
            return "contact update...";
        } else {
            return "contact not exist...";
        }
    }
}