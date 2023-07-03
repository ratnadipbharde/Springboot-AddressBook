package com.example.AddressBook.service;


import com.example.AddressBook.dto.ContactDto;
import com.example.AddressBook.dto.ResponseDto;
import com.example.AddressBook.exception.CustomException;
import com.example.AddressBook.exception.ErrorResponse;
import com.example.AddressBook.model.Contact;
import com.example.AddressBook.repository.ContactRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressbookImpl implements AddressbookInterface {
    @Autowired
    private ContactRepo contactRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseDto addContact(ContactDto contactDto) {
        try {
            Contact contact = contactRepo.save(modelMapper.map(contactDto, Contact.class));
            ResponseDto response = new ResponseDto();
            response.setContact(contact);
            response.setMessage("User added successfully");
            return response;
        } catch (Exception ex) {
            throw new CustomException("Failed to add user: ");
        }
    }

    @Override
    public ResponseDto getContactById(int id) {
        Optional<Contact> optionalContact = contactRepo.findById(id);
        if (optionalContact.isPresent()) {
            Contact contact=modelMapper.map(optionalContact,Contact.class);
            ResponseDto response = new ResponseDto();
            response.setContact(contact);
            response.setMessage("data fetch successfully...");
            return response;
        } else {
            throw new CustomException("Contact not found with id :" + id);
        }
    }

    @Override
    public ResponseDto deleteContactById(int id) {
        Optional<Contact> contact = contactRepo.findById(id);
        if (contact.isPresent()) {
            contactRepo.deleteById(id);
            ResponseDto response = new ResponseDto();
            response.setMessage("delete successfully");
            return response;
        } else {
            throw new CustomException("Contact not found with id :" + id);
        }
    }

    @Override
    public ResponseDto updateContactById(int id, ContactDto contactDto) {
        Optional<Contact> optionalContact = contactRepo.findById(id);
        if (optionalContact.isPresent()) {
            Contact contact=modelMapper.map(contactDto,Contact.class);
            contact.setId(id);
            contactRepo.save(contact);
            ResponseDto response = new ResponseDto();
            response.setContact(contact);
            response.setMessage("update successfully...");
            return response;
        } else {
            throw new CustomException("Contact not found with id :" + id);
        }
    }

    @Override
    public List<Contact> getAllContactFromDb() {
        return contactRepo.findAll();
    }
}