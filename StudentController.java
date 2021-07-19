package com.neosoft.lara.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neosoft.lara.Dao.StudentRepositry;
import com.neosoft.lara.entity.AuthRequest;
import com.neosoft.lara.entity.Project;
import com.neosoft.lara.entity.Student;
import com.neosoft.lara.service.StudentService;
import com.neosoft.lara.springsecurity.api.jwt.util.JwtUtil;
//import com.neosoft.lara.springsecurity.api.jwt.util.JwtUtil;
import com.neosoft.lara.springsecurity.api.model.User;
import com.neosoft.lara.springsecurity.api.repository.UserRepository;

@RestController
@RequestMapping("/rest/auth")
public class StudentController {


	@RequestMapping("/api")
	public String Test() {
		return "hello world";
	}


	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private StudentService studentService;
	@Autowired
	private StudentRepositry studentRepo;
	//@Autowired
	//private UserRepository userRepositry;
	//@Autowired
	//private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	/*
	 * @PostMapping("/student") public Student save(@RequestBody Student theStudent)
	 * { theStudent.setId(0); studentService.save(theStudent); return theStudent;
	 * 
	 * }
	 */
	@GetMapping("/students/{studentId}")
	public Student findById( @PathVariable int  studentId) {
		Student theStudent = studentService.findById(studentId);
		/*
		 * if(theStudent == null) { throw new RuntimeException("student id not found:" +
		 * studentId); }
		 */
		return theStudent;
	}

	@GetMapping("/students")
	public Page<Student> getAllPosts(Pageable pageable) {
		return studentRepo.findAll(pageable);
	}

	@PostMapping("/students")
	public Student createPost(@Valid @RequestBody Student post) {
		return studentRepo.save(post);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	//@PreAuthorize("hasAnyAuthority('ADMIN')")
	@PostMapping("/admin/add")
	public String addUserByAdmin(@RequestBody User user) {
		String pwd = user.getPassword();
		//String encryptpwd = passwordEncoder.encode(pwd);
		//user.setPassword(encryptpwd);
		//userRepositry.save(user);
		return "user added successfully.....";
	}

	@GetMapping("/jwt")
	public String welcome() {
		return " welcome jwt...";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
					);
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}

}
