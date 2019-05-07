package com.collabera.jump.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.collabera.jump.Employee;
import com.collabera.jump.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
