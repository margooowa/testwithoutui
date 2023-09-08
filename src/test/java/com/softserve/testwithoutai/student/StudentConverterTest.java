package com.softserve.testwithoutai.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentConverterTest {

  private StudentConverter converter;

  @BeforeEach
  void setup() {
    this.converter = new StudentConverter();
  }

  @Test
  void should_convertStudentsWithHonor_when_ageAbove21AndGradeAbove90() {
    // given
    List<Student> studentList = getStudents();

    //when
    List<Student> studentsResult = converter.convertStudents(studentList);

    //then
    assertEquals(5, studentsResult.size());
    assertThat(studentsResult)
        .filteredOn(Student::isHonorRoll)
        .hasSize(2);
  }

  @Test
  void should_convertStudentsExceptional_when_ageLess21AndGradeAbove90() {
    // given
    List<Student> studentList = getStudents();

    //when
    List<Student> studentsResult = converter.convertStudents(studentList);

    //then
    assertEquals(5, studentsResult.size());
    assertThat(studentsResult)
        .filteredOn(Student::isExceptional)
        .hasSize(1);
  }

  @Test
  void should_convertStudentsPassed_when_gradeBetween71And90() {
    // given
    List<Student> studentList = getStudents();

    //when
    List<Student> studentsResult = converter.convertStudents(studentList);

    //then
    assertEquals(5, studentsResult.size());
    assertThat(studentsResult)
        .filteredOn(Student::isPassed)
        .hasSize(1);
  }

  @Test
  void should_convertStudentsFailed_when_gradeLess70() {
    // given
    List<Student> studentList = getStudents();

    //when
    List<Student> studentsResult = converter.convertStudents(studentList);

    //then
    assertEquals(5, studentsResult.size());
    assertThat(studentsResult)
        .filteredOn(st -> !st.isExceptional() && !st.isHonorRoll() && !st.isPassed())
        .hasSize(1);
  }

  @Test
  void should_returnEmptyconvertStudents_when_empty() {
    // given
    List<Student> studentList = Collections.emptyList();

    //when
    List<Student> studentsResult = converter.convertStudents(studentList);

    //then
    assertEquals(0, studentsResult.size());
  }

  private static List<Student> getStudents() {
    Student student1 = new Student();
    student1.setAge(22);
    student1.setGrade(97);
    Student student2 = new Student();
    student2.setAge(25);
    student2.setGrade(91);
    Student student3 = new Student();
    student3.setAge(19);
    student3.setGrade(91);
    Student student4 = new Student();
    student4.setAge(22);
    student4.setGrade(87);
    Student student5 = new Student();
    student5.setAge(22);
    student5.setGrade(55);
    return List.of(student1, student2, student3, student4, student5);
  }
}
