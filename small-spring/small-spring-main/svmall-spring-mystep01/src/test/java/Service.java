public class Service {
    private String s;
    public Service(String s) {
        this.s = s;
    }

    public Service() {
        this.s = "无参";
    }

    public void test() {
        System.out.println("hello:" + s);
    }
}
