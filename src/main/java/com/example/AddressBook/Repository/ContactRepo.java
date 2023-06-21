package com.example.AddressBook.Repository;

import com.example.AddressBook.Model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepo extends JpaRepository<Contact,Integer> {
}
