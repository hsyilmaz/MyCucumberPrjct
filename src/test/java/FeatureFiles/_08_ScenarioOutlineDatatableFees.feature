#  Daha önceki Create a Fee, delete Fee Senaryosunu
#  Aşağıdaki 3 farklı değerler için çalıştırınız.

Feature: Fee Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario Outline: Creating and deleting Fee

    When Click on the element in the Left Nav
      | setupOne   |
      | parameters |
      | fees       |

    And Click on the element in the Dialog
      | add_c |

    And User sending the keys in Dialog content
      | name_c   | <name>     |
      | code_c   | <code>     |
      | intCode  | <intCode>  |
      | priority | <priority> |

    And Click on the element in the Dialog
      | save_c |

    And Success message should be displayed

    And User delete item from the Dialog
      | <name> |

    And Success message should be displayed

    Examples:
      | name   | code  | intCode    | priority |
      | HYzxt1 | 01091 | pay_pall   | 876      |
      | HYzxt2 | 02092 | apple_Pay  | 875      |
      | HYzxt3 | 02093 | google_Pay | 874      |