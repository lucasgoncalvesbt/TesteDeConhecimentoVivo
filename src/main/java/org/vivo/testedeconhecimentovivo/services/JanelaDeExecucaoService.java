package org.vivo.testedeconhecimentovivo.services;

import org.vivo.testedeconhecimentovivo.models.Job;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class JanelaDeExecucaoService {

    public List<List<Integer>> execute(List<Job> jobs, LocalDateTime dataInicio, LocalDateTime dataFim) {

        Stack<List<Job>> stackDeExecucao = new Stack<>();

        List<Job> jobsFiltrado = jobs.stream().filter(job ->
                        (job.getDataMaximaConclusao().isAfter(dataInicio) || job.getDataMaximaConclusao().isEqual(dataInicio)) &&
                                (job.getDataMaximaConclusao().isBefore(dataFim) || job.getDataMaximaConclusao().isEqual(dataFim))
                ).sorted((job1, job2) -> job1.getDataMaximaConclusao().compareTo(job2.getDataMaximaConclusao()))
                .collect(Collectors.toList());

        jobsFiltrado.forEach(job -> {
            if (stackDeExecucao.isEmpty()) {
                List<Job> listJobs = new ArrayList<>();
                listJobs.add(job);
                stackDeExecucao.push(listJobs);
            } else {
                List<Job> listJobsInStack = stackDeExecucao.peek();
                int tempoEstimadoTotal = listJobsInStack.stream().mapToInt(Job::getTempoEstimadoEmHoras).sum();
                if(tempoEstimadoTotal + job.getTempoEstimadoEmHoras() <= 8) {
                    listJobsInStack.add(job);
                } else {
                    List<Job> listJobs = new ArrayList<>();
                    listJobs.add(job);
                    stackDeExecucao.push(listJobs);
                }
            }
        });

        return stackDeExecucao.stream().map(listJobs -> listJobs.stream().map(Job::getId).collect(Collectors.toList())).collect(Collectors.toList());

    }
}
