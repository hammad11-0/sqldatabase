public class student {

    private String name;
    private int phno;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhno() {
        return phno;
    }

    public void setPhno(int phno) {
        this.phno = phno;
    }

    public student(String s,int a)
    {
        this.name=s;
        this.phno=a;

    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", phno=" + phno +
                '}';
    }
}
