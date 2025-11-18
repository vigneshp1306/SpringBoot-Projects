package com.example.CRUD.Repository;

import com.example.CRUD.Model.CRUDEntity;
import com.mysql.cj.log.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRUDRepository extends JpaRepository<CRUDEntity,Long > {

}
