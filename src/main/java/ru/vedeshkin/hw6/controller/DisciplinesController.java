package ru.vedeshkin.hw6.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.vedeshkin.hw6.entity.Discipline;
import ru.vedeshkin.hw6.model.Response;
import ru.vedeshkin.hw6.model.ResponseCode;
import ru.vedeshkin.hw6.service.DisciplineService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/disciplines")
public class DisciplinesController {

    @Autowired
    private DisciplineService disciplineService;

    @GetMapping()
    public Response<List<Discipline>> allDisciplines() {
        Response.ResponseBuilder<List<Discipline>> responseBuilder = Response.builder();
        try {
            List<Discipline> allDisciplines = disciplineService.getAllDisciplines();
            responseBuilder.code(ResponseCode.SUCCESS);
            responseBuilder.data(allDisciplines);
        } catch (Exception exception) {
            log.error("GET /api/disciplines: {}", exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }

    @GetMapping("/{id}")
    public Response<Discipline> getDiscipline(@PathVariable("id") int id) {
        Response.ResponseBuilder<Discipline> responseBuilder = Response.builder();
        try {
            Discipline discipline = disciplineService.getDiscipline(id);
            responseBuilder.code(ResponseCode.SUCCESS);
            responseBuilder.data(discipline);
        } catch (Exception exception) {
            log.error("GET /api/disciplines/{}: {}", id, exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }

    @PostMapping()
    public Response<Discipline> saveDiscipline(@RequestBody Discipline discipline) {
        Response.ResponseBuilder<Discipline> responseBuilder = Response.builder();
        try {
            Discipline updatedDiscipline = disciplineService.saveDiscipline(discipline);
            responseBuilder.code(ResponseCode.SUCCESS);
            responseBuilder.data(updatedDiscipline);
        } catch (Exception exception) {
            log.error("POST /api/disciplines: {}", exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }

    @PutMapping()
    public Response<Discipline> updateDiscipline(@RequestBody Discipline discipline) {
        Response.ResponseBuilder<Discipline> responseBuilder = Response.builder();
        try {
            Discipline updatedDiscipline = disciplineService.saveDiscipline(discipline);
            responseBuilder.code(ResponseCode.SUCCESS);
            responseBuilder.data(updatedDiscipline);
        } catch (Exception exception) {
            log.error("PUT /api/disciplines: {}", exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }

    @DeleteMapping("/{id}")
    public Response<Object> deleteDiscipline(@PathVariable("id") int id) {
        Response.ResponseBuilder<Object> responseBuilder = Response.builder();
        try {
            disciplineService.deleteDiscipline(id);
            responseBuilder.code(ResponseCode.SUCCESS);
        } catch (Exception exception) {
            log.error("DELETE /api/disciplines/{}: {}", id, exception.getMessage());
            responseBuilder.code(ResponseCode.FAILED);
        }
        return responseBuilder.build();
    }

}
