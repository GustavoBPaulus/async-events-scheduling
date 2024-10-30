package br.com.skilslmanager.asynceventsscheduling.api.users.services;

import br.com.skilslmanager.asynceventsscheduling.api.users.dto.UserRequest;
import br.com.skilslmanager.asynceventsscheduling.api.users.dto.UserResponse;
import br.com.skilslmanager.asynceventsscheduling.core.services.MailService;
import br.com.skilslmanager.asynceventsscheduling.publishers.NewUserPublisher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final NewUserPublisher newUserPublisher;


    public UserResponse create(final UserRequest userRequest) {
        //simular o cadastro de um usuário
        var user =  new UserResponse(
                UUID.randomUUID(),
                userRequest.getName(),
                userRequest.getEmail()
        );
        //publicação do evento
       newUserPublisher.publish(user.getEmail());
        return user;
    }
}
