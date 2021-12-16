package theaterProjectCode;

import java.util.HashMap;
import java.util.Map;

public class Model {
    private Map<String,Showtime> showtimes;
    private Map<String,Theater> theaters;
    private Map<String,Account> accounts;

    private Account loggedIn;

    public Model(){
        //initalize model lists
        this.showtimes = new HashMap<String,Showtime>();
        this.theaters = new HashMap<String,Theater>();
        this.accounts = new HashMap<String,Account>();
        //TODO import data from databases
        //create guest account if it isn't made yet
        createGuest();
        //set logged in to guest at init
        loggedIn = accounts.get("Guest");
    }

    //return string which lists items in system
    public String stringMap(Map<String,Object> inputMap){
        StringBuilder sout = new StringBuilder();
        if(inputMap.isEmpty()){
            sout.append("There are no ").append(inputMap.getClass()).append(" in the system!");
        }else{
            for(String id : inputMap.keySet()){
                sout.append(id + ", ");
            }
            //remove trailing comma and space
            sout.substring(0, sout.length() - 2);
        }
        return sout.toString();
    }
    //attempt to login account, return true on success false otherwise
    public boolean attemptLogin(String username, String password){
        if(accounts.containsKey(username) && accounts.get(username).getPassword().equals(password)){
                loggedIn = accounts.get(username);
                return true;
        }
        return false;
    }
    //logout whatever account is logged in and login as guest
    public void logout(){
        createGuest();
        loggedIn = accounts.get("Guest");
    }
    //creates guest account if there isn't one already
    public void createGuest(){
        if(!accounts.containsKey("Guest")){
            accounts.put("Guest", new Account("Guest", "Guest", "Guest"));
        }
    }
    //create an account
    public void createAccount(){
        
    }
}
