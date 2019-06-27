package com.group13.crypto_pin_test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>
{
    Optional<Instructor> findInstructorByPin(String pin);
}
