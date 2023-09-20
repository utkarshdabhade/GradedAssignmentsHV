import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class employeeAuthentication {
        private int EmpID;
    public static String EmpName;
    public static char AdminFlag;
    private static String LoginName;
    private static String LoginPass;

    public employeeAuthentication (int empID, String empNm, char admfg, String loginNm, String loginPwd  ) {
        this.AdminFlag = admfg;
        this.EmpID = empID;
        this.EmpName = empNm;
        this.LoginName = loginNm;
        this.LoginPass = loginPwd;
       

}

    public int getEmpID() {
        return EmpID;
    }

    public void setEmpID(int empID) {
        EmpID = empID;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public char getAdminFlag() {
        return AdminFlag;
    }

    public void setAdminFlag(char adminFlag) {
        AdminFlag = adminFlag;
    }

    public String getLoginName() {
        return LoginName;
    }

    public void setLoginName(String loginName) {
        LoginName = loginName;
    }

    public String getLoginPass() {
        return LoginPass;
    }

    public void setLoginPass(String loginPass) {
        LoginPass = loginPass;
    }

    public static void main(String[] args) {
            
        
            
        try {
            String csvFile = "csvEmployee.csv";
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
        String EmpID = "Employee Login ID";
        String newRow = newNumber + "," + EmpID + "," + EmpName + "," + LoginName + "," + LoginPass + "," + AdminFlag;
        
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

