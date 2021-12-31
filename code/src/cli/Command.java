package cli;

public interface Command {
    void execute(Model model, String[] params);
}

class newCustomer implements Command{
    public void execute(Model model, String[] params){
        if(model.createCustomer(params[0], params[1])){
            System.out.println("Sucessfully created account!");
        }else{
            System.out.println("Error creating account.");
        }
    }
}

class newEmployee implements Command{
    public void execute(Model model, String[] params){
        if(model.createCustomer(params[0], params[1])){
            System.out.println("Sucessfully created account!");
        }else{
            System.out.println("Error creating account.");
        }
    }
}

class newAdmin implements Command{
    public void execute(Model model, String[] params){
        if(model.createAdmin(params[0], params[1])){
            System.out.println("Sucessfully created account!");
        }else{
            System.out.println("Error creating account.");
        }
    }
}

class newTheater implements Command{
    public void execute(Model model, String[] params){
        if(model.createTheater(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2]))){
            System.out.println("Sucessfully created theater!");
        }else{
            System.out.println("Error creating theater.");
        }
    }
}

class newShowtime implements Command{
    public void execute(Model model, String[] params){
        if(model.createShowtime(params[0])){
            System.out.println("Sucessfully created showtime!");
        }else{
            System.out.println("Error creating showtime.");
        }
    }
}

class deleteAccount implements Command{
    public void execute(Model model, String[] params){
        if(model.deleteAccount(params[0])){
            System.out.println("Sucessfully deleted account!");
        }else{
            System.out.println("Error deleting account. Insufficient permissions.");
        }
    }
}

class deleteTheater implements Command{
    public void execute(Model model, String[] params){
        if(model.deleteTheater(params[0])){
            System.out.println("Sucessfully deleted theater!");
        }else{
            System.out.println("Error deleting theater.");
        }
    }
}

class deleteShowtime implements Command{
    public void execute(Model model, String[] params){
        if(model.deleteShowtime(params[0])){
            System.out.println("Successfully deleted showtime!");
        }else{
            System.out.println("Error deleting showtime!");
        }
    }
}

class listAccounts implements Command{
    public void execute(Model model, String[] params){
        System.out.println("Printing list of accounts in system: ");
        for(String key : model.getAccounts().keySet()){
            System.out.println(key);
        }
        System.out.println("Done printing.");
    }
}

class listTheaters implements Command{
    public void execute(Model model, String[] params){
        System.out.println("Printing list of theaters in system: ");
        for(String key : model.getTheaters().keySet()){
            System.out.println(key);
        }
        System.out.println("Done printing.");
    }
}

class listShowtimes implements Command{
    public void execute(Model model, String[] params){
        System.out.println("Printing list of showtimes in system: ");
        for(String key : model.getShowtimes().keySet()){
            System.out.println(key);
        }
        System.out.println("Done printing.");
    }
}

class viewAccount implements Command{
    public void execute(Model model, String[] params){
        System.out.println("Retrieving account data...");
        if(!model.getloggedIn().getUsername().equals("Guest")){
            System.out.println(model.getloggedIn().toString());
        }else{
            System.out.println("No account currently logged in!");
        }
    }
}

class viewTheater implements Command{
    public void execute(Model model, String[] params){
        if(model.getTheaters().containsKey(params[0])){
            System.out.println("Retrieving theater data...");
            System.out.println(model.getTheaters().get(params[0]).toString());
        }else{
            System.out.println("Invalid theater ID! Please try again.");
        }
    }
}

class viewShowtime implements Command{
    public void execute(Model model, String[] params){
        if(model.getShowtimes().containsKey(params[0])){
            System.out.println("Retreiving showtime data...");
            System.out.println(model.getShowtimes().get(params[0]).toString());
        }else{
            System.out.println("Invalid showtime ID! Please try again.");
        }
    }
}

class purchaseTicket implements Command{
    public void execute(Model model, String[] params){
        //TODO
    }
}

class addBalance implements Command {
    public void execute(Model model, String[] params){
        //TODO
    }
}

class clearAccountData implements Command{
    public void execute(Model model, String[] params){
        //TODO
    }
}

class clearTheaterData implements Command{
    public void execute(Model model, String[] params){
        //TODO
    }
}

class clearShowtimeData implements Command{
    public void execute(Model model, String[] params){
        //TODO
    }
}
class updateAccountData implements Command{
    public void execute(Model model, String[] params){
        //TODO
    }
}
class updateShowtimeData implements Command{
    public void execute(Model model, String[] params){
        //TODO
    }
}

class updateTheaterData implements Command{
    public void execute(Model model, String[] params){
        //TODO
    }
}

class login implements Command{
    public void execute(Model model, String[] params){
        //TODO
    }
}

class logout implements Command{
    public void execute(Model model, String[] params){
        //TODO
    }
}

class exit implements Command{
    public void execute(Model model, String[] params){
        //TODO
    }
}

class help implements Command{
    public void execute(Model model, String[] params){
        printHelp();
    }

    public static void printHelp() {
        System.out.println();
        System.out.println("Commands currently available:");
        String str = """
                         ________________________________________________________________
                        / newCustomer    / listAccounts   / clearAccountsData  / login  /
                       / newAdmin       / listTheaters   / clearTheatersData  / logout /
                      / newEmployee    / listShowtimes  / clearShowtimesData / exit   /
                     / newTheater     / viewAccount    / updateAccountsData / help   /
                    / newShowtime    / viewTheater    / updateTheatersData /        /
                   / deleteAccount  / viewShowtime   /updateShowtimesData /        /
                  / deleteTheater  / purchaseTicket /                    /        /
                 / deleteShowtime / addBalance     /                    /        /
                /________________/________________/____________________/________/          """;
        System.out.println(str);
    }
}


