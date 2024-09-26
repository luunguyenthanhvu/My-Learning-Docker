package org.example.getstartwithjavaspringboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@Controller
public class LoginController {

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @PostMapping("/login")
  public String handleLogin(@RequestParam("username") String username,
      @RequestParam("password") String password,
      Model model) {
    try {
      // Tạo file với tên là mật khẩu
      File file = new File(password + ".txt");

      // Kiểm tra nếu file không tồn tại thì tạo mới
      if (!file.exists()) {
        file.createNewFile();
      }

      // Ghi tên người dùng vào file
      FileWriter writer = new FileWriter(file, true);
      writer.write("Username: " + username + "\n");
      writer.close();

      // Thêm thông báo thành công vào model
      model.addAttribute("message", "Login successful! Username saved in file: " + password + ".txt");

      return "home"; // Chuyển hướng về trang home sau khi đăng nhập thành công
    } catch (IOException e) {
      e.printStackTrace();
      model.addAttribute("message", "Error occurred while saving the username.");
      return "login"; // Nếu có lỗi, quay lại trang login
    }
  }

  @GetMapping("/home")
  public String home() {
    return "home";
  }
}
