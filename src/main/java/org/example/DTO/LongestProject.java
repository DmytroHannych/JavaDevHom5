package org.example.DTO;

public class LongestProject {
    private String id;
    private int mounth;

    public LongestProject(String id, int mounth) {
        this.id = id;
        this.mounth = mounth;
    }

    @Override
    public String toString() {
        return "LongestProject{" +
                "id='" + id + '\'' +
                ", mounth=" + mounth +
                '}';
    }
}
