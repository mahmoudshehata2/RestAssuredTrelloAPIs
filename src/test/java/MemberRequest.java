import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MemberRequest {

    public String getMemberRequest() {

        RestAssured.baseURI = Hook.baseUrl;
        RestAssured.basePath = "/1/members/me";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.queryParam("key", Hook.key);
        request.queryParam("token", Hook.token);
        Response response = request.get();
        //  response.prettyPrint();
        JsonPath pathOrg = response.jsonPath();
        String memberID = pathOrg.getString("id");
        return memberID;
    }

}
