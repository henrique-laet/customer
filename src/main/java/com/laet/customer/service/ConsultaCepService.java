package com.laet.customer.service;

import com.laet.customer.exception.AddressNotFoundException;
import com.laet.customer.exception.CepNotFoundException;
import com.laet.customer.validation.consultacep.CepResultDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultaCepService {

    public CepResultDTO consultaCep(String cep) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format("https://viacep.com.br/ws/%s/json", cep);
        try {
            ResponseEntity<CepResultDTO> response = restTemplate.getForEntity(url, CepResultDTO.class);
            if (response.getBody().getCep() == null) {
                throw new CepNotFoundException("CEP não encontrado: " + cep);
            } else {
                return response.getBody();
            }
        } catch (HttpClientErrorException e) {
            throw new CepNotFoundException("Erro ao consultar o CEP: " + cep + ". Status code: " + e.getStatusCode());
        }
    }
}
