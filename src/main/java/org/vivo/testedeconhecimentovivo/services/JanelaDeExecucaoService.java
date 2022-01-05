package org.vivo.testedeconhecimentovivo.services;

import org.vivo.testedeconhecimentovivo.models.Job;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JanelaDeExecucaoService {

    public List<List<Integer>> execute(List<Job> jobs, LocalDateTime dataInicio, LocalDateTime dataFim) {

        List<List<Integer>> resultado = new ArrayList<>();


        List<Job> jobsFiltrado = jobs.stream().filter(job ->
                        (job.getDataMaximaConclusao().isAfter(dataInicio) || job.getDataMaximaConclusao().isEqual(dataInicio)) &&
                                (job.getDataMaximaConclusao().isBefore(dataFim) || job.getDataMaximaConclusao().isEqual(dataFim))
                ).sorted((job1, job2) -> job1.getDataMaximaConclusao().compareTo(job2.getDataMaximaConclusao()))
                .collect(Collectors.toList());

        System.out.println(jobsFiltrado);



        return null;
    }
}
