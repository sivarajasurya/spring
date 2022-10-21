package com.gcit.siva.spring;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "spring.datasource.url=jdbc:tc:postgresql:13///")
class ApplicationTests {

	@Autowired
	WebTestClient webTestClient;


	@Test
	void addBookToCatalog(){
		var bookToCreate = new BookServiceApplication.Book(null,"The Hobbit");


		webTestClient
				.post()
				.uri("/books")
				.bodyValue(bookToCreate)
				.exchange()
				.expectStatus().is2xxSuccessful()
				.expectBody(BookServiceApplication.Book.class).value(actualBook ->{
					MatcherAssert.assertThat(actualBook.id(), null);
					MatcherAssert.assertThat(actualBook.title(), equals(actualBook.title()));

				});


	}

}
