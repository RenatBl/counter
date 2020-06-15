package ru.itis.counter.services.impls;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.counter.forms.SignUpForm;
import ru.itis.counter.models.User;
import ru.itis.counter.repositories.UsersRepository;
import ru.itis.counter.services.SignUpService;

import java.util.Optional;

@Service
public class SignUpServiceImpl implements SignUpService {

    private final PasswordEncoder encoder;
    private final UsersRepository usersRepository;

    public SignUpServiceImpl(PasswordEncoder encoder, UsersRepository usersRepository) {
        this.encoder = encoder;
        this.usersRepository = usersRepository;
    }

    @Override
    public void signUp(SignUpForm form) {
        Optional<User> user = usersRepository.findByUsername(form.getUsername());
        if (!user.isPresent()) {
            usersRepository.save(User.builder()
                    .username(form.getUsername())
                    .password(encoder.encode(form.getPassword()))
                    .build());
        } else throw new IllegalArgumentException("User already exists");
    }
}
