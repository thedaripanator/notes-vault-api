package com.secure.notes.Controller;

import com.secure.notes.Model.Notes;
import com.secure.notes.services.NoteService;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NoteService noteService;

    @PostMapping
    public Notes createNote(@RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        System.out.println("username: " + username);
        return noteService.createNoteForUser(username, content);
    }

    @GetMapping
    public List<Notes> getAllNotes(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        return noteService.getNotesForUser(username);
    }

    @PutMapping("/{noteId}")
    public Notes updateNote(@PathVariable Long noteId,String content, @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        return noteService.updateNoteForUser(noteId, content, username);
    }

    @DeleteMapping("/{nodeId}")
    public void deleteNoteForUser(@PathVariable Long noteId,@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        noteService.deleteNoteForUser(username, noteId);
    }
}
