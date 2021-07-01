package geo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Starter {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Starter.class);
        CountryRepository repository = context.getBean(CountryRepository.class);
        RegionRepository regionRepository = context.getBean(RegionRepository.class);
        CityRepository cityRepository = context.getBean(CityRepository.class);

        CountryEntity country1 = new CountryEntity();
        country1.setName("Россия");
        repository.save(country1);

        RegionEntity region1 = new RegionEntity();
        region1.setName("Вологодская область");
        region1.setCountry(country1);
        regionRepository.save(region1);

        CityEntity city1 = new CityEntity();
        city1.setName("Вологда");
        city1.setRegion(region1);
        cityRepository.save(city1);

        CityEntity city2 = new CityEntity();
        city2.setName("Великий Устюг");
        city2.setRegion(region1);
        cityRepository.save(city2);

        CountryEntity country2 = new CountryEntity();
        country2.setName("Япония");
        repository.save(country2);

        RegionEntity region2 = new RegionEntity();
        region2.setName("Канто");
        region2.setCountry(country2);
        regionRepository.save(region2);

        RegionEntity region3 = new RegionEntity();
        region3.setName("Хоккайдо");
        region3.setCountry(country2);
        regionRepository.save(region3);

        CityEntity city3 = new CityEntity();
        city3.setName("Токио");
        city3.setRegion(region2);
        cityRepository.save(city3);

        List<CountryEntity> countries = (List<CountryEntity>) repository.findAll();
        for (CountryEntity country : countries) {
            System.out.println(country.getName());
            Set<RegionEntity> regions = country.getRegion();
            for (RegionEntity region : regions) {
                System.out.println("\t" + region.getName());
                Set<CityEntity> cities = region.getCity();
                for (CityEntity city : cities) {
                    System.out.println("\t\t" + city.getName());
                }
            }
        }

        context.close();
    }
}