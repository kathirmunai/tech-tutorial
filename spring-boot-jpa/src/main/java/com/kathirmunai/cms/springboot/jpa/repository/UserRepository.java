package com.kathirmunai.cms.springboot.jpa.repository;  
import org.springframework.data.repository.CrudRepository;

import com.kathirmunai.cms.springboot.jpa.model.UserRecord;  

public interface UserRepository extends CrudRepository<UserRecord, String> 
{  
}  
