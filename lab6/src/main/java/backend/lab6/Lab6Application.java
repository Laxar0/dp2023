package backend.lab6;

import backend.lab6.entities.EEntity;
import backend.lab6.repositories.RRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab6Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Lab6Application.class, args);
	}

	@Autowired
	private RRepository cRepo;

	@Override
	public void run(String... args) throws Exception {
		EEntity entity = new EEntity();
		entity.setName("TERRIER LT-79");
		entity.setImg("assets/Terrier-LT-79.jpg");
		entity.setPrice(1000);
		cRepo.save(entity);

		EEntity entity1 = new EEntity();
		entity1.setName("HUSKY TSV");
		entity1.setImg("assets/HUSKY-TSV.jpg");
		entity1.setPrice(1200);
		cRepo.save(entity1);

		EEntity entity2 = new EEntity();
		entity2.setName("BATT UMG");
		entity2.setImg("assets/BATT-UMG.jfif");
		entity2.setPrice(900);
		cRepo.save(entity2);
	}
}
