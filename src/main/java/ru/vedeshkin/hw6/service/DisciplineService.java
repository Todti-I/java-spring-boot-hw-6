package ru.vedeshkin.hw6.service;

import org.springframework.stereotype.Service;
import ru.vedeshkin.hw6.entity.Discipline;

import java.util.List;

@Service
public interface DisciplineService {

    List<Discipline> getAllDisciplines();

    Discipline saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);

}
