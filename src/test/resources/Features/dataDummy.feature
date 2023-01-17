Feature: LEA - Channeling

  @dataDummy
  Scenario Outline: Generate Data Dummy Individu
    Given generate data "<Case1>""<Case2>""<Case3>"

    Examples:
      | Case1   | Case2   | Case3    |
      | APPFILE | REAFILE | PENGURUS |
