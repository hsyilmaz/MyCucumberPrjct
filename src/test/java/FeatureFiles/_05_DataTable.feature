Feature: Datatable Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create Country
    When Click on the element in the Left Nav
      | setupOne   |
      | parameters |
      | countries  |

    And Click on the element in the Dialog
      | add_c |

    And User sending the keys in Dialog content
      | name_c | hyxcountry |
      | code_c | 338       |

    And Click on the element in the Dialog
      | save_c |
    And Success message should be displayed

    And User delete item from the Dialog
      | hyxcountry |

    And Success message should be displayed


  Scenario: Create a Nationality
    When Click on the element in the Left Nav
      | setupOne    |
      | parameters  |
      | nationality |

    And Click on the element in the Dialog
      | add_c |

    And User sending the keys in Dialog content
      | name_c | HYX1 |

    And Click on the element in the Dialog
      | save_c |

    And Success message should be displayed

    And User delete item from the Dialog
      | HYX1 |
    And Success message should be displayed

  Scenario: Create a Fee, delete Fee

    When Click on the element in the Left Nav
      | setupOne   |
      | parameters |
      | fees       |

    And Click on the element in the Dialog
      | add_c |

    And User sending the keys in Dialog content
      | name_c   | course11 |
      | code_c   | 12394   |
      | intCode  | z12304a   |
      | priority | 583      |

    And Click on the element in the Dialog
      | save_c |
    And Success message should be displayed

    And User delete item from the Dialog
      | course11 |

    Then Success message should be displayed

    #    Senaryo Outline da verilen değerler için tüm senaryo her satır kadar tekrar çalıştırılıyordu.
    #    DataTable da ise, sadece ilgili step için toplu veri gönderme imkanı oluşuyor.

