package com.bta.myloto;

import com.bta.myloto.dao.UserAccountRepository;
import com.bta.myloto.domain.UserAccount;
import com.bta.myloto.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Ctrl+Q na nej processor, kotor6j soderzhit podprocess6
public class MyLotoApplication implements CommandLineRunner {

    @Autowired // avtomoticeski svjas6vaet i dostanet iz konteksta
    private UserAccountRepository userAccountRepository;

    @Autowired
	private UserAccountService userAccountService;

    public static void main(String[] args) {

        SpringApplication.run(MyLotoApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		UserAccount user1 = new UserAccount();
		user1.setUserName("artjom.gg@gmail.com");
		user1.setUserPassword("artjomgg");
		user1.setFirstName("Artjom");
		user1.setLastName("Guguljan");
		user1.setIsikuKood(38205050248l);
		user1.setEmail("artjom.gg@gmail.com");

		//userAccountRepository.saveOrUpdate(user1);

		boolean loginChek1 = userAccountService.login("adggadj", "hhuhuhu");
		System.out.println(loginChek1);
		boolean artjomgg = userAccountService.login("artjom.gg@gmail.com", "artjomgg");
		System.out.println(artjomgg);

	}
}
