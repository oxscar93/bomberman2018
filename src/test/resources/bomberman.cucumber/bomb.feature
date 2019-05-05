Feature: Bomb behaviour

   # ATDD 2

   Scenario: A bomb is launched with a time of 3 second and destroy walls of melanin
   Given As a bomb with a time of 3 seconds
   When  it explodes and there are melanin walls
   Then  destroy 3 walls of melanin

   Scenario: A bomb is launched with a time of 3 second and destroy an enemy
   Given As a bomb with a time of 3 seconds
   When  it explodes and there is an enemy
   Then  kill the enemy by the blast  wave

   Scenario: A bomb is launched with a time of 3 seconds and there is a metal wall
   Given As a bomb with a time of 3 seconds
   When  it explodes and there are metal walls
   Then  it does not destroy the metal wall