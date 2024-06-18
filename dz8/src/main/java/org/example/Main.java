package org.example;

public class Main {
    public static void main(String[] args) {
        Student st1 = new Student(1,"Joe","Den");
        Student st2 = new Student(2,"Tom","Yar");
        Student st3 = new Student(3, "Sam", "Zed");
        Student st4 = new Student(3, "Tim", "Lee");
        Student st5 = new Student(2, "Kim", "Fox");


        StudentsGroup studentsGroup = new StudentsGroup(st1);

        studentsGroup.addStudent(st2);
        studentsGroup.addStudent(st3);
        studentsGroup.addStudent(st4);

        for(Student st : studentsGroup.getStudents()){
            System.out.println("Group: "+ st.getId()+" "+st.getFirstName()+" "+st.getLastName());
        }
        System.out.println("Leader: "+ studentsGroup.getLeader().getId());
        studentsGroup.changeLeader(st3);
        ;
        for(Student st : studentsGroup.getStudents()){
            System.out.println("Group: "+ st.getId()+" "+st.getFirstName()+" "+st.getLastName());
        }
        System.out.println("Leader: "+ studentsGroup.getLeader().getId());

        studentsGroup.addTask("Create profile.");
        studentsGroup.addTask("Log in.");
        studentsGroup.addTask("Add new slide.");

        for (String s: studentsGroup.getTasks()){
            System.out.println("Task "+ s);
        }

        studentsGroup.markTaskAsCompleted(1,1);
        studentsGroup.markTaskAsCompleted(1,0);
        studentsGroup.markTaskAsCompleted(2,1);
        studentsGroup.printCompletedTasks();




    }
}