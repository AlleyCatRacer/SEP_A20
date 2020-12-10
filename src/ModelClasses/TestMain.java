package ModelClasses;

public class TestMain {


  public static void main(String[] args)
  {
    System.out.println("Hello Darkness");

    ProjectList wick = new ProjectList();


    //MyDate check
    MyDate l=new MyDate(11,12,2020);
    Project p=new Project("Title","id","cid",l,"comment");
    MyDate i1=new MyDate(1,1,2019);
    MyDate i2=new MyDate(0,1,2021);
    MyDate i3=new MyDate(1,0,2021);
    MyDate i4=new MyDate(30,2,2021);
    MyDate i5=new MyDate(9,12,2020);

    System.out.println(l.isValidDate(l));
  }
}
