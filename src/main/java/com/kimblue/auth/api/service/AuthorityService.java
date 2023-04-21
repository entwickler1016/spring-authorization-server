package com.kimblue.auth.api.service;

import com.kimblue.auth.api.dto.AuthorityDTO;
import com.kimblue.auth.api.entity.Authority;
import com.kimblue.auth.api.global.base.BaseService;
import com.kimblue.auth.api.repository.AuthorityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorityService implements BaseService<AuthorityDTO> {

    private final ModelMapper modelMapper;
    private final AuthorityRepository authorityRepository;

    @Override
    public List<AuthorityDTO> findAll() {

        List<Authority> entity = authorityRepository.findAll();

        List<AuthorityDTO> result = entity.stream()
                .map(authority -> modelMapper.map(authority, AuthorityDTO.class))
                .toList();
        return result;
    }

    @Override
    public Optional<AuthorityDTO> findById(String id) {

        Optional<Authority> entity = authorityRepository.findById(id);

        AuthorityDTO dto = entity
                .map(authority -> modelMapper.map(authority, AuthorityDTO.class))
                .orElseThrow(EntityNotFoundException::new);

        Optional<AuthorityDTO> result = Optional.ofNullable(dto);
        return result;
    }

    @Override
    public Optional<AuthorityDTO> insert(AuthorityDTO dto) {

        Authority entity = modelMapper.map(dto, Authority.class);

        authorityRepository.save(entity);

        Optional<AuthorityDTO> result = findById(String.valueOf(entity.getAuthorityId()));
        return result;
    }

    @Override
    public Optional<AuthorityDTO> update(AuthorityDTO dto) {

        Authority entity = modelMapper.map(dto, Authority.class);

        authorityRepository.save(entity);

        Optional<AuthorityDTO> result = findById(String.valueOf(entity.getAuthorityId()));
        return result;
    }

    @Override
    public boolean delete(String id) {

        authorityRepository.deleteById(id);

        boolean result = findById(id).isEmpty();
        return result;
    }
}
