package com.vnext.interjava.userproduct.idea.repository;

import com.vnext.interjava.userproduct.idea.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

}
