package com.freightcom.clickship.data.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.freightcom.clickship.data.entity.JWT;
import com.freightcom.clickship.data.entity.User;

@Repository
public interface JWTRepository extends JpaRepository<JWT, String> {
	
	public void deleteAllByUsername(String username);
	
	public List<JWT> findAllByUsername(String username);
	
	public JWT findByUsernameAndJwt(String username, String jwt);
	
	@Query("SELECT new com.freightcom.clickship.data.rep.JWTRepository$UserJWTDTO(u, (CASE WHEN t.jwt IS NOT NULL THEN true ELSE false END)) FROM User u LEFT OUTER JOIN JWT t ON u.username = t.username AND t.jwt = :jwt WHERE u.username = :username")
	public UserJWTDTO findUserAndJWTByUsernameAndJwt(String username, String jwt);
	
	public class UserJWTDTO {
		
		private User user;
		
		private boolean exists;
		
		public UserJWTDTO() {
			super();
		}
				
		public UserJWTDTO(User user, boolean exists) {
			super();
			this.user = user;
			this.exists = exists;
		}

		public User getUser() {
			return user;
		}
		
		public void setUser(User user) {
			this.user = user;
		}
		
		public boolean isExists() {
			return exists;
		}
		
		public void setExists(boolean exists) {
			this.exists = exists;
		}
	}
}
