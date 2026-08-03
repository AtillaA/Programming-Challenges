Team Interface
--------------
Implement inheritance as described below.

Create a class Team that has the following:

1. A member variable teamName [string]
2. A member variable noOPlayers [integer]
3. A constructor function:
  - It takes 2 parameters and assigns them to teamName and noOfPlayers respectively.
4. A member function AddPlayer(count):
  - It takes an integer count as a parameter and increases noOfPlayers by count.

5. A member function RemovePlayer(count):
  - It takes an integer count as a parameter and tries to decrease noOfPlayers by count.
  - If decreasing makes noOfPlayers negative, then this function simply returns false.
  - Else, decrease noOfPlayers by count and return true.

Create a class Subteam that inherits from the above class Team. It has the following:

1. A constructor function:
 - It takes 2 parameters, teamName and noOfPlayers, and calls the base class constructor with these parameters.

2. A member function ChangeTeamName(name):
  - It takes a string name as a parameter and changes teamiame to name.

Note: Declare all the members as public so that they are accessible by the stubbed code.
