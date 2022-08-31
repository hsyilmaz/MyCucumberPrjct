Feature: Employee Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Creating Questioning and Deleting Employee

    When Click on the element in the Left Nav
      | humanRes  |
      | employees |

    When Click on the element in the Form Content
    |addEmp|

    When User sends the keys in the Form content
      | nameEmp    | <name>       |
      | surnameEmp | <surname>    |
      | employeeID | <employeeID> |


    When Click on the element in the Form Content
      | genderEmp       |
      | <gender>        |
      | typeEmp         |
      | <type>          |
      | qualifyEmp      |
      | <qualify> |
      | docTypeEmp      |
      | <docType>       |

    When User sends the keys in the Form content

      | docNumEmp  | <docNumber>  |
      | perIdEmp   | <perID>      |
      | schDeptEmp | <schoolDept> |


    When Click on the element in the Form Content
      |contactAdr|

    When User sends the keys in the Form content
      | country    | <country>    |

    And Click on the element in the Dialog
      | save_c |

    Then Success message should be displayed

    When Click on the element in the Dialog
      | deleteButton    |
      | deleteDialogBtn |

    Then Success message should be displayed

    Examples:
      | name | surname | employeeID | gender | type   | qualify | docType  | perID | schoolDept  | docNumber | country |
      | Ryan | Field   | 12345678   | male   | superV | bachelor| passport | 12345 | engineering | DN12345   | Turkey  |
