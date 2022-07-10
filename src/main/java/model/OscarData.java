package model;

public class OscarData {
    private int index;
    private int year;
    private Integer age;
    private String name;
    private String movie;
    private int award;

    public OscarData(int index, int year, Integer age, String name, String movie, int award) {
        this.index = index;
        this.year = year;
        this.age = age;
        this.name = name;
        this.movie = movie;
        this.award = award;
    }

    public int getAward() {
        return award;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "DadosOscar{" +
                "index=" + index +
                ", year=" + year +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", movie='" + movie + '\'' +
                '}';
    }
}
