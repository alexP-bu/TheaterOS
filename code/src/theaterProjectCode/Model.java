package theaterProjectCode;

import java.util.HashMap;
import java.util.Map;

import theaterProjectCode.Showtime.ShowtimeBuilder;

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
    public String listItems(Map<String,Object> inputMap){
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
    public boolean attemptLogin(String username, String password){
        if(accounts.containsKey(username) && accounts.get(username).getPassword().equals(password) 
        && loggedIn.getType().equals("Guest")){
                loggedIn = accounts.get(username);
                return true;
        }
        return false;
    }
    public void logout(){
        createGuest();
        loggedIn = accounts.get("Guest");
    }
    //creates guest account if there isn't one already
    //guest account is for internal use
    public void createGuest(){
        if(!accounts.containsKey("Guest")){
            accounts.put("Guest", new Account.AccountBuilder().type("Guest").build());
        }
    }
    public boolean createCustomer(String username, String password){
        if(!accounts.containsKey(username)){
            accounts.put(username, new Account.AccountBuilder(username,password).type("Customer").build());
            return true;
        }
        return false;
    }
    public boolean createEmployee(String username, String password){
        if(!accounts.containsKey(username)){
            accounts.put(username, new Account.AccountBuilder(username,password).type("Employee").build());
            return true;
        }
        return false;
    }
    public boolean createAdmin(String username, String password){
        if(!accounts.containsKey(username)){
            accounts.put(username, new Account.AccountBuilder(username,password).type("Administrator").build());
            return true;
        }
        return false;
    }
    //account can only be deleted if the current user is logged in or is an administrator
    public boolean deleteAccount(String username){
        if(loggedIn.getUsername().equals(username) || loggedIn.getType().equals("Administrator") 
            && accounts.containsKey(username)){
                accounts.remove(username);
                return true;
        }
        return false;
    }
    //theater functions
    public boolean createTheater(String id, int rows, int cols){
        if(!theaters.containsKey(id)){
            theaters.put(id, new Theater(id, rows, cols));
            return true;
        }
        return false;
    }
    public boolean deleteTheater(String id){
        if(theaters.containsKey(id)){
            theaters.remove(id);
            return true;
        }
        return false;
    }
    public boolean reserveSeat(Theater theater, int row, int col){
        if(theaters.containsKey(theater.getTheaterID()) 
        && theaters.get(theater.getTheaterID()).hasEmptySeats()){
            theaters.get(theater.getTheaterID()).reserve(row, col);
            return true;
        }
        return false;
    }
    //showtime functions
    public boolean createShowtime(String id){
        if(!showtimes.containsKey(id)){
            Showtime newShowtime = new ShowtimeBuilder(id).build();
            showtimes.put(newShowtime.getID(), newShowtime);
            return true;
        }
        return false;
    }
    public boolean deleteShowtime(String id){
        if(showtimes.containsKey(id)){
            showtimes.remove(id);
            return true;
        }
        return false;
    }
}
