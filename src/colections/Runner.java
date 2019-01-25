package colections;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sirri
 */
public class Runner 
{
    private String firstName;
    private String lastName;
    private Integer position;
    private String finishDate;
    private String runnerID;



    public Runner(String L,String F,String P,String D,String R)
    {
        firstName = F;
        lastName = L;
        position = Integer.parseInt(P);
        finishDate = D;
        runnerID = R;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getPosition() {
        return position;
    }

    public Date getFinishDate() {
        Date actFinishDate = new Date();
        try {
            actFinishDate = DateFormat.getDateInstance().parse(finishDate);
        } catch (ParseException ex) {
            Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actFinishDate;
    }
    
    public String getRunnerID() {
        return runnerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(Integer Position) {
        this.position = Position;
    }

    public void setFinishDate(String finishDate) {
        this.finishDate = finishDate;
    }
    
    public void setRunnerID(String runnerID) {
        this.runnerID = runnerID;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.firstName);
        hash = 67 * hash + Objects.hashCode(this.lastName);
        hash = 67 * hash + Objects.hashCode(this.position);
        hash = 67 * hash + Objects.hashCode(this.finishDate);
        hash = 67 * hash + Objects.hashCode(this.runnerID);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Runner other = (Runner) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        if (!Objects.equals(this.finishDate, other.finishDate)) {
            return false;
        }
        if (!Objects.equals(this.runnerID, other.runnerID)) {
            return false;
        }
        return true;
    }
    
}