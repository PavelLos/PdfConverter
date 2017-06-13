import lombok.Getter;
import lombok.Setter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Setter
@Getter
public class FormValues {
    private String eventName;
    private Date dateOfEvent;
    private String companyName;
    private String nameOfPerson;
    private String surnameOfPerson;
    private String countryName;
    private String cityName;
    private String address;
    private String email;
    private String telephoneNumber1;
    private String telephoneNumber2;


    public FormValues(String eventName, Date dateOfEvent, String companyName, String nameOfPerson, String surnameOfPerson, String countryName, String cityName, String address, String email, String telephoneNumber1, String telephoneNumber2) {
        this.eventName = eventName;
        this.dateOfEvent = dateOfEvent;
        this.companyName = companyName;
        this.nameOfPerson = nameOfPerson;
        this.surnameOfPerson = surnameOfPerson;
        this.countryName = countryName;
        this.cityName = cityName;
        this.address = address;
        this.email = email;
        this.telephoneNumber1 = telephoneNumber1;
        this.telephoneNumber2 = telephoneNumber2;
    }

    @Override
    public String toString() {
        return "FormValues{" +
                "eventName='" + eventName + '\'' +
                ", dateOfEvent=" + dateOfEvent +
                ", companyName='" + companyName + '\'' +
                ", nameOfPerson='" + nameOfPerson + '\'' +
                ", surnameOfPerson='" + surnameOfPerson + '\'' +
                ", countryName='" + countryName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", telephoneNumber1='" + telephoneNumber1 + '\'' +
                ", telephoneNumber2='" + telephoneNumber2 + '\'' +
                '}';
    }

    public String getDateOfEvent() {
        DateFormat dateFormat = new SimpleDateFormat("dd - MM - yyyy");
        return dateFormat.format(dateOfEvent);
    }
}