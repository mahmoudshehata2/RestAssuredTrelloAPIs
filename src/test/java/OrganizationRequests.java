import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OrganizationRequests {

    public String createOrganization() {

        RestAssured.baseURI = Hook.baseUrl;
        RestAssured.basePath = " /1/organizations";
       RequestSpecification reqOrg = RestAssured.given();
       reqOrg.queryParam("displayName", "MS Trello RestAssured APIs")
               .queryParam("key", Hook.key)
               .queryParam("token", Hook.token)
                .header("Content-Type", "application/json");
        Response responseORG = reqOrg.post();
        responseORG.prettyPrint();

       JsonPath pathOrg = responseORG.jsonPath();
        Hook.orgID = pathOrg.getString("id");
        System.out.println(pathOrg.getString("id"));
        return Hook.orgID;

    }

    public String getOrganization() {

        RestAssured.baseURI = Hook.baseUrl;
        RestAssured.basePath = "/1/organizations/" + Hook.orgID ;

        RequestSpecification getOrg = RestAssured.given();
        getOrg.queryParam("key", Hook.key)
                .queryParam("token", Hook.token);

        Response responseORG = getOrg.get();
        responseORG.prettyPrint();

        JsonPath respOrg = responseORG.jsonPath();
           Hook.orgID = respOrg.getString("id");
        return Hook.orgID;

    }
    public String deleteOrganization() {
        RestAssured.baseURI = Hook.baseUrl;
        RestAssured.basePath ="/1/organizations/"+ Hook.orgID;

        RequestSpecification deleteOrganizationRequest = RestAssured.given();
        deleteOrganizationRequest.queryParam("key", Hook.key)
                .queryParam("token", Hook.token);

        Response deleteOrgResponse = deleteOrganizationRequest.delete();

        int org = deleteOrgResponse.getStatusCode();

        String delORG = deleteOrgResponse.asString();
        return delORG;

    }

}
