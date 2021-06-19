package com.laioffer.eco.repository;

import com.laioffer.eco.model.DispatchCenter;

import com.laioffer.eco.util.CenterID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DispatchCenterRepository extends JpaRepository<DispatchCenter, Long> {

    //optional return
    @Query("SELECT c FROM DispatchCenter c Where c.id = ?1")
    Optional<DispatchCenter> findDispatchCenterById(CenterID value);

    //object return
    @Query("SELECT c FROM DispatchCenter c Where c.id = ?1")
    DispatchCenter findCenterById(CenterID value);
}
