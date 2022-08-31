Feature: Entrance Exam Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Exam creation and deletion
    When Click on the element in the Left Nav
      | EntranceExam1 |
      | setup2        |
      | EntranceExam2 |

    And Click on the element in the Dialog
      | add_c |

    And User sending the keys in Dialog content
      | name_c | Exam135 |

    And Click on the element in the Form Content
      | AcademicPeriod   |
      | AcademicPeriod_v |
      | GradeLevel       |
      | GradeLevel_v     |

    And Click on the element in the Dialog
      | save_c |
    Then Success message should be displayed

    When Click on the element in the Left Nav
      | EntranceExam1 |
      | setup2        |
      | EntranceExam2 |

    And User delete item from the Dialog
      | Exam135 |

    Then Success message should be displayed
