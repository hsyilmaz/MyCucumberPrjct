#  Bir önceki Exam Giriş Senaryosunu
#  Aşağıdaki değerler için çalıştırınız.
#
#| ExamName        | AcademicPeriodOption      | GradeLevelOption |
#| Math exam is1   | academicPeriod2              | gradeLevel4  |
#| IT exam is1     | academicPeriod2              | gradeLevel2  |
#| Oracle exam is1 | academicPeriod2              | gradeLevel3  |
#| Math exam  is1  | academicPeriod2              | gradeLevel1  |
Feature: Entrance Exam Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Exam creation and deletion
    When Click on the element in the Left Nav
      | EntranceExam1 |
      | setup2        |
      | EntranceExam2 |

    And Click on the element in the Dialog
      | add_c |

    And User sending the keys in Dialog content
      | name_c | <ExamName> |

    And Click on the element in the Form Content
      | AcademicPeriod         |
      | <AcademicPeriodOption> |
      | GradeLevel             |
      | <GradeLevelOption>     |

  And Click on the element in the Dialog
      | save_c |
    Then Success message should be displayed

    When Click on the element in the Left Nav
      | EntranceExam1 |
      | setup2        |
      | EntranceExam2 |

    And User delete item from the Dialog
      | <ExamName> |

    Then Success message should be displayed
    Examples:
      | ExamName | AcademicPeriodOption | GradeLevelOption |
      | Math1191 | AcademicPeriod_v     | GradeLevel_v     |
      | Math101  | AcademicPeriod_v     | GradeLevel_v     |