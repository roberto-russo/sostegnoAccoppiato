package it.csi.demetra.demetraws.zoo.services;

//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import it.csi.demetra.demetraws.zoo.model.Dmt_t_User;
//
//@Service
//public class UserService implements UserDetailsService{
//	
//	
//	@Autowired
//	UserRepository userRepository;
//	
//	private List<it.bcsoft.zoo.model.User> allUsers;
//	private it.csi.demetra.demetraws.zoo.model.Dmt_t_User user;
//
//	
//	
//	@Override
//	@SuppressWarnings("unchecked")
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		user = userRepository.findByUsername(username);
//		//solo per prova
//		
//		//return new User(user.getUsername(),user.getPassword(),(Collection<? extends GrantedAuthority>) user.getAuthorities());
//		return new User(user.getUsername(),user.getPassword(),(Collection<? extends GrantedAuthority>)(Collection<? extends Dmt_t_Authority>) user.getAuthorities());
//	}
//
//}
