package com.gcit.siva.spring;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "spring.datasource.url=jdbc:postgresql://localhost:5432/book_catalog")
@AutoConfigureWebTestClient
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
					Assertions.assertNotNull(actualBook.id());
					Assertions.assertEquals(actualBook.title(), actualBook.title());
				});
	}

}
