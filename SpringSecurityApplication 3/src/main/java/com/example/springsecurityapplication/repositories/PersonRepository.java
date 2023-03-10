package com.example.springsecurityapplication.repositories;

import com.example.springsecurityapplication.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    // Получаем запись из БД по логину
    Optional<Person> findByLogin(String login);

    // Запрос на получение пользователей по email адресу
    Optional<Person> findByEmail(String email);

    // Запрос на получение пользователей по номеру телефона
    Optional<Person> findByPhoneNumber(String phone_number);

    // Запрос на получение пользователей по фамилии
    Optional<Person> findByLastnameStartingWith (String starting_with);

    Optional<Person> findByPassword(String password);


    @Modifying
    @Query(value = "UPDATE person set password = ?2 where id=?1", nativeQuery = true)
    void updatePersonById(int id, String password);
}
