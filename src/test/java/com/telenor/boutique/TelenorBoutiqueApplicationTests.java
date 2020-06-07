package com.telenor.boutique;

import com.telenor.boutique.dto.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

	@Autowired
	TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	public void servicePingTest() {
		String pingUrl = "http://localhost:" + port + "/api/v1/ping";
		assertThat(this.restTemplate.getForObject(pingUrl,
				String.class)).isEqualTo("Service is up!");
	}

	@Test
	public void getProductsTestPass() {
		String pingUrl = "http://localhost:" + port + "/api/v1/products";
		assertThat(this.restTemplate.getForObject(pingUrl, String.class))
				.isNotBlank();
	}

	@Test
	public void getProductsByCityPass() {
		String pingUrl = "http://localhost:" + port + "/api/v1/product?city=Stockholm";
		assertThat(this.restTemplate.getForObject(pingUrl, Data.class).getData().size())
				.isEqualTo(40);
	}

	@Test
	public void getProductsByMinPricePass() {
		String pingUrl = "http://localhost:" + port + "/api/v1/product?min_price=900";
		assertThat(this.restTemplate.getForObject(pingUrl, Data.class).getData().size())
				.isEqualTo(10);
	}

	@Test
	public void getProductsByMaxPricePass() {
		String pingUrl = "http://localhost:" + port + "/api/v1/product?max_price=100";
		assertThat(this.restTemplate.getForObject(pingUrl, Data.class).getData().size())
				.isEqualTo(14);
	}

	@Test
	public void getPhonesTestPass() {
		String pingUrl = "http://localhost:" + port + "/api/v1/product?type=phone";
		assertThat(this.restTemplate.getForObject(pingUrl, Data.class).getData().size())
				.isGreaterThan(0);
	}

	@Test
	public void getPhonesWithColorFilterTestPass() {
		String pingUrl = "http://localhost:" + port + "/api/v1/product?type=phone&property.color=lila";
		assertThat(this.restTemplate.getForObject(pingUrl, Data.class).getData().size())
				.isEqualTo(1);
	}

	@Test
	public void getPhonesWithColorFilterTestFail() {
		String pingUrl = "http://localhost:" + port + "/api/v1/product?type=phone&property.color=cerullian";
		assertThat(this.restTemplate.getForObject(pingUrl, Data.class).getData().size())
				.isEqualTo(0);
	}

	@Test
	public void getSubscriptionsTestPass() {
		String pingUrl = "http://localhost:" + port + "/api/v1/product?type=subscription";
		assertThat(this.restTemplate.getForObject(pingUrl, Data.class).getData().size())
				.isGreaterThan(0);
	}

	@Test
	public void getSubscriptionsWithMaxLimitFilterPass() {
		String pingUrl = "http://localhost:" + port + "/api/v1/product?type=subscription&property.gb_limit_max=10";
		assertThat(this.restTemplate.getForObject(pingUrl, Data.class).getData().size())
				.isEqualTo(24);
	}

	@Test
	public void getSubscriptionsWithLimitFilterPass() {
		String pingUrl = "http://localhost:" + port + "/api/v1/product?type=subscription&property.gb_limit_min=50";
		assertThat(this.restTemplate.getForObject(pingUrl, Data.class).getData().size())
				.isEqualTo(34);
	}

	@Test
	public void getProductTestFail() {
		String pingUrl = "http://localhost:" + port + "/api/v1/product?type=random_text";
		assertThat(this.restTemplate.getForObject(pingUrl, Data.class).getData().size())
				.isEqualTo(0);
	}

}
