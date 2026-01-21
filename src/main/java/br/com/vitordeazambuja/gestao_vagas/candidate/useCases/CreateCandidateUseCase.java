package br.com.vitordeazambuja.gestao_vagas.candidate.useCases;

import br.com.vitordeazambuja.gestao_vagas.candidate.CandidateEntity;
import br.com.vitordeazambuja.gestao_vagas.candidate.CandidateRepository;
import br.com.vitordeazambuja.gestao_vagas.exceptions.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository
                .findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail())
                .ifPresent((user)->{
                    throw new UserFoundException();
                });

        return this.candidateRepository.save(candidateEntity);
    }
}
