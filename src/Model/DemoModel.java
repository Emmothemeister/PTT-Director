package Model;

import java.util.HashMap;

public class DemoModel extends BaseModel {
    private String userName;
    private String password;

    public DemoModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String[] getFields() {
        return new String[]{"ID", "userName", "password"};
    }

    @Override
    public HashMap<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("userName", userName);
        map.put("password", password);
        return map;
    }

    @Override
    public String getTableName() {
        return "Demo";
    }

    @Override
    public Object map2Object(HashMap<String, String> data) {
        return new DemoModel(data.get("userName"), data.get("password"));
    }

    @Override
    public String toString() {
        return "DemoModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) {
        DemoModel demoModel = new DemoModel("test", "fku");
        HashMap<String, String> where = new HashMap<>();
        where.put("ID", "2");
        demoModel.delete(where);
    }
}
