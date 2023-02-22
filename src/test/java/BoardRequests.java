import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import org.testng.Assert;

public class BoardRequests {

    public String createBoard() {

        RestAssured.baseURI = Hook.baseUrl;
        RestAssured.basePath = "/1/boards";

        RequestSpecification addBoard = RestAssured.given();

        addBoard.queryParam("key", Hook.key)
                .queryParam("token", Hook.token)
                .header("Content-Type","application/json")
                .body("{\"name\": \"Trello APIs Testing\", \"desc\" : \"create new board in trello\"} ");

        Response response = addBoard.post();

        JsonPath cBoard = response.jsonPath();
        String createBoard = cBoard.getString("id");
        return createBoard;

    }

    public String getBoard() {
        RestAssured.baseURI = Hook.baseUrl;
        RestAssured.basePath ="/1/members/me/boards";

        RequestSpecification getBoards = RestAssured.given();

        getBoards.queryParam("key", Hook.key)
                .queryParam("token", Hook.token);

        Response response = getBoards.get();

        JsonPath gBoards = response.jsonPath();
        String getBoard = gBoards.getString("id");
        return getBoard;

    }

    public String deleteBoard() {

        RestAssured.baseURI = Hook.baseUrl;
        RestAssured.basePath ="/1/boards"+ Hook.boardID;

        RequestSpecification deleteBoard = RestAssured.given();
        deleteBoard.queryParam("key", Hook.key)
                .queryParam("token", Hook.token);

       Response response = deleteBoard.delete();

        int AcualR = response.getStatusCode();

        String jsonString = response.asString();

        return   jsonString;
    }




}
