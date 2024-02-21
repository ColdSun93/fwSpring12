package ru.coldsun.homework12.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.coldsun.homework12.model.Note;
import ru.coldsun.homework12.model.NoteServiceFactory;


import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/notes")
public class NoteController {

    private final Counter requestCounter = Metrics.counter("request_count");

    @Autowired
    private final NoteServiceFactory noteService; //фабрики (методов) сервисов


    /**
     * Добавление заметки.
     */
    @PostMapping
    public Note addNote(@RequestBody Note note){
        return noteService.getService("allnotes").addNotes(note);
    }

    /**
     * Редактирование заметки.
     */
    @PutMapping("/{id}")
    public Note updateNoteStatus(@PathVariable Long id, @RequestBody Note note){
        return noteService.getService("allnotes").updateNoteStatus(id, note);
    }

    /**
     * Просмотр всех заметок
     */
    @GetMapping
    public List<Note> getAllNotes() {
        requestCounter.increment();
        return noteService.getService("allnotes").getAllNotes();
    }

    /**
     * Получение заметки по id
     */
    @GetMapping("/{id}")
    public Note findById(@PathVariable("id") Long id) {
        return noteService.getService("allnotes").getByIdNotes(id);
    }

    /**
     * Удаление заметки
     */
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id){
        noteService.getService("allnotes").deleteByNotes(id);
    }

    /**
     * Сортировка заметок
     */
    @GetMapping("/sortDate")
    public List<Note> sortNote() {
        return noteService.getService("allnotes").sortAllNotes();
    }

    /**
     * росмотр всех заметок тематикой birthday
     * реализовано через фабричный метод @birthday
     */
    @GetMapping("/birthday")
    public List<Note> getAllNotesBirthday() {
        return noteService.getService("birthday").getAllNotes();
    }


}
