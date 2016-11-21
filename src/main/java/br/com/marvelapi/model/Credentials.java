package br.com.marvelapi.model;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.marvelapi.commons.MD5Utils;

public class Credentials implements UserDetails {

	private static final long serialVersionUID = -3233167483394894636L;

	private String privateKey;
	private String publicKey;
	private final Long timeStamp;

	public Credentials() {
		this.timeStamp = System.currentTimeMillis();
	}

	public Credentials(String privateKey, String publicKey) {
		this.privateKey = privateKey;
		this.publicKey = publicKey;
		this.timeStamp = System.currentTimeMillis();
	}

	public String getHash() {
		return MD5Utils.getHash(getTimeStamp(), getPrivateKey(), getPublicKey());
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public static void main(String[] args) {
		Credentials c = new Credentials("754881b044ad415ca5810d4fecaab8e00dd76a4a", "f470b7072bed787ccde5352beaa3f411");
		System.out.println(c.getHash());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<GrantedAuthority>();
	}

	@Override
	public String getPassword() {
		return privateKey;
	}

	@Override
	public String getUsername() {
		return publicKey;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
