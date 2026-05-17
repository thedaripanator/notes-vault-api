package com.secure.notes.services;

import com.secure.notes.Model.Notes;

import java.util.List;

public interface NoteService {

    Notes createNoteForUser(String username, String content);
    Notes updateNoteForUser(Long noteId,String username, String content);

    void deleteNoteForUser(String username, Long noteId);

    List<Notes> getNotesForUser(String username);
}
