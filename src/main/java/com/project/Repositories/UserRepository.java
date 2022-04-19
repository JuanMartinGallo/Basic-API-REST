package com.project.Repositories;

import java.util.ArrayList;

import com.project.Models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    public abstract ArrayList<User> findByPriority(Integer priority);
}
