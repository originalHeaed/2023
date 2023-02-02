import java.util.HashMap;
import java.util.Map;

public class UserDao {
    private static final Map<String, String> map = new HashMap<>();

    static {
        map.put("1", "老王");
        map.put("2", "老游");
        map.put("3", "老李");
        map.put("4", "老肖");
    }

    public String getVal(String key) {
        return map.get(key);
    }
}
