package com.jay.bank_account_application.controller;

import com.jay.bank_account_application.model.Account;
import com.jay.bank_account_application.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 */
@RestController

@RequestMapping("/account")
public class AccountController {

    /**
     *
     *
     */
    @Autowired
    private AccountRepository accountRepository;

    // C - Create - POST - @PostMapping
    // R - Read - GET - GetMapping
    // U - Update - PUT @PutMapping
    // D - Delete - DELETE - @DeleteMapping

    @PostMapping("/createuser")
    /**
     * @RequestBody is used to bind the HTTP request body to a transfer or domain object
     */
    public ResponseEntity<Account> registerAccount(@RequestBody Account newAccount) {
        Account saveAccount = accountRepository.save(newAccount);

        return new ResponseEntity<>(saveAccount, HttpStatus.CREATED);

    }

    /**
     * @GetMapping is used to map HTTP GET requests onto specific handler methods
     * @param id is the primary key of the account
     * @return the account object
     * @ResponseStatus is used to return the status code 200
     *  accountRepository.findById is used to find the account object in the database
     *  account is the transfer object
     *  @PathVariable is used to bind the value of a URI template variable to a method parameter
     *  @RequestBody is used to bind the HTTP request body to a transfer or domain object
     */
    @GetMapping("/getuser/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") long id) {
        Account account = accountRepository.findById(id).get();
        return new ResponseEntity<>(account, HttpStatus.OK);
    }


    @GetMapping("/getallusers")
    /**
     * @GetMapping is used to map HTTP GET requests onto specific handler methods
     * @return the list of account objects
     * @ResponseStatus is used to return the status code 200
     * accountRepository.findAll is used to find all the account objects in the database
     * accountList is the transfer object
     */
    public ResponseEntity<Iterable<Account>> getAllAccounts() {
        /**
         * Iterable is an interface that represents a group of objects, of the same type, that can be iterated over.
         * Iterable is the parent interface of List, Set, and Queue.
         * Iterable is implemented by the classes ArrayList, LinkedList, HashSet, TreeSet, PriorityQueue, and ArrayDeque.
         */
        Iterable<Account> accounts = accountRepository.findAll();
        /**
         * ResponseEntity is used to return a response entity
         * HttpStatus.OK is used to return the status code 200
         * accounts is the transfer object
         */
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PutMapping("/updateuser")
    /**
     * @PutMapping is used to map HTTP PUT requests onto specific handler methods
     * @param account is the domain object
     * @return the account object
     * @ResponseStatus is used to return the status code 200
     * accountRepository.save is used to save the account object in the database
     * account is the transfer object
     */
    public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
        Account updatedAccount = accountRepository.save(account);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }

    @DeleteMapping("/deleteuser/{id}")
    /**
     * @DeleteMapping is used to map HTTP DELETE requests onto specific handler methods
     * @param id is the primary key of the account
     * @ResponseStatus is used to return the status code 200
     * accountRepository.deleteById is used to delete the account object in the database
     */
    public ResponseEntity<Account> deleteAccount(@PathVariable("id") long id) {
        accountRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteallusers")
    /**
     * @DeleteMapping is used to map HTTP DELETE requests onto specific handler methods
     * @ResponseStatus is used to return the status code 200
     * accountRepository.deleteAll is used to delete all the account objects in the database
     */
    public ResponseEntity<Account> deleteAllAccounts() {
        accountRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
