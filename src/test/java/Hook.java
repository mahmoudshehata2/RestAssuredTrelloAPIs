public class Hook {
    public static String baseUrl = "https://api.trello.com";
    public static String key = "39e6bf3918a848b6e2a188d8af1963e1";
    public static String token = "ATTA6a549665a9ee30d53087123e48b629f7d970d600f9192f3c5baed9f1d7b1a56b2EADDEE9";
    public static String orgID;
    public static String memberID;

    public static String boardID;
    public static String getBoardID;
    public static String createList;

    public static String Get_List ;

    public static String archiveList;
    public static String deleteBoards;

    public static String deleteOrg;
    public static void main(String[] args) {

        MemberRequest member = new MemberRequest();
        memberID = member.getMemberRequest();
        System.out.println("Member ID"+memberID);


       OrganizationRequests org = new OrganizationRequests();
       orgID = org.createOrganization();
        System.out.println("Org ID"+orgID);



        OrganizationRequests getORG = new OrganizationRequests();
         orgID  =getORG.getOrganization();
        System.out.println(orgID);


        BoardRequests  CreateB = new BoardRequests();
        boardID = CreateB.createBoard();
        System.out.println("Board ID :" + boardID);


      BoardRequests getB = new BoardRequests();
      getBoardID = getB.getBoard();
        System.out.println("GET Boards ID :" + getBoardID);


        ListsRequests create_List = new ListsRequests();
        createList = create_List.createList();
        System.out.println("GET List ID :" + createList);


        ListsRequests get_List = new ListsRequests();
        Get_List = get_List.getLists();
        System.out.println("GET Lists from Response Body: " + Get_List);


        ListsRequests ArchiveList = new ListsRequests();
        archiveList = ArchiveList.Archive_List();
        System.out.println("ArchiveList: " + archiveList);


        BoardRequests dBoard = new BoardRequests();
        deleteBoards = dBoard.deleteBoard();
        System.out.println("Board is deleted Successfully");


        OrganizationRequests delOrg = new OrganizationRequests();
        deleteOrg = delOrg.deleteOrganization();
        System.out.println("Organization is deleted successfully: "+ deleteOrg);
    }
}
