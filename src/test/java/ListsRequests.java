import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class ListsRequests {


        public String createList() {


         //   RestAssured.basePath ="/1/boards"+ Hook.boardID +"/lists";
            //RestAssured.basePath ="/1/lists"+ Hook.boardID ;

            RestAssured.baseURI = Hook.baseUrl;
            RestAssured.basePath ="/1/lists";

            RequestSpecification addList = RestAssured.given();
            addList.queryParam("name","api trello api")
                    .queryParam("idBoard",Hook.boardID)
                    .queryParam("key", Hook.key)
                    .queryParam("token", Hook.token)
                    .header("Content-Type", "application/json");

            Response response = addList.post();

            JsonPath add_F_List = response.jsonPath();
            String createList  = add_F_List.getString("id");
            return createList;


    }

    public String getLists() {
        RestAssured.baseURI = Hook.baseUrl;
        RestAssured.basePath = "/1/boards/" + Hook.boardID + "/lists";

        RequestSpecification getListRequest = RestAssured.given();
        getListRequest.header("Content-Type", "application/json");

        getListRequest.queryParam("key", Hook.key)
                      .queryParam("token", Hook.token);

        Response response = getListRequest.get();
        JsonPath add_F_List = response.jsonPath();

        String getList  = add_F_List.getString("id");
        return getList;


    }

    public  String Archive_List(){
        RestAssured.baseURI = Hook.baseUrl;
        RestAssured.basePath = "/1/lists/"+Hook.createList +"/closed";

        RequestSpecification ArchiveListRequest = RestAssured.given();
        ArchiveListRequest.header("Content-Type", "application/json");

        ArchiveListRequest.queryParam("value", "true")
                     .queryParam("token", Hook.token)
                      .queryParam("key", Hook.key);

        Response response = ArchiveListRequest.put();
        JsonPath arcList = response.jsonPath();

        String ArchiveList  = arcList.getString("id");
        return ArchiveList;


    }

}
