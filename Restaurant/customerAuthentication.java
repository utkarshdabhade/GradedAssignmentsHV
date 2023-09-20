import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;



public class customerAuthentication {
    private static int custID; 
    public static String custName; 
    private static String userName; 
    private static String userPass; 
    public static char Membership;

    
    public  customerAuthentication (int cuID, String cuNm, String usrNm, String usrPwd, char mbr  ) {
        
        
        this.custID = cuID;
        this.custName = cuNm;
        this.userName = usrNm;
        this.userPass = usrPwd;
        this.Membership = mbr;

        

}

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public char getMembership() {
        return Membership;
    }

    public void setMembership(char membership) {
        Membership = membership;
    }
    

  
        public static void main(String[] args) {
            
        
            
                try {
                    String csvFile = "csvCustomer.csv";
                String line = "";
                String cvsSplitBy = ",";
                
                // Read the CSV file and get the last row
                BufferedReader br = new BufferedReader(new FileReader(csvFile));
                String lastLine = null;
                while ((line = br.readLine()) != null) {
                    lastLine = line;
                }
                br.close();
                
                // Parse the last row to get the last number
                String[] lastRow = lastLine.split(cvsSplitBy);
                int lastNumber = Integer.parseInt(lastRow[0]);
                
                // Increment the last number by 1
                int newNumber = lastNumber + 1;
                
                // Create a new row with the incremented number and the new menu item
                String custID = "Customer Login ID";
                String newRow = newNumber + "," + custID + "," + custName + "," + userName + "," + userPass + "," + Membership;
                
                // Append the new row to the CSV file
                FileWriter writer = new FileWriter(csvFile, true);
                writer.append("\n"); // add a new line before appending the new row
                writer.append(newRow);
                writer.close();
                    
                } catch (Exception e) {
                    System.out.println("Error found"+ e);
                }
        }
    }