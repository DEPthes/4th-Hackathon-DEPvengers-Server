package OneMoment.demo.domain.user.service;

import OneMoment.demo.domain.user.dto.UserDto;
import OneMoment.demo.domain.user.entity.User;
import OneMoment.demo.domain.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void saveUser(String ssaid){
        Optional<User> existUser = userRepository.findBySsaid(ssaid);

        if(existUser.isPresent()){
            return;
        }

        User newUser = new User(ssaid, 0, null);
        userRepository.save(newUser);
    }

    public Integer findStreak(String ssaid){
        Optional<User> existUser = userRepository.findBySsaid(ssaid);

        if(existUser.isPresent()){
            return existUser.get().getStreak();
        }

        return 0;
    }
}
