package com.java.Project.Service.implement;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.java.Project.Service.UserService;
import com.java.Project.UserEntity;
import com.java.Project.UserRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository=new UserRepository() {
        @Override
        public UserEntity findByEmail(String email) {
            return null;
        }

        @Override
        public List<UserEntity> findAll() {
            return null;
        }

        @Override
        public List<UserEntity> findAll(Sort sort) {
            return null;
        }

        @Override
        public List<UserEntity> findAllById(Iterable<Long> iterable) {
            return null;
        }

        @Override
        public <S extends UserEntity> List<S> saveAll(Iterable<S> iterable) {
            return null;
        }

        @Override
        public void flush() {

        }

        @Override
        public <S extends UserEntity> S saveAndFlush(S s) {
            return null;
        }

        @Override
        public void deleteInBatch(Iterable<UserEntity> iterable) {

        }

        @Override
        public void deleteAllInBatch() {

        }

        @Override
        public UserEntity getOne(Long aLong) {
            return null;
        }

        @Override
        public <S extends UserEntity> List<S> findAll(Example<S> example) {
            return null;
        }

        @Override
        public <S extends UserEntity> List<S> findAll(Example<S> example, Sort sort) {
            return null;
        }

        @Override
        public Page<UserEntity> findAll(Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserEntity> S save(S s) {
            return null;
        }

        @Override
        public Optional<UserEntity> findById(Long aLong) {
            return Optional.empty();
        }

        @Override
        public boolean existsById(Long aLong) {
            return false;
        }

        @Override
        public long count() {
            return 0;
        }

        @Override
        public void deleteById(Long aLong) {

        }

        @Override
        public void delete(UserEntity userEntity) {

        }

        @Override
        public void deleteAll(Iterable<? extends UserEntity> iterable) {

        }

        @Override
        public void deleteAll() {

        }

        @Override
        public <S extends UserEntity> Optional<S> findOne(Example<S> example) {
            return Optional.empty();
        }

        @Override
        public <S extends UserEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
            return null;
        }

        @Override
        public <S extends UserEntity> long count(Example<S> example) {
            return 0;
        }

        @Override
        public <S extends UserEntity> boolean exists(Example<S> example) {
            return false;
        }
    };
    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public UserEntity findUserbyEmail(String email){
        return userRepository.findByEmail(email);
    }
    @Override
    public void saveUser(UserEntity user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
