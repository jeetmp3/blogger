package me.blogger.init;

import me.blogger.domains.User;
import me.blogger.repositories.UserRepository;
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
	}

	private void createAdminUser() {
		User user = userRepository.findByEmailAndActive("jeet.mp3@gmail.com", true);
		if(ObjectUtils.isEmpty(user)) {
			user = new User().setName("Jitendra Bisht").setEmail("jeet.mp3@gmail.com")
					.setPassword("admin").setRole("ADMIN").setActive(true)
					.setProfilePicture("https://scontent.fdel1-1.fna.fbcdn.net/t31.0-1/c1220.265.480.480/s160x160/13403268_1161454917250853_3605285300566556179_o.jpg")
			.setAbout("Sr. Software Engineer, Open source committer, Blogger");
			userRepository.save(user);
		}
	}
}
