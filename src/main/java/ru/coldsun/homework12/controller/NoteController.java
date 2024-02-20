package ru.coldsun.homework12.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.coldsun.homework12.model.Note;
import ru.coldsun.homework12.services.FileGateway;
import ru.coldsun.homework12.services.NoteService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {

    private final Counter requestCounter = Metrics.counter("request_count");

    @Autowired
    private final NoteService noteService;

    //private final FileGateway fileGateway;

    /**
     * Добавление заметки.
     */
    @PostMapping
    public Note addNote(@RequestBody Note note){
        //fileGateway.writeToFile(note.getHeading() + ".txt", note.toString());
        return noteService.addNotes(note);
    }

    /**
     * Редактирование заметки.
     */
    @PutMapping("/{id}")
    public Note updateNoteStatus(@PathVariable Long id, @RequestBody Note note){
        return noteService.updateNoteStatus(id, note);
    }

    /**
     * Просмотр всех заметок
     */
    @GetMapping
    public List<Note> getAllNotes() {
        requestCounter.increment();
        return noteService.getAllNotes();
    }

    /**
     * Получение заметки по id
     */
    @GetMapping("/{id}")
    public Note findById(@PathVariable("id") Long id) {
        return noteService.getByIdNotes(id);
    }

    /**
     * Удаление заметки
     */
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.deleteByNotes(id);
    }

    /**
     * Сортировка заметок
     */
    @GetMapping("/sortDate")
    public List<Note> sortNote() {
        return noteService.sortAllNotes();
    }


}
