package com.group13.crypto_pin_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class InstructorController
{
    @Autowired
    private InstructorRepository instructorRepository;

    @GetMapping("/instructor")
    public List<Instructor> RetrieveAllInstructors()
    {
        return instructorRepository.findAll();
    }

    @PostMapping("/instructor")
    public ResponseEntity<Object> createInstructor(@RequestBody Instructor instructor) {
        Instructor savedInstructor = instructorRepository.save(instructor);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedInstructor.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @GetMapping("/instructor/pin/")
    public Optional<Instructor> RetrieveInstructorByPin(@RequestParam(value = "encryptedPin") String encryptedPin)
    {
        Encryptor crypto = new Encryptor();

        //DEBUG
        System.out.println(String.format("Received encrypted pin %s", encryptedPin));

//        String pin = crypto.Decrypt(encryptedPin);
        String pin = crypto.Decrypt(encryptedPin);

        //DEBUG
        System.out.println(String.format("Looking up instructor pin %s", pin));

        Optional<Instructor> instructor = instructorRepository.findInstructorByPin(pin);

        return instructor;
    }
}
