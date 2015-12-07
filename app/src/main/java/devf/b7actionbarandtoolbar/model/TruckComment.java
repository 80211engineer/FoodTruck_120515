package devf.b7actionbarandtoolbar.model;

/**
 * Created by Luis Galvan on 12/2/2015.
 */
public class TruckComment {


    private String TnameUser;
    private String Tdate;
    private String Tcomment;
    private int TuserImage;
    private int tlikes;


    public TruckComment(String tcomment, String tdate, String tnameUser) {
        Tcomment = tcomment;
        Tdate = tdate;
        TnameUser = tnameUser;
    }

    public TruckComment(String tcomment, String tdate, int tlikes, String tnameUser, int tuserImage) {
        Tcomment = tcomment;
        Tdate = tdate;
        this.tlikes = tlikes;
        TnameUser = tnameUser;
        TuserImage = tuserImage;
    }


    public String getTcomment() {
        return Tcomment;
    }

    public String getTdate() {
        return Tdate;
    }

    public int getTlikes() {
        return tlikes;
    }

    public String getTnameUser() {
        return TnameUser;
    }

    public int getTuserImage() {
        return TuserImage;
    }


    public void setTcomment(String tcomment) {
        Tcomment = tcomment;
    }

    public void setTdate(String tdate) {
        Tdate = tdate;
    }

    public void setTlikes(int tlikes) {
        this.tlikes = tlikes;
    }

    public void setTnameUser(String tnameUser) {
        TnameUser = tnameUser;
    }

    public void setTuserImage(int tuserImage) {
        TuserImage = tuserImage;
    }
}
