package com.myblogspro.init;

import com.myblogspro.domains.User;
import com.myblogspro.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * @author Jitendra Singh.
 */
@Component
public class Bootstrap {

	@Autowired
	UserRepository userRepository;

	@EventListener({ContextStartedEvent.class, ContextRefreshedEvent.class})
	public void init(ApplicationEvent event) {
		createAdminUser();
		createKhargosh();
	}

	private void createAdminUser() {
		User user = userRepository.findByUsernameOrEmailAndActive("jeetmp3", "jeet.mp3@gmail.com", true);
		if(ObjectUtils.isEmpty(user)) {
			user = new User().setName("Jitendra Bisht").setUsername("jeetmp3").setEmail("jeet.mp3@gmail.com")
					.setPassword("admin").setRole("ADMIN").setActive(true)
			.setAbout("Sr. Software Engineer, Open source committer, Blogger");
			userRepository.save(user);
		}
	}

	private void createKhargosh() {
		User user = userRepository.findByUsernameOrEmailAndActive("simmi", "simranjit.kour@gmail.com", true);
		if(ObjectUtils.isEmpty(user)) {
			user = new User().setName("Simranjit Kour").setUsername("simmi").setEmail("simranjit.kour@gmail.com")
					.setPassword("admin").setRole("ADMIN").setActive(true)
					.setAbout("Sr. Software Engineer, Open source committer, Blogger");
			userRepository.save(user);
		}
	}
}
