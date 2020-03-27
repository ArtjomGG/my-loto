package com.bta.myloto;

import com.bta.myloto.dao.UserAccountRepository;
import com.bta.myloto.domain.LotoTicket;
import com.bta.myloto.domain.MyLotoResult;
import com.bta.myloto.service.MyLotoResultService;
import com.bta.myloto.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication // Ctrl+Q na nej processor, kotor6j soderzhit podprocess6
public class MyLotoApplication implements CommandLineRunner {

    @Autowired // avtomoticeski svjas6vaet i dostanet iz konteksta
    private UserAccountRepository userAccountRepository;

    @Autowired
	private UserAccountService userAccountService;

    @Autowired
    private MyLotoResultService myLotoResultService;

    public static void main(String[] args) {
        SpringApplication.run(MyLotoApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {

		/*UserAccount user1 = new UserAccount();
		user1.setUserName("artjom.gg@gmail.com");
		user1.setUserPassword("artjomgg");
		user1.setFirstName("Artjom");
		user1.setLastName("Guguljan");
		user1.setIsikuKood(38205050248l);
		user1.setEmail("artjom.gg@gmail.com");*/

		//userAccountRepository.saveOrUpdate(user1);

        System.out.println("*******************************");
		boolean loginChek1 = userAccountService.login("adggadj", "hhuhuhu");
		System.out.println(loginChek1);
		boolean artjomgg = userAccountService.login("artjom.gg@gmail.com", "artjomgg");
		System.out.println(artjomgg);
        boolean loginChek3 = userAccountService.login("adggadj", "hhuhuhu");
        System.out.println(loginChek1);
        System.out.println("*******************************");


        LotoTicket lotoTicket = new LotoTicket(null, 1L, 1L, 45, 25, 35, 15,1, 21);
        userAccountService.registrationTicket(lotoTicket);

        Set<Integer> myBets = new HashSet<>();
        myBets.add(lotoTicket.getMyTicketNum1());
        myBets.add(lotoTicket.getMyTicketNum2());
        myBets.add(lotoTicket.getMyTicketNum3());
        myBets.add(lotoTicket.getMyTicketNum4());
        myBets.add(lotoTicket.getMyTicketNum5());
        myBets.add(lotoTicket.getMyTicketNum6());

        // Sosdaem SET dlja bileta PlixPlaks
        Set<Integer> myBetsPlixPlax = new HashSet<>();
        myBetsPlixPlax.add((int)(Math.random()*49+1));
        myBetsPlixPlax.add((int)(Math.random()*49+1));
        myBetsPlixPlax.add((int)(Math.random()*49+1));
        myBetsPlixPlax.add((int)(Math.random()*49+1));
        myBetsPlixPlax.add((int)(Math.random()*49+1));
        myBetsPlixPlax.add((int)(Math.random()*49+1));

        MyLotoResult results = myLotoResultService.getResults();
        //Integer win = myLotoResultService.evaluateWin(results, myBets);

        //Integer win = myLotoResultService.evaluateWin(results, myBets);
        System.out.println("*******************************");

    }
}
