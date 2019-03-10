package com.example.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
		/*RmiClient rmiClient = new RmiClient();
		RmiOrder order = new RmiOrder("Lucy", "", "", 1, 20, 20);
		try
        {
            rmiClient.runShipOrder(order);
        }
        catch (Exception e)
        {

        }*/
	}



}

