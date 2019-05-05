Feature: Bomberman movement behaviour

  # ATDD 1

  Scenario: Bomberman can move to empty cell
    Given As a bomberman
    When I see an empty cell
    Then I can move to that cell

  Scenario: Bomberman can't move to cell with a wall
    Given As a bomberman
    When I see a cell with a wall
    Then I can't move to that cell

  Scenario: Bomberman can move to empty cell
    Given As a bomberman
    When I see an empty cell
    And I move to that cell
    Then bomberman is in an empty cell

  Scenario: Bomberman dies when he tries to move to a cell with an enemy
    Given As a bomberman
    When I see a cell with an enemy
    And I move to that cell
    Then I die

  Scenario: Bomberman moves to a cell with power
    Given As a bomberman
    When I see a cell with a power
    And I move to that cell
    Then I get the power


