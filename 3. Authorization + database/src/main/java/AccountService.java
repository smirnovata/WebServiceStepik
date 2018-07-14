import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class AccountService {
    private final Map<String, UserProfile> sessionIdToProfile;
    private DBService dbService;

    public AccountService(DBService dbService) {
        sessionIdToProfile = new HashMap<>();
        this.dbService = dbService;
    }

    public void addNewUser(UserProfile userProfile) throws DBException {
        dbService.addUser(userProfile.getLogin(), userProfile.getPassword());
    }

    public UserProfile getUserByID(BigInteger id) throws DBException {
        UsersDataSet user = dbService.getUserById(id);
        return new UserProfile(user.getLogin(), user.getPassword());
    }

    public UserProfile getUserByLogin(String login) throws DBException {
        UsersDataSet user = dbService.getUserByLogin(login);
        return new UserProfile(user.getLogin(), user.getPassword());
    }



    public UserProfile getUserBySessionId(String sessionId) {
        return sessionIdToProfile.get(sessionId);
    }

    public void addSession(String sessionId, UserProfile userProfile) {
        sessionIdToProfile.put(sessionId, userProfile);
    }
}
