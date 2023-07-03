package com.example.AddressBook.dto;

import com.example.AddressBook.model.Contact;
import lombok.Data;

@Data
public class ResponseDto {
    Contact contact;
    String message;
}
