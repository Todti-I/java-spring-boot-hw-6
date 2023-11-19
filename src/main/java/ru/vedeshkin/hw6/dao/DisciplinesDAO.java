package ru.vedeshkin.hw6.dao;

import org.springframework.stereotype.Repository;
import ru.vedeshkin.hw6.entity.Discipline;
import ru.vedeshkin.hw6.entity.Student;

import java.util.List;

@Repository
public interface DisciplinesDAO {

    List<Discipline> getAllDisciplines();

    Discipline saveDiscipline(Discipline discipline);

    Discipline getDiscipline(int id);

    void deleteDiscipline(int id);

}
