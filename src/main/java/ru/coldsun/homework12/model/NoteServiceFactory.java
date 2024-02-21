package ru.coldsun.homework12.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.coldsun.homework12.services.SubjectOfNotes;

import java.util.Map;

/**
 * Создание фабрики методов
 * @SubjectOfNotes интерфейс методов
 * @services колекция методов
 */

@Component
public class NoteServiceFactory {
    @Autowired
    private Map<String, SubjectOfNotes> services;
    public SubjectOfNotes getService(String method) {
        return services.get(method);
    }

}
