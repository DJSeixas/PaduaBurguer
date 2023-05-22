package com.paduaburguer.data.dto.security;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class TokenDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private String username;
	private Boolean password;
	private Date created;
	private Date expiration;
	private String accessToken;
	private String refreshToken;
	
	public TokenDTO() {
	}



	public TokenDTO(
			String username, 
			Boolean password,
			Date created, 
			Date expiration, 
			String accessToken,
			String refreshToken) {
		this.username = username;
		this.password = password;
		this.created = created;
		this.expiration = expiration;
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public Boolean getPassword() {
		return password;
	}



	public void setPassword(Boolean password) {
		this.password = password;
	}



	public Date getCreated() {
		return created;
	}



	public void setCreated(Date created) {
		this.created = created;
	}



	public Date getExpiration() {
		return expiration;
	}



	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}



	public String getAccessToken() {
		return accessToken;
	}



	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}



	public String getRefreshToken() {
		return refreshToken;
	}



	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}



	@Override
	public int hashCode() {
		return Objects.hash(accessToken, created, expiration, password, refreshToken, username);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TokenDTO other = (TokenDTO) obj;
		return Objects.equals(accessToken, other.accessToken) && Objects.equals(created, other.created)
				&& Objects.equals(expiration, other.expiration) && Objects.equals(password, other.password)
				&& Objects.equals(refreshToken, other.refreshToken) && Objects.equals(username, other.username);
	}
	
	
	
}
