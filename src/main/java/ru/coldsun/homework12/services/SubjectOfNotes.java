package ru.coldsun.homework12.services;

import ru.coldsun.homework12.model.Note;

import java.util.List;

/**
 * Базовый интерфейс для сервисов реализации
 */
public interface SubjectOfNotes {
    Note addNotes(Note note);

    Note updateNoteStatus(Long id, Note note);

    List<Note> getAllNotes();

    Note getByIdNotes(Long id);

    void deleteByNotes(Long id);

    List<Note> sortAllNotes();
}
