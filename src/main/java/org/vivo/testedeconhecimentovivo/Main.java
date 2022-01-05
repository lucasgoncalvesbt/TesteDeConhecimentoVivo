package org.vivo.testedeconhecimentovivo;

import org.vivo.testedeconhecimentovivo.models.Job;
import org.vivo.testedeconhecimentovivo.services.JanelaDeExecucaoService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Job job1 = new Job(1,
                "Importação de arquivos de fundos",
                LocalDateTime.parse("2019-11-10 12:00:00", formatter),
                2
        );

        Job job2 = new Job(2,
                "Importação de dados da Base Legada",
                LocalDateTime.parse("2019-11-11 12:00:00", formatter),
                4
        );

        Job job3 = new Job(3,
                "Importação de dados de integração",
                LocalDateTime.parse("2019-11-11 08:00:00", formatter),
                6
        );

        List<Job> jobs = List.of(job1, job2, job3);

        LocalDateTime dataInicio = LocalDateTime.parse("2019-11-10 09:00:00", formatter);
        LocalDateTime dataFim = LocalDateTime.parse("2019-11-11 12:00:00", formatter);

        JanelaDeExecucaoService janelaDeExecucaoService = new JanelaDeExecucaoService();

        List<List<Integer>> listaDeExecucoes = janelaDeExecucaoService.execute(jobs, dataInicio, dataFim);

        System.out.println(listaDeExecucoes);

    }

}
