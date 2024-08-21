package javathreadsexamples;

class TaskCounter extends Thread{
    private String name;
    public TaskCounter(String name){
        this.name = name;
    }
    public void run(){
        for(int i = 1; i <= 10; i++){
            System.out.println(this.name + "Executed " + i + "º");
        }
    }
}

public class Main {
    public static void main(String[] args){
        Thread t1 = new TaskCounter("Task 1 ");
        Thread t2 = new TaskCounter("Task 2 ");
        t1.start();
        t2.start();  
    }
}