package com.softserve.testwithoutai.student;

import java.util.List;
import java.util.stream.Collectors;

public class StudentConverter {

  public List<Student> convertStudents(List<Student> students) {

    return students.stream().map(student ->
    {
      Student result = new Student();

      result.setName(student.getName());
      result.setAge(student.getAge());
      result.setGrade(student.getGrade());

      if (student.getGrade() > 90) {
        if (student.getAge() < 21) {
          result.setExceptional(true);
        } else {
          result.setHonorRoll(true);
        }
      } else if (student.getGrade() > 70) {
        result.setPassed(true);
      } else {
        result.setPassed(false);
      }

      return result;
    }).collect(Collectors.toList());
  }
}
