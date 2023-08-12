package com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.services.cliente;

import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.models.entities.Cliente;
import com.camilo.carrocomprasthymeleaf.carrocomprasthymeleaf.datajpa.app.repository.IClienteRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        List<Cliente> buscarClientes = clienteRepository.findAll();
        return buscarClientes;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Cliente> findAll(Pageable pageable) {
        return clienteRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente finbById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Long id) {
       clienteRepository.deleteById(id);
    }
}
