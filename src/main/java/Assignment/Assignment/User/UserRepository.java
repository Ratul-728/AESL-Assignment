package Assignment.Assignment.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    Optional<User> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE User set name = :name, email = :email, address = :address WHERE id = :userId")
    void updateUser(@Param("userId") Long userId,
                    @Param("name") String name,
                    @Param("email") String email,
                    @Param("address") String address);
}
