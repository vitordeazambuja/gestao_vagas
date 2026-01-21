package br.com.vitordeazambuja.gestao_vagas.company.useCases;

import br.com.vitordeazambuja.gestao_vagas.company.entities.JobEntity;
import br.com.vitordeazambuja.gestao_vagas.company.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {

    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(JobEntity jobEntity) {
        return this.jobRepository.save(jobEntity);
    }
}
