public class UserService {
    private String userId;

    /**
     * service 层引用 dao 层对象，之前都是用注解或者 xml 形式
     */
    private UserDao userDao;

    public void queryUserInfo() {
        System.out.println("查询用户信息：" + userDao.getVal(userId));
    }
}
