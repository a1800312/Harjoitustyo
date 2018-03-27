package fi.hh.palvelinohjelmointi.Harjoitustyo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.User;
import fi.hh.palvelinohjelmointi.Harjoitustyo.domain.UserRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
	private final UserRepository urepository;
	
	@Autowired
	public UserDetailServiceImpl(UserRepository userrepository) {
		this.urepository = userrepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User curruser = urepository.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, 
				curruser.getPassword(),
				AuthorityUtils.createAuthorityList(curruser.getRole()));
		return user;
	}

}
