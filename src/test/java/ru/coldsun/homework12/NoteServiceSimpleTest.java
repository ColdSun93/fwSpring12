package ru.coldsun.homework12;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.coldsun.homework12.exception.NoteNotFoundException;
import ru.coldsun.homework12.model.Note;
import ru.coldsun.homework12.repository.NoteRepository;
import ru.coldsun.homework12.services.NoteService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class NoteServiceSimpleTest {

    @Mock
    public NoteRepository noteRepository;

    @InjectMocks
    public NoteService noteService;

    /**
     * Получение всех заметок.
     */
    @Test
    public void getAllNote(){
        List<Note> notes = List.of(new Note());

        given(noteRepository.findAll()).willReturn(notes);

        List<Note> testListNotes = noteService.getAllNotes();

        verify(noteRepository).findAll();

        Assertions.assertEquals(notes.size(), testListNotes.size());
    }

    /**
     * Получение заметки по id.
     */
    @Test
    public void getByIdNotes() {
        Long noteId = 1L;
        Note note1 = new Note();
        note1.setId(noteId);

        given(noteRepository.findById(noteId))
                .willReturn(Optional.of(note1));

        Note note2 = noteService.getByIdNotes(noteId);
        verify(noteRepository).findById(noteId);

        Assertions.assertEquals(note1, note2);
    }

    /**
     * Проверка исключения при отсутствии при запросе по id.
     */
    @Test
    public void getByIdNotesException() {
        Long noteId = 1L;
        given(noteRepository.findById(noteId))
                .willReturn(Optional.empty());

        assertThrows(NoteNotFoundException.class, () ->
                noteService.getByIdNotes(noteId));

        verify(noteRepository).findById(noteId);
    }

}
