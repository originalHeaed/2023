package spring.ioc;

import java.util.Objects;

public class Resource {

    private final String path;
    private final String name;

    public Resource(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getPath() {
        return this.path;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "path='" + path + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Objects.equals(path, resource.path) &&
                Objects.equals(name, resource.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(path, name);
    }
}
