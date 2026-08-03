using System;
using System.Collections.Generic;
using System.Linq;

public class NotesStore
{
  // nested class
    private class Note
    {
        public string Name { get; set; }
        public string State { get; set; }
    }

    // list to store notes
    private readonly List<Note> notesList = new List<Note>();

    // hashset containing the valid, case-sensitive states
    private readonly HashSet<string> validStates = new HashSet<string> { "completed", "active", "others" };

    public void AddNote(string state, string name) {
        if (string.IsNullOrEmpty(name)) { throw new ArgumentException("Name cannot be empty"); }

        if (!validStates.Contains(state)) { throw new ArgumentException($"Invalid state {state}"); }

        notesList.Add(new Note { Name = name, State = state });
    }

    // returns note names in order
    public List<string> GetNotes(string state) {
        if (!validStates.Contains(state)) { throw new ArgumentException($"Invalid state {state}"); }

        return notesList
            .Where(note => note.State == state)
            .Select(note => note.Name)
            .ToList();
    }
}
