package luan.naul.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import luan.naul.Entity.UserInfo;
import luan.naul.Repository.UserInfoRepository;

@Service
public record UserService(UserInfoRepository repository,
							PasswordEncoder passwordEncoder) {
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		repository.save(userInfo);
		return "Them user thanh cong";
	}
}
