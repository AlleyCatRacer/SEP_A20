package ModelClasses;

public class TestMain {


  public static void main(String[] args)
  {
    System.out.println("Hello Darkness");

    ProjectList wick = new ProjectList();


    //MyDate check
    MyDate l=new MyDate(12,12,2020);
    Project p=new Project("Title","id","cid",l,"comment");
    MyDate i2=new MyDate(1,1,2021);
    MyDate i3=new MyDate(1,4,2021);
    MyDate i5=new MyDate(10,12,2021);

  }
}
