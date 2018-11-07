package spittr.data;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spittr.Spitter;

@Service
public class SpitterUserServcie implements UserDetailsService {

	@Autowired
	private SpitterRepository spitterRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Spitter spitter = spitterRepository.findByUsername(username);
		if(spitter != null) {
			List<GrantedAuthority> authorities = new ArrayList<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_SPITTER"));
			return new User(spitter.getUsername(), spitter.getPassword(), authorities);
		}
		
		throw new UsernameNotFoundException("user '" + username + "' not found. ");
	}

}
