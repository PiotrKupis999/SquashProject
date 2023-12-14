import java.util.List;

public class Admin extends User{

    private String code = "0000";
    public Admin(){
        super();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
