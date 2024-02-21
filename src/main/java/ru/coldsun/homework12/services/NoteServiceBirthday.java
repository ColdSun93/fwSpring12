package ru.coldsun.homework12.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.coldsun.homework12.model.Note;
import ru.coldsun.homework12.repository.NoteRepository;


import java.util.List;
import java.util.stream.Collectors;

/**
 * Реализация паттерна Factory Method
 * Реализовано два сервиса @birthday и @allnotes
 * для сервиса @birthday добавлена реализация метода @getAllNotes
 * для остальных методов реализация не выполнена
 */
@Service("birthday")
@AllArgsConstructor
public class NoteServiceBirthday implements SubjectOfNotes{
    private final NoteRepository noteRepository;

    public List<Note> getAllNotes() {
        List<Note> changeNote = noteRepository.findAll();
        return changeNote.stream().filter(note -> note.getHeading().contains("Birthday"))
                .collect(Collectors.toList());
    }
    @Override
    public Note addNotes(Note note) {
        return null;
    }

    @Override
    public Note updateNoteStatus(Long id, Note note) {
        return null;
    }

    @Override
    public Note getByIdNotes(Long id) {
        return null;
    }

    @Override
    public void deleteByNotes(Long id) {

    }

    @Override
    public List<Note> sortAllNotes() {
        return null;
    }
}
