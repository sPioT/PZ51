/**
 * 
 */
package com.zone51.manhattan.core.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zone51.manhattan.core.domain.User;

/**
 * @author piot
 *
 */
public interface IUserRepository extends JpaRepository<User, Long> {

}
