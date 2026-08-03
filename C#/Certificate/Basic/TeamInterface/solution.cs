using System;

public class Team
{
    // member variables
    public string teamName;
    public int noOfPlayers;

    // constructor
    public Team(string teamName, int noOfPlayers) {
        this.teamName = teamName;
        this.noOfPlayers = noOfPlayers;
    }

    public void AddPlayer(int count) {
        noOfPlayers += count;
    }

    public bool RemovePlayer(int count) {
        if (noOfPlayers - count < 0) {
            return false;
        }
        
        noOfPlayers -= count;
        return true;
    }
}

public class Subteam : Team
{
    // constructor calling the base class constructor
    public Subteam(string teamName, int noOfPlayers) : base(teamName, noOfPlayers) { }

    public void ChangeTeamName(string name) {
        teamName = name;
    }
}
