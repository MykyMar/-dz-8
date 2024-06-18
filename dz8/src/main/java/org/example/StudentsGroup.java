package org.example;
//Описати клас, який репрезентує групу студентів (StudentsGroup) з наступними полями:
//
//староста (тип Student)
//список студентів (тип список Student)
//список завдань
//Група не може існувати без старости.
//
//Методи класу:
//змінити старосту +
//додати/видалити студента +
//додати завдання (для всієї групи)
//позначити завдання як виконане (для зазначеного студента)
//
//
//Староста та студенти є об'єктами класу Student.
//
//Завдання є простими рядками (String) (приклад: вивчити інкапсуляцію).

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StudentsGroup {

    private Student leader;
    private final HashSet<Student> students = new HashSet<>();
    private final ArrayList<String> tasks = new ArrayList<>();
    private final HashSet<Integer> ids = new HashSet<>();  // масив для зберігання id юзера. потрібен для перевірки унікальності.
    private final HashMap<Student, ArrayList<String>> completedTasks = new HashMap<>();


    public StudentsGroup(Student leader) {
        this.leader = leader;
        students.add(leader);
        ids.add(leader.getId());
        completedTasks.put(leader, new ArrayList<>()); //одразу заповнюємо всі масиви новими студентами
    }

    public void addStudent(Student newStudent) {

        if (!ids.contains(newStudent.getId())) { // перевірка унікальності
            students.add(newStudent);
            ids.add(newStudent.getId());
            completedTasks.put(newStudent, new ArrayList<>());//одразу заповнюємо всі масиви новими студентами
        } else System.out.println("Student id must be unique");

    }



    public void removeStudent(Student student) {
        if (leader.getId() == student.getId()) {  // не можна видалити лідера якщо нового ще нема
            System.out.println("This student is leader. Please set new leader before deleting.");
            return;
        }
        students.remove(student);
        ids.remove(student.getId());
        completedTasks.remove(student); // оновлюємо всі масиви
    }

    public void changeLeader(Student newLeader) {
        if (students.contains(newLeader)) {
            this.leader = newLeader;
        } else System.out.println("Please add the student to the group before setting him as a new Leader.");
    }

    public void addTask(String newTask) {
        tasks.add(newTask);
    }

    public void markTaskAsCompleted(int studentId, int taskId) {
        String task = tasks.get(taskId);
        // шкаємо існуючого студента по studentId та додаємо йому існуючу таску по taskId(номер єлемента масива)
        for (Map.Entry<Student, ArrayList<String>> entry : completedTasks.entrySet()) {
            Student student = entry.getKey();
            if (student.getId() == studentId) {
                ArrayList<String> studentTasks = entry.getValue();
                if (!studentTasks.contains(task)) {
                    studentTasks.add(task);
                } else {
                    System.out.println("Task already marked as completed for this student.");
                }
                return;
            }
        }
    }

    public ArrayList<String> getTasks() {
        return tasks;
    }

    public HashSet<Student> getStudents() {
        return students;
    }

    public Student getLeader() {
        return leader;
    }

    public HashMap<Student, ArrayList<String>> getCompletedTasks() {
        return completedTasks;
    }
    public void printCompletedTasks() { // просто друк completedTasks для переевірки

        for (Map.Entry<Student, ArrayList<String>> entry : completedTasks.entrySet()) {
            Student student = entry.getKey();
            ArrayList<String> tasks = entry.getValue();

            System.out.println("Student: " + student.getId());
            System.out.println("Completed Tasks: " + tasks);
        }
    }
}

