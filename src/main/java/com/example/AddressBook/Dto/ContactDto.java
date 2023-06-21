package com.example.AddressBook.Dto;

import lombok.Data;

@Data
public class ContactDto {
    private String firstName;
    private String lastName;
    private String email;
    private String city;
    private String state;
}
