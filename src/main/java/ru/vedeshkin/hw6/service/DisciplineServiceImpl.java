package ru.vedeshkin.hw6.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vedeshkin.hw6.dao.DisciplinesDAO;
import ru.vedeshkin.hw6.entity.Discipline;

import java.util.List;

@Service
public class DisciplineServiceImpl implements DisciplineService {

    @Autowired
    private DisciplinesDAO disciplinesDAO;

    @Override
    @Transactional
    public List<Discipline> getAllDisciplines() {
        return disciplinesDAO.getAllDisciplines();
    }

    @Override
    @Transactional
    public Discipline saveDiscipline(Discipline discipline) {
        return disciplinesDAO.saveDiscipline(discipline);
    }

    @Override
    @Transactional
    public Discipline getDiscipline(int id) {
        return disciplinesDAO.getDiscipline(id);
    }

    @Override
    @Transactional
    public void deleteDiscipline(int id) {
        disciplinesDAO.deleteDiscipline(id);
    }
}
