package telran.b7a.accounting.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import telran.b7a.accounting.dao.UserAccountRepository;
import telran.b7a.accounting.dto.RolesResponseDto;
import telran.b7a.accounting.dto.UserAccountResponseDto;
import telran.b7a.accounting.dto.UserRegisterDto;
import telran.b7a.accounting.dto.UserUpdateDto;
import telran.b7a.accounting.dto.exceptions.UserExistsException;
import telran.b7a.accounting.dto.exceptions.UserNotFoundException;
import telran.b7a.accounting.model.UserAccount;

@Service
public class UserAccountServiceImpl implements UserAccountService {
	
	UserAccountRepository repository;
	ModelMapper modelMapper;

	@Autowired
	public UserAccountServiceImpl(UserAccountRepository repository, ModelMapper modelMapper) {
		this.repository = repository;
		this.modelMapper = modelMapper;
	}

	@Override
	public UserAccountResponseDto addUser(UserRegisterDto userRegisterDto) {
		if (repository.existsById(userRegisterDto.getLogin())) {
			throw new UserExistsException(userRegisterDto.getLogin());
		}
		UserAccount userAccount = modelMapper.map(userRegisterDto, UserAccount.class);
		userAccount.addRole("USER".toUpperCase());
		repository.save(userAccount);
		return modelMapper.map(userAccount, UserAccountResponseDto.class);
	}

	@Override
	public UserAccountResponseDto getUser(String login) {
		UserAccount userAccount = repository.findById(login)
				.orElseThrow(() -> new UserNotFoundException(login));
		return modelMapper.map(userAccount, UserAccountResponseDto.class);
	}

	@Override
	public UserAccountResponseDto removeUser(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserAccountResponseDto editUser(String login, UserUpdateDto userUpdateDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RolesResponseDto changeRolesList(String login, String role, boolean isAddRole) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changePassword(String login, String password) {
		// TODO Auto-generated method stub

	}

}
