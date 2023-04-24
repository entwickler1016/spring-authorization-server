package com.kimblue.auth.api.service;

import com.kimblue.auth.api.dto.UserDTO;
import com.kimblue.auth.api.entity.User;
import com.kimblue.auth.api.global.base.BaseService;
import com.kimblue.auth.api.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements BaseService<UserDTO> {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserDTO> findAll() {

        List<User> entity = userRepository.findAll();

        List<UserDTO> result = entity.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();

        return result;
    }

    @Override
    public UserDTO findById(String id) {

        Optional<User> entity = userRepository.findById(id);

        UserDTO result = entity
                .map(user -> modelMapper.map(user, UserDTO.class))
                .orElseThrow(EntityNotFoundException::new);

        return result;
    }

    @Override
    public UserDTO insert(UserDTO userDTO) {

        User entity = modelMapper.map(userDTO, User.class);
        userRepository.save(entity);

        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }

    @Override
    public UserDTO update(UserDTO userDTO) {

        UserDTO tmp = Optional.ofNullable(findById(userDTO.getUserId())).orElseThrow(EntityNotFoundException::new);

        User entity = modelMapper.map(userDTO, User.class);
        userRepository.save(entity);

        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }

    @Override
    public void delete(String id) {

        UserDTO tmp = Optional.ofNullable(findById(id)).orElseThrow(EntityNotFoundException::new);

        userRepository.deleteById(id);
    }
}
