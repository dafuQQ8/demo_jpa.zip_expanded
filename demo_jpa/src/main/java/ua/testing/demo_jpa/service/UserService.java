package ua.testing.demo_jpa.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.testing.demo_jpa.entity.User;
import ua.testing.demo_jpa.exception.NotFoundException;
import ua.testing.demo_jpa.repository.UserRepository;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    List<User> getUsers() {
        log.info("getCustomers was called");
        return userRepository.findAll();
    }

    User getUser(Long id) {

        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> {
                            NotFoundException notFoundException = new NotFoundException(
                                    "customer with id " + id + " not found");
                            log.error("error in getting customer {}", id, notFoundException);
                            return notFoundException;
                        });
    }
}
//    public UsersDTO getAllUsers() {
//        //TODO checking for an empty user list
//        return new UsersDTO(userRepository.findAll());
//    }
//
////    public Optional<User> findByUserLogin (UserDTO userDTO){
////        //TODO check for user availability. password check
////        return userRepository.findByEmail(userDTO.getEmail());
////    }
//
//    public void saveNewUser (User user){
//        //TODO inform the user about the replay email
//        // TODO exception to endpoint
//        try {
//            userRepository.save(user);
//        } catch (Exception ex){
//            log.info("{Почтовый адрес уже существует}");
//        }
//
//    }
//

