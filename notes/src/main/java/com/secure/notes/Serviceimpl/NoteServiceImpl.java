package com.secure.notes.Serviceimpl;

import com.secure.notes.Model.Notes;
import com.secure.notes.Repository.NotesRepository;
import com.secure.notes.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl  implements NoteService {

    @Autowired
    private NotesRepository repo;
    @Override
    public Notes createNoteForUser(String username, String content) {
        Notes note =new Notes();
        note.setOwnerUsername(username);
        note.setContent(content);
        return repo.save(note);
    }

    @Override
    public Notes updateNoteForUser(Long noteId,String username, String content) {
        Notes note=repo.findById(noteId).orElseThrow(()->new RuntimeException("Note not found"));
        note.setContent(content);
        return repo.save(note);
    }

    @Override
    public void deleteNoteForUser(String username, Long noteId) {

         repo.deleteById(noteId);
    }

    @Override
    public List<Notes> getNotesForUser(String username) {
        return repo.findByOwnerUsername(username);
    }
}
