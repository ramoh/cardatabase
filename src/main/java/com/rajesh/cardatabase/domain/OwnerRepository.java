package com.rajesh.cardatabase.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//this is a test comment asdasd
@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
