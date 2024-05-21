package com.mftplus.secondsecurityservice.repository;

import com.mftplus.secondsecurityservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query("update userEntity oo set oo.deleted=true where oo.id=:id")
    void logicalRemove(Long id);

    List<User> findUserByDeletedFalse();

    Optional<User> findUserByIdAndDeletedFalse(Long id);

    Optional<User> findUserByUsernameAndDeletedFalse(String username);

    boolean existsUserByUsernameAndDeletedFalse(String username);

    Long countByDeletedFalse();
}
