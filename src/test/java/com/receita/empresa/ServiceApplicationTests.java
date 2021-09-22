package com.receita.empresa;

import com.receita.empresa.client.ReceitaClient;
import com.receita.empresa.services.ReceitaClientService;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.StaticServerList;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ServiceApplicationTests.FeignConfig.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ServiceApplicationTests {

	@Autowired
	ReceitaClient receitaClient;

	private static final String CNPJ = "60409075000152";


	@Test
	public void testFeign() {
		assertThat(this.receitaClient.getEmpresa(CNPJ)).isNotNull();
	}

	@EnableFeignClients(clients = ReceitaClient.class)
	@RestController
	@Configuration
	@EnableAutoConfiguration
	@RibbonClient(name = "test", configuration = ServiceApplicationTests.RibbonConfig.class)
	static class FeignConfig {

		@RequestMapping(value = "teste")
		public String testFeign() {
			return "sucesso";
		}

	}

	@Configuration
	static class RibbonConfig {

		@LocalServerPort
		int port;

		@Bean
		public ServerList<Server> serverList() {
			return new StaticServerList<>(new Server("127.0.0.1", port), new Server("127.0.0.1", port));
		}
	}



}
