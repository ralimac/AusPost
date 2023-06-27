package au.com.ncs;



import static org.hamcrest.Matcher.*;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;


public class AusPostAPITest {

    private static String url = "https://digitalapi.auspost.com.au/postcode/search.json";

    @Test
    public void AusPostSearch(){
        given().header("auth-key", "c32d0ed5-8b52-477d-8beb-f5dcd7f5555b")
                .and().param("q", "Sydney").
        when().get(url).then().assertThat().statusCode(200);
    }

    @Test
    public void AusPostSearchPostcode(){
        given().header("auth-key", "c32d0ed5-8b52-477d-8beb-f5dcd7f5555b")
                .and().param("q", "Sydney").
                when().get(url).then().assertThat().body("localities.locality[0].postcode", equalTo(2055));
    }

}
