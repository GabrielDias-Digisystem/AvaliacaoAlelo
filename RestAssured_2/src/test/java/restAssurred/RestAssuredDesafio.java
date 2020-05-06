package restAssurred;

import static io.restassured.RestAssured.get;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

public class RestAssuredDesafio {

	// URL
	String url = "https://jsonplaceholder.typicode.com/todos/1";

	// Faz a validação se o campo title está igual a "delectus aut autem" e do statuscode igual a 200
	@Test
	public void getTitle() {
		get(url).then().body("title", equalTo("delectus aut autem")).assertThat().statusCode(equalTo(200));

	}

	// Faz a validação se o campo completed está igual a "false" e do statuscode igual a 200
	@Test
	public void getCompleted() {
		get(url).then().body("completed", equalTo(false)).assertThat().statusCode(equalTo(200));
	}

}
