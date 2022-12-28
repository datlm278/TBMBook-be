package com.example.tbmbookbe.repositories;

import com.example.tbmbookbe.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
