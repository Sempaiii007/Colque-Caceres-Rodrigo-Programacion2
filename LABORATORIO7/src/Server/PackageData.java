package Server;


import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class PackageData implements Serializable {
    private String nick;
    private String msn;
    private Date senddate;
    private String ip;

    public PackageData(String nick, String msn, String ip) {
        this.nick = nick;
        this.msn = msn;
        this.ip = ip;
        this.senddate = Calendar.getInstance().getTime();
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public Date getSenddate() {
        return senddate;
    }

    public void setSenddate(Date senddate) {
        this.senddate = senddate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
